package com.lsheep.config.client.property.dto.request;

public class QueryPropertyReqDto {

	private Integer propertyId;
	private Boolean child;
	private Boolean all;
	private Boolean withModule;
	private Boolean withProperty;

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

	public Boolean getWithModule() {
		return withModule;
	}

	public void setWithModule(Boolean withModule) {
		this.withModule = withModule;
	}

	public Boolean getWithProperty() {
		return withProperty;
	}

	public void setWithProperty(Boolean withProperty) {
		this.withProperty = withProperty;
	}

}
