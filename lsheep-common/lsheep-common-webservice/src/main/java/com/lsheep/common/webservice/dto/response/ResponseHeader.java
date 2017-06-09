package com.lsheep.common.webservice.dto.response;

import java.util.Date;

public class ResponseHeader {

	private boolean success;
	private Date timestamp = new Date();

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

}
