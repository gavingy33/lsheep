package com.lsheep.common.webservice.dto.response;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TransferResponse<S> {

	private final ResponseHeader header = new ResponseHeader();
	private S model = newInstance();

	public ResponseHeader header() {
		return header;
	}

	public S getModel() {
		return model;
	}

	public void setModel(S model) {
		this.model = model;
	}

	private S newInstance() {
		S instance = null;
		try {
			Type type = getClass().getGenericSuperclass();
			Type[] trueType = ((ParameterizedType) type).getActualTypeArguments();
			@SuppressWarnings("unchecked")
			Class<S> entityClass = (Class<S>) trueType[0];
			instance = entityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return instance;
	}

	public void failure(Exception e) {

	}

}
