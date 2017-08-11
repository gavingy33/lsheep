package com.lsheep.config.restful.property.dto;

import com.lsheep.common.core.tree.AbstractTreeNode;

public class ConfigTreeNode extends AbstractTreeNode {

	private Boolean isModule;
	private String path;

	public Boolean getIsModule() {
		return isModule;
	}

	public void setIsModule(Boolean isModule) {
		this.isModule = isModule;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
