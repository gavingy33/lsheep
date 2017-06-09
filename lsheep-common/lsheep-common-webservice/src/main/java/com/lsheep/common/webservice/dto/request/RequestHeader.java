package com.lsheep.common.webservice.dto.request;

import java.util.Date;

public class RequestHeader {

	private Date timestamp = new Date();

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
