package com.lsheep.common.core.webservice.dto.request;

public class TransferRequest<Q> {

	private final TransferHeader header = new TransferHeader();
	private Q model;

	public TransferHeader getHeader() {
		return header;
	}

	public Q getModel() {
		return model;
	}

	public void setModel(Q model) {
		this.model = model;
	}

}
