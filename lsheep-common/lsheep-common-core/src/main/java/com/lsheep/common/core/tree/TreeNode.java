package com.lsheep.common.core.tree;

import java.util.List;

public abstract class TreeNode {

	private Integer id;
	private String name;
	private String title;
	private List<? extends TreeNode> children;

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

	public List<? extends TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<? extends TreeNode> children) {
		this.children = children;
	}

}
