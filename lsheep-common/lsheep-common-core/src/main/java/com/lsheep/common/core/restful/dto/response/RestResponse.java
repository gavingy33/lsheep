package com.lsheep.common.core.restful.dto.response;

import com.lsheep.common.core.restful.constant.StatusCode;

public class RestResponse<T> {

	private final RestHeader header = new RestHeader();
	private T body;

	public RestHeader getHeader() {
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
