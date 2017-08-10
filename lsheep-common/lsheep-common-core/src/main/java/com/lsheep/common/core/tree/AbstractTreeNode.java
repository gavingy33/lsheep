package com.lsheep.common.core.tree;

import java.util.List;

public abstract class AbstractTreeNode {

	private Integer id;
	private String name;
	private String title;
	private Boolean isParent;
	private List<? extends AbstractTreeNode> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public List<? extends AbstractTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<? extends AbstractTreeNode> children) {
		this.children = children;
	}

}
