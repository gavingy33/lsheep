package com.lsheep.config.client.property.dto.request;

import com.lsheep.common.core.page.PageQuery;

public class QueryPropertyReqDto {

	private Integer propertyId;
	private Integer parentId;
	private Boolean child;
	private Boolean all;
	private Boolean withModule;
	private Boolean withProperty;
	private PageQuery pageQuery;

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
