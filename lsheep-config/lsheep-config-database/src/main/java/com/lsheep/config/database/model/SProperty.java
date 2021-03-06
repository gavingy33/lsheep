package com.lsheep.config.database.model;

import java.util.Date;

public class SProperty {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.PROPERTY_ID
	 * @mbg.generated
	 */
	private Integer propertyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.IS_MODULE
	 * @mbg.generated
	 */
	private Boolean isModule;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.PARENT_ID
	 * @mbg.generated
	 */
	private Integer parentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.PATH
	 * @mbg.generated
	 */
	private String path;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.CODE
	 * @mbg.generated
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.NAME
	 * @mbg.generated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.HASH
	 * @mbg.generated
	 */
	private String hash;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.WEIGHT
	 * @mbg.generated
	 */
	private Integer weight;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.CREATE_DATE
	 * @mbg.generated
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.MODIFY_DATE
	 * @mbg.generated
	 */
	private Date modifyDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.CREATE_USER
	 * @mbg.generated
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.MODIFY_USER
	 * @mbg.generated
	 */
	private String modifyUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.DELETED
	 * @mbg.generated
	 */
	private Boolean deleted;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_PROPERTY.CONTEXT
	 * @mbg.generated
	 */
	private String context;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.PROPERTY_ID
	 * @return  the value of S_PROPERTY.PROPERTY_ID
	 * @mbg.generated
	 */
	public Integer getPropertyId() {
		return propertyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.PROPERTY_ID
	 * @param propertyId  the value for S_PROPERTY.PROPERTY_ID
	 * @mbg.generated
	 */
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.IS_MODULE
	 * @return  the value of S_PROPERTY.IS_MODULE
	 * @mbg.generated
	 */
	public Boolean getIsModule() {
		return isModule;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.IS_MODULE
	 * @param isModule  the value for S_PROPERTY.IS_MODULE
	 * @mbg.generated
	 */
	public void setIsModule(Boolean isModule) {
		this.isModule = isModule;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.PARENT_ID
	 * @return  the value of S_PROPERTY.PARENT_ID
	 * @mbg.generated
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.PARENT_ID
	 * @param parentId  the value for S_PROPERTY.PARENT_ID
	 * @mbg.generated
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.PATH
	 * @return  the value of S_PROPERTY.PATH
	 * @mbg.generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.PATH
	 * @param path  the value for S_PROPERTY.PATH
	 * @mbg.generated
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.CODE
	 * @return  the value of S_PROPERTY.CODE
	 * @mbg.generated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.CODE
	 * @param code  the value for S_PROPERTY.CODE
	 * @mbg.generated
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.NAME
	 * @return  the value of S_PROPERTY.NAME
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.NAME
	 * @param name  the value for S_PROPERTY.NAME
	 * @mbg.generated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.HASH
	 * @return  the value of S_PROPERTY.HASH
	 * @mbg.generated
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.HASH
	 * @param hash  the value for S_PROPERTY.HASH
	 * @mbg.generated
	 */
	public void setHash(String hash) {
		this.hash = hash == null ? null : hash.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.WEIGHT
	 * @return  the value of S_PROPERTY.WEIGHT
	 * @mbg.generated
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.WEIGHT
	 * @param weight  the value for S_PROPERTY.WEIGHT
	 * @mbg.generated
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.CREATE_DATE
	 * @return  the value of S_PROPERTY.CREATE_DATE
	 * @mbg.generated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.CREATE_DATE
	 * @param createDate  the value for S_PROPERTY.CREATE_DATE
	 * @mbg.generated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.MODIFY_DATE
	 * @return  the value of S_PROPERTY.MODIFY_DATE
	 * @mbg.generated
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.MODIFY_DATE
	 * @param modifyDate  the value for S_PROPERTY.MODIFY_DATE
	 * @mbg.generated
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.CREATE_USER
	 * @return  the value of S_PROPERTY.CREATE_USER
	 * @mbg.generated
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.CREATE_USER
	 * @param createUser  the value for S_PROPERTY.CREATE_USER
	 * @mbg.generated
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.MODIFY_USER
	 * @return  the value of S_PROPERTY.MODIFY_USER
	 * @mbg.generated
	 */
	public String getModifyUser() {
		return modifyUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.MODIFY_USER
	 * @param modifyUser  the value for S_PROPERTY.MODIFY_USER
	 * @mbg.generated
	 */
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser == null ? null : modifyUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.DELETED
	 * @return  the value of S_PROPERTY.DELETED
	 * @mbg.generated
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.DELETED
	 * @param deleted  the value for S_PROPERTY.DELETED
	 * @mbg.generated
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_PROPERTY.CONTEXT
	 * @return  the value of S_PROPERTY.CONTEXT
	 * @mbg.generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_PROPERTY.CONTEXT
	 * @param context  the value for S_PROPERTY.CONTEXT
	 * @mbg.generated
	 */
	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}
}