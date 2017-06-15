package com.lsheep.common.webservice.dto.request;

public class TransferRequest<T> {

	private RequestHeader header = new RequestHeader();
	private T model;

	public TransferRequest() {
	}

	public TransferRequest(Class<T> clazz) {
		T model = null;
		try {
			model = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		this.model = model;
	}

	public RequestHeader header() {
		return header;
	}

	public T model() {
		return model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public RequestHeader getHeader() {
		return header;
	}

}
