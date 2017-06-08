package com.lsheep.common.core.webservice.dto.response;

public class TransferResponse<S> {

	private final TransferHeader header = new TransferHeader();
	private S model;

	public TransferHeader getHeader() {
		return header;
	}

	public S getModel() {
		return model;
	}

	public void setModel(S model) {
		this.model = model;
	}

}
