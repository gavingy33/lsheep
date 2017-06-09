package com.lsheep.common.webservice.dto.request;

public class TransferRequest<Q> {

	private final RequestHeader header = new RequestHeader();
	private Q model;

	public RequestHeader header() {
		return header;
	}

	public Q getModel() {
		return model;
	}

	public void setModel(Q model) {
		this.model = model;
	}

}
