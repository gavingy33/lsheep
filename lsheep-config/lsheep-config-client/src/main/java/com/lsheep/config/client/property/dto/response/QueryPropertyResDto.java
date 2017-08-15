package com.lsheep.config.client.property.dto.response;

import java.util.List;

import com.lsheep.common.core.page.PageData;

public class QueryPropertyResDto {

	private PageData<PropertyNode> pageData;

	public List<PropertyNode> getPropertyNodes() {
		return pageData == null ? null : pageData.getRows();
	}

	public void setPropertyNodes(List<PropertyNode> propertyNodes) {
		if (pageData == null) {
			pageData = new PageData<>();
		}
		pageData.setRows(propertyNodes);
	}

	public PageData<PropertyNode> getPageData() {
		return pageData;
	}

	public void setPageData(PageData<PropertyNode> pageData) {
		this.pageData = pageData;
	}

}
