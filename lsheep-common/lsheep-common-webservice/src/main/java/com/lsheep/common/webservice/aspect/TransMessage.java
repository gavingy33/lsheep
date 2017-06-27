package com.lsheep.common.webservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.lsheep.common.core.base.Base;
import com.lsheep.common.webservice.dto.response.TransferResponse;

public class TransMessage extends Base {

	public Object localProceed(ProceedingJoinPoint joinPoint) {
		logger.info("本地调用切面进入");
		TransferResponse<?> transferResponse = new TransferResponse<>();
		try {
			transferResponse = (TransferResponse<?>) joinPoint.proceed();
		} catch (Throwable e) {
			transferResponse.failure(e);
		} finally {
		}
		return transferResponse;
	}

}
