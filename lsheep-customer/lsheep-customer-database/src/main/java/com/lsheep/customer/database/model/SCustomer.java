package com.lsheep.customer.database.model;

import java.util.Date;

public class SCustomer {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.CUSTOMER_ID
	 * @mbg.generated
	 */
	private String customerId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.USERNAME
	 * @mbg.generated
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.PASSWORD
	 * @mbg.generated
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.MOBILE
	 * @mbg.generated
	 */
	private String mobile;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.CREATE_USER
	 * @mbg.generated
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.CREATE_DATE
	 * @mbg.generated
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.MODIFY_USER
	 * @mbg.generated
	 */
	private String modifyUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.MODIFY_DATE
	 * @mbg.generated
	 */
	private Date modifyDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_CUSTOMER.DELETED
	 * @mbg.generated
	 */
	private Boolean deleted;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.CUSTOMER_ID
	 * @return  the value of S_CUSTOMER.CUSTOMER_ID
	 * @mbg.generated
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.CUSTOMER_ID
	 * @param customerId  the value for S_CUSTOMER.CUSTOMER_ID
	 * @mbg.generated
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId == null ? null : customerId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.USERNAME
	 * @return  the value of S_CUSTOMER.USERNAME
	 * @mbg.generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.USERNAME
	 * @param username  the value for S_CUSTOMER.USERNAME
	 * @mbg.generated
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.PASSWORD
	 * @return  the value of S_CUSTOMER.PASSWORD
	 * @mbg.generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.PASSWORD
	 * @param password  the value for S_CUSTOMER.PASSWORD
	 * @mbg.generated
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.MOBILE
	 * @return  the value of S_CUSTOMER.MOBILE
	 * @mbg.generated
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.MOBILE
	 * @param mobile  the value for S_CUSTOMER.MOBILE
	 * @mbg.generated
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.CREATE_USER
	 * @return  the value of S_CUSTOMER.CREATE_USER
	 * @mbg.generated
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.CREATE_USER
	 * @param createUser  the value for S_CUSTOMER.CREATE_USER
	 * @mbg.generated
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.CREATE_DATE
	 * @return  the value of S_CUSTOMER.CREATE_DATE
	 * @mbg.generated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.CREATE_DATE
	 * @param createDate  the value for S_CUSTOMER.CREATE_DATE
	 * @mbg.generated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.MODIFY_USER
	 * @return  the value of S_CUSTOMER.MODIFY_USER
	 * @mbg.generated
	 */
	public String getModifyUser() {
		return modifyUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.MODIFY_USER
	 * @param modifyUser  the value for S_CUSTOMER.MODIFY_USER
	 * @mbg.generated
	 */
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser == null ? null : modifyUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.MODIFY_DATE
	 * @return  the value of S_CUSTOMER.MODIFY_DATE
	 * @mbg.generated
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.MODIFY_DATE
	 * @param modifyDate  the value for S_CUSTOMER.MODIFY_DATE
	 * @mbg.generated
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_CUSTOMER.DELETED
	 * @return  the value of S_CUSTOMER.DELETED
	 * @mbg.generated
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_CUSTOMER.DELETED
	 * @param deleted  the value for S_CUSTOMER.DELETED
	 * @mbg.generated
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}