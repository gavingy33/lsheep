package com.lsheep.common.webservice.dto.response;

public class TransferResponse<T> {

	private ResponseHeader header = new ResponseHeader();
	private T model;

	public TransferResponse() {
	}

	public TransferResponse(Class<T> clazz) {
		T model = null;
		try {
			model = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		this.model = model;
	}

	public ResponseHeader header() {
		return header;
	}

	public T model() {
		return model;
	}

	public ResponseHeader getHeader() {
		return header;
	}

	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public void failure(Exception e) {
		e.printStackTrace();
	}

}
