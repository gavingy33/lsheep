package com.lsheep.config.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SPropertyExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public SPropertyExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andPropertyIdIsNull() {
			addCriterion("PROPERTY_ID is null");
			return (Criteria) this;
		}

		public Criteria andPropertyIdIsNotNull() {
			addCriterion("PROPERTY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyIdEqualTo(Integer value) {
			addCriterion("PROPERTY_ID =", value, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdNotEqualTo(Integer value) {
			addCriterion("PROPERTY_ID <>", value, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdGreaterThan(Integer value) {
			addCriterion("PROPERTY_ID >", value, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PROPERTY_ID >=", value, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdLessThan(Integer value) {
			addCriterion("PROPERTY_ID <", value, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdLessThanOrEqualTo(Integer value) {
			addCriterion("PROPERTY_ID <=", value, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdIn(List<Integer> values) {
			addCriterion("PROPERTY_ID in", values, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdNotIn(List<Integer> values) {
			addCriterion("PROPERTY_ID not in", values, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdBetween(Integer value1, Integer value2) {
			addCriterion("PROPERTY_ID between", value1, value2, "propertyId");
			return (Criteria) this;
		}

		public Criteria andPropertyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PROPERTY_ID not between", value1, value2, "propertyId");
			return (Criteria) this;
		}

		public Criteria andIsModuleIsNull() {
			addCriterion("IS_MODULE is null");
			return (Criteria) this;
		}

		public Criteria andIsModuleIsNotNull() {
			addCriterion("IS_MODULE is not null");
			return (Criteria) this;
		}

		public Criteria andIsModuleEqualTo(Boolean value) {
			addCriterion("IS_MODULE =", value, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleNotEqualTo(Boolean value) {
			addCriterion("IS_MODULE <>", value, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleGreaterThan(Boolean value) {
			addCriterion("IS_MODULE >", value, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_MODULE >=", value, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleLessThan(Boolean value) {
			addCriterion("IS_MODULE <", value, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_MODULE <=", value, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleIn(List<Boolean> values) {
			addCriterion("IS_MODULE in", values, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleNotIn(List<Boolean> values) {
			addCriterion("IS_MODULE not in", values, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_MODULE between", value1, value2, "isModule");
			return (Criteria) this;
		}

		public Criteria andIsModuleNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_MODULE not between", value1, value2, "isModule");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNull() {
			addCriterion("PARENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("PARENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(Integer value) {
			addCriterion("PARENT_ID =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(Integer value) {
			addCriterion("PARENT_ID <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(Integer value) {
			addCriterion("PARENT_ID >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARENT_ID >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(Integer value) {
			addCriterion("PARENT_ID <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARENT_ID <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<Integer> values) {
			addCriterion("PARENT_ID in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<Integer> values) {
			addCriterion("PARENT_ID not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(Integer value1, Integer value2) {
			addCriterion("PARENT_ID between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARENT_ID not between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andPathIsNull() {
			addCriterion("PATH is null");
			return (Criteria) this;
		}

		public Criteria andPathIsNotNull() {
			addCriterion("PATH is not null");
			return (Criteria) this;
		}

		public Criteria andPathEqualTo(String value) {
			addCriterion("PATH =", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotEqualTo(String value) {
			addCriterion("PATH <>", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThan(String value) {
			addCriterion("PATH >", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThanOrEqualTo(String value) {
			addCriterion("PATH >=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThan(String value) {
			addCriterion("PATH <", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThanOrEqualTo(String value) {
			addCriterion("PATH <=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLike(String value) {
			addCriterion("PATH like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotLike(String value) {
			addCriterion("PATH not like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathIn(List<String> values) {
			addCriterion("PATH in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotIn(List<String> values) {
			addCriterion("PATH not in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathBetween(String value1, String value2) {
			addCriterion("PATH between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotBetween(String value1, String value2) {
			addCriterion("PATH not between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andHashIsNull() {
			addCriterion("HASH is null");
			return (Criteria) this;
		}

		public Criteria andHashIsNotNull() {
			addCriterion("HASH is not null");
			return (Criteria) this;
		}

		public Criteria andHashEqualTo(String value) {
			addCriterion("HASH =", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashNotEqualTo(String value) {
			addCriterion("HASH <>", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashGreaterThan(String value) {
			addCriterion("HASH >", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashGreaterThanOrEqualTo(String value) {
			addCriterion("HASH >=", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashLessThan(String value) {
			addCriterion("HASH <", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashLessThanOrEqualTo(String value) {
			addCriterion("HASH <=", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashLike(String value) {
			addCriterion("HASH like", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashNotLike(String value) {
			addCriterion("HASH not like", value, "hash");
			return (Criteria) this;
		}

		public Criteria andHashIn(List<String> values) {
			addCriterion("HASH in", values, "hash");
			return (Criteria) this;
		}

		public Criteria andHashNotIn(List<String> values) {
			addCriterion("HASH not in", values, "hash");
			return (Criteria) this;
		}

		public Criteria andHashBetween(String value1, String value2) {
			addCriterion("HASH between", value1, value2, "hash");
			return (Criteria) this;
		}

		public Criteria andHashNotBetween(String value1, String value2) {
			addCriterion("HASH not between", value1, value2, "hash");
			return (Criteria) this;
		}

		public Criteria andWeightIsNull() {
			addCriterion("WEIGHT is null");
			return (Criteria) this;
		}

		public Criteria andWeightIsNotNull() {
			addCriterion("WEIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andWeightEqualTo(Integer value) {
			addCriterion("WEIGHT =", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotEqualTo(Integer value) {
			addCriterion("WEIGHT <>", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThan(Integer value) {
			addCriterion("WEIGHT >", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("WEIGHT >=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThan(Integer value) {
			addCriterion("WEIGHT <", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightLessThanOrEqualTo(Integer value) {
			addCriterion("WEIGHT <=", value, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightIn(List<Integer> values) {
			addCriterion("WEIGHT in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotIn(List<Integer> values) {
			addCriterion("WEIGHT not in", values, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightBetween(Integer value1, Integer value2) {
			addCriterion("WEIGHT between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andWeightNotBetween(Integer value1, Integer value2) {
			addCriterion("WEIGHT not between", value1, value2, "weight");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("CREATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("CREATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("CREATE_DATE =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("CREATE_DATE <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("CREATE_DATE >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_DATE >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("CREATE_DATE <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_DATE <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("CREATE_DATE in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("CREATE_DATE not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("CREATE_DATE between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_DATE not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateIsNull() {
			addCriterion("MODIFY_DATE is null");
			return (Criteria) this;
		}

		public Criteria andModifyDateIsNotNull() {
			addCriterion("MODIFY_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andModifyDateEqualTo(Date value) {
			addCriterion("MODIFY_DATE =", value, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateNotEqualTo(Date value) {
			addCriterion("MODIFY_DATE <>", value, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateGreaterThan(Date value) {
			addCriterion("MODIFY_DATE >", value, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
			addCriterion("MODIFY_DATE >=", value, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateLessThan(Date value) {
			addCriterion("MODIFY_DATE <", value, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateLessThanOrEqualTo(Date value) {
			addCriterion("MODIFY_DATE <=", value, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateIn(List<Date> values) {
			addCriterion("MODIFY_DATE in", values, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateNotIn(List<Date> values) {
			addCriterion("MODIFY_DATE not in", values, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateBetween(Date value1, Date value2) {
			addCriterion("MODIFY_DATE between", value1, value2, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andModifyDateNotBetween(Date value1, Date value2) {
			addCriterion("MODIFY_DATE not between", value1, value2, "modifyDate");
			return (Criteria) this;
		}

		public Criteria andCreateUserIsNull() {
			addCriterion("CREATE_USER is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIsNotNull() {
			addCriterion("CREATE_USER is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserEqualTo(String value) {
			addCriterion("CREATE_USER =", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserNotEqualTo(String value) {
			addCriterion("CREATE_USER <>", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserGreaterThan(String value) {
			addCriterion("CREATE_USER >", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_USER >=", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserLessThan(String value) {
			addCriterion("CREATE_USER <", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserLessThanOrEqualTo(String value) {
			addCriterion("CREATE_USER <=", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserLike(String value) {
			addCriterion("CREATE_USER like", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserNotLike(String value) {
			addCriterion("CREATE_USER not like", value, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserIn(List<String> values) {
			addCriterion("CREATE_USER in", values, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserNotIn(List<String> values) {
			addCriterion("CREATE_USER not in", values, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserBetween(String value1, String value2) {
			addCriterion("CREATE_USER between", value1, value2, "createUser");
			return (Criteria) this;
		}

		public Criteria andCreateUserNotBetween(String value1, String value2) {
			addCriterion("CREATE_USER not between", value1, value2, "createUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserIsNull() {
			addCriterion("MODIFY_USER is null");
			return (Criteria) this;
		}

		public Criteria andModifyUserIsNotNull() {
			addCriterion("MODIFY_USER is not null");
			return (Criteria) this;
		}

		public Criteria andModifyUserEqualTo(String value) {
			addCriterion("MODIFY_USER =", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserNotEqualTo(String value) {
			addCriterion("MODIFY_USER <>", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserGreaterThan(String value) {
			addCriterion("MODIFY_USER >", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
			addCriterion("MODIFY_USER >=", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserLessThan(String value) {
			addCriterion("MODIFY_USER <", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserLessThanOrEqualTo(String value) {
			addCriterion("MODIFY_USER <=", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserLike(String value) {
			addCriterion("MODIFY_USER like", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserNotLike(String value) {
			addCriterion("MODIFY_USER not like", value, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserIn(List<String> values) {
			addCriterion("MODIFY_USER in", values, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserNotIn(List<String> values) {
			addCriterion("MODIFY_USER not in", values, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserBetween(String value1, String value2) {
			addCriterion("MODIFY_USER between", value1, value2, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andModifyUserNotBetween(String value1, String value2) {
			addCriterion("MODIFY_USER not between", value1, value2, "modifyUser");
			return (Criteria) this;
		}

		public Criteria andDeletedIsNull() {
			addCriterion("DELETED is null");
			return (Criteria) this;
		}

		public Criteria andDeletedIsNotNull() {
			addCriterion("DELETED is not null");
			return (Criteria) this;
		}

		public Criteria andDeletedEqualTo(Boolean value) {
			addCriterion("DELETED =", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotEqualTo(Boolean value) {
			addCriterion("DELETED <>", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedGreaterThan(Boolean value) {
			addCriterion("DELETED >", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("DELETED >=", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedLessThan(Boolean value) {
			addCriterion("DELETED <", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
			addCriterion("DELETED <=", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedIn(List<Boolean> values) {
			addCriterion("DELETED in", values, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotIn(List<Boolean> values) {
			addCriterion("DELETED not in", values, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
			addCriterion("DELETED between", value1, value2, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("DELETED not between", value1, value2, "deleted");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table S_PROPERTY
	 * @mbg.generated
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table S_PROPERTY
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}