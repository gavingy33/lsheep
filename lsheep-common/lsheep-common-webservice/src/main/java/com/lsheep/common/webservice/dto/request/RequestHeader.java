package com.lsheep.common.webservice.dto.request;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class RequestHeader {

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp = new Date();

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
