package com.lsheep.config.restful.property.dto;

import com.lsheep.common.core.page.PageQuery;

public class PropertyPageQuery extends PageQuery {

	private Integer parentId;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
