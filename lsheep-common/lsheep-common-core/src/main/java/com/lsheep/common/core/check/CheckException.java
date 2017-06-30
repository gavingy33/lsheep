package com.lsheep.common.core.check;

public class CheckException extends RuntimeException {

	private static final long serialVersionUID = -8448028359003529991L;

	public CheckException() {
		super();
	}

	public CheckException(String message) {
		super(message);
	}

	public CheckException(Throwable cause) {
		super(cause);
	}

	public CheckException(String message, Throwable cause) {
		super(message, cause);
	}

}
