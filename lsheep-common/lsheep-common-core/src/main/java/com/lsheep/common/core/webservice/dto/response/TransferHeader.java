package com.lsheep.common.core.webservice.dto.response;

import java.util.Date;

public class TransferHeader {

	private boolean success;
	private Date timestamp;

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
