package com.lsheep.common.webservice.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.Base;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.middleware.mq.MqProducer;
import com.lsheep.middleware.mq.model.MqMessage;

public class TransMessage extends Base {

	// 平台交互报文TOPIC
	private final String TOPIC = "platform_transfer_message";
	private final String TAG_REQUEST = "request";
	private final String TAG_RESPONSE = "response";

	@Resource
	private MqProducer mqProducer;

	public Object proceed(ProceedingJoinPoint joinPoint) {
		long start = System.currentTimeMillis();
		TransferResponse<?> transferResponse = new TransferResponse<>();
		Signature signature = joinPoint.getSignature();
		String className = null;
		String methodName = signature.getName();
		try {
			Class<?> targetClass = joinPoint.getTarget().getClass();
			Object[] arguments = joinPoint.getArgs();
			if (targetClass.getName().startsWith("com.sun.proxy")) {
				// CXF代理,远程方法调用
				className = signature.getDeclaringTypeName();
			} else {
				// 本地方法调用
				className = targetClass.getName();
			}
			String request = JSON.toJSONString(arguments[0], true);
			logger.info("访问方法:{}.{}开始,入参:\n{}", className, methodName, request);
			MqMessage<?> mqMessage = new MqMessage<>();
			mqMessage.setTopic(TOPIC);
			mqMessage.setTag(TAG_REQUEST);
			mqMessage.setModel(null);
			mqProducer.send(mqMessage);
			transferResponse = (TransferResponse<?>) joinPoint.proceed();
		} catch (Throwable e) {
			transferResponse.failure(e);
		} finally {
			String response = JSON.toJSONString(transferResponse, true);
			long time = System.currentTimeMillis() - start;
			logger.info("访问方法:{}.{}结束,耗时:{}毫秒,出参:\n{}", className, methodName, time, response);
			MqMessage<?> mqMessage = new MqMessage<>();
			mqMessage.setTopic(TOPIC);
			mqMessage.setTag(TAG_RESPONSE);
			mqMessage.setModel(null);
			mqProducer.send(mqMessage);
		}
		return transferResponse;
	}

}
