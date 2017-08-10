package com.lsheep.config.client.property.dto.request;

public class QueryPropertyReqDto {

	private Integer propertyId;
	private Boolean child;
	private Boolean all;

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public Boolean getChild() {
		return child;
	}

	public void setChild(Boolean child) {
		this.child = child;
	}

	public Boolean getAll() {
		return all;
	}

	public void setAll(Boolean all) {
		this.all = all;
	}

}
