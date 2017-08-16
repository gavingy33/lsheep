package com.lsheep.config.restful.property.dto;

import com.lsheep.common.core.page.PageQuery;

public class PropertyPageQuery extends PageQuery {

	private Integer parentId;
	private Boolean withModule;
	private Boolean withProperty;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
