package com.lsheep.common.core.restful.dto.response;

import com.lsheep.common.core.restful.constant.StatusCode;

public class RestResponse<T> {

	private final ResponseHeader header = new ResponseHeader();
	private T body;

	public ResponseHeader getHeader() {
		return header;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public RestResponse<T> failure(Exception e) {
		header.setStatusCode(StatusCode.SERVER_ERROR);
		header.setMessage(e.getMessage());
		return this;
	}

	public void failure(String message, Throwable t) {

	}

}
