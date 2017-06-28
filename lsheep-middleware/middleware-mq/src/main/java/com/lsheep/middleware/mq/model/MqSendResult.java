package com.lsheep.middleware.mq.model;

public class MqSendResult {

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void success() {
		this.success = true;
	}

}
