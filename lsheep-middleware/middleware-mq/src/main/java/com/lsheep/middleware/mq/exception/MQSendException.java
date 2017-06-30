package com.lsheep.middleware.mq.exception;

public class MQSendException extends Exception {

	private static final long serialVersionUID = 1177887099288451572L;

	public MQSendException() {
		super();
	}

	public MQSendException(String message) {
		super(message);
	}

	public MQSendException(Throwable cause) {
		super(cause);
	}

	public MQSendException(String message, Throwable cause) {
		super(message, cause);
	}

}
