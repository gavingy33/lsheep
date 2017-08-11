package com.lsheep.common.core.restful.dto.response;

import com.lsheep.common.core.restful.constant.StatusCode;

public class RestHeader {

	private Integer statusCode = StatusCode.OK;
	private String redirectUrl;
	private String message;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
