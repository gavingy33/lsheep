package com.lsheep.common.webservice.dto.response;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ResponseHeader {

	private boolean success = true;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp = new Date();

	private String message;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean success() {
		return this.success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}
}
