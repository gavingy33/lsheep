package com.lsheep.common.webservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.Base;
import com.lsheep.common.webservice.dto.response.TransferResponse;

public class TransMessage extends Base {

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
			transferResponse = (TransferResponse<?>) joinPoint.proceed();
		} catch (Throwable e) {
			transferResponse.failure(e);
		} finally {
			String response = JSON.toJSONString(transferResponse, true);
			long time = System.currentTimeMillis() - start;
			logger.info("访问方法:{}.{}结束,耗时:{},出参:\n{}", className, methodName, time, response);
		}
		return transferResponse;
	}

}
