package com.lsheep.common.webservice.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.Base;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.common.webservice.handler.ExceptionHandler;
import com.lsheep.middleware.mq.MqProducer;
import com.lsheep.middleware.mq.model.MqMessage;
import com.lsheep.middleware.mq.topic.PlatformTransferMessage;
import com.lsheep.middleware.mq.topic.PlatformTransferMessage.EnumTopicTag;

public class TransMessage extends Base {

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
			TransferRequest<?> transferRequest = (TransferRequest<?>) arguments[0];
			String request = JSON.toJSONString(transferRequest, true);
			logger.info("访问方法:{}.{}开始,入参:\n{}", className, methodName, request);
			MqMessage<TransferRequest<?>> mqMessage = new MqMessage<>();
			mqMessage.setTopic(new PlatformTransferMessage(EnumTopicTag.REQUEST));
			mqMessage.setModel(transferRequest);
			mqProducer.send(mqMessage);
			transferResponse = (TransferResponse<?>) joinPoint.proceed();
		} catch (Throwable e) {
			ExceptionHandler.handler(transferResponse, e);
		} finally {
			String response = JSON.toJSONString(transferResponse, true);
			long time = System.currentTimeMillis() - start;
			logger.info("访问方法:{}.{}结束,耗时:{}毫秒,出参:\n{}", className, methodName, time, response);
			MqMessage<TransferResponse<?>> mqMessage = new MqMessage<>();
			mqMessage.setTopic(new PlatformTransferMessage(EnumTopicTag.RESPONSE));
			mqMessage.setModel(transferResponse);
			mqProducer.send(mqMessage);
		}
		return transferResponse;
	}

}
