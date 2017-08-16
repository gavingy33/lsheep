package com.lsheep.config.client.property.dto.request;

import java.util.List;

public class BatchUpdateReqDto {

	private List<Property> properties;

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
