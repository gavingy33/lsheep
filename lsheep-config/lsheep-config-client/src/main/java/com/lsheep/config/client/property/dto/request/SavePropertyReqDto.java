package com.lsheep.config.client.property.dto.request;

public class SavePropertyReqDto {

	private Boolean isModule;
	private Integer parentId;
	private String path;
	private String code;
	private String name;
	private String context;
	private Integer weight;

	public Boolean getIsModule() {
		return isModule;
	}

	public void setIsModule(Boolean isModule) {
		this.isModule = isModule;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
