package com.lsheep.common.webservice.handler;

import com.lsheep.common.webservice.dto.response.TransferResponse;

public class ExceptionHandler {

	public static void handler(TransferResponse<?> response, Throwable t) {
		response.failure(t);
	}

}
