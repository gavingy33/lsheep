package com.lsheep.common.webservice.dto.response;

public class TransferResponse<S> {

	private final ResponseHeader header = new ResponseHeader();
	private S model;

	public ResponseHeader header() {
		return header;
	}

	public S getModel() {
		return model;
	}

	public void setModel(S model) {
		this.model = model;
	}

}
