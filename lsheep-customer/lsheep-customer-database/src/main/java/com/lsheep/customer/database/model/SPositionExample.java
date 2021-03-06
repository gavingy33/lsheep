package com.lsheep.customer.database.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SPositionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public SPositionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_POSITION
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table S_POSITION
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

		public Criteria andPositionIdIsNull() {
			addCriterion("POSITION_ID is null");
			return (Criteria) this;
		}

		public Criteria andPositionIdIsNotNull() {
			addCriterion("POSITION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPositionIdEqualTo(Integer value) {
			addCriterion("POSITION_ID =", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdNotEqualTo(Integer value) {
			addCriterion("POSITION_ID <>", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdGreaterThan(Integer value) {
			addCriterion("POSITION_ID >", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("POSITION_ID >=", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdLessThan(Integer value) {
			addCriterion("POSITION_ID <", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdLessThanOrEqualTo(Integer value) {
			addCriterion("POSITION_ID <=", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdIn(List<Integer> values) {
			addCriterion("POSITION_ID in", values, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdNotIn(List<Integer> values) {
			addCriterion("POSITION_ID not in", values, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdBetween(Integer value1, Integer value2) {
			addCriterion("POSITION_ID between", value1, value2, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("POSITION_ID not between", value1, value2, "positionId");
			return (Criteria) this;
		}

		public Criteria andOperateIpIsNull() {
			addCriterion("OPERATE_IP is null");
			return (Criteria) this;
		}

		public Criteria andOperateIpIsNotNull() {
			addCriterion("OPERATE_IP is not null");
			return (Criteria) this;
		}

		public Criteria andOperateIpEqualTo(String value) {
			addCriterion("OPERATE_IP =", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpNotEqualTo(String value) {
			addCriterion("OPERATE_IP <>", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpGreaterThan(String value) {
			addCriterion("OPERATE_IP >", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpGreaterThanOrEqualTo(String value) {
			addCriterion("OPERATE_IP >=", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpLessThan(String value) {
			addCriterion("OPERATE_IP <", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpLessThanOrEqualTo(String value) {
			addCriterion("OPERATE_IP <=", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpLike(String value) {
			addCriterion("OPERATE_IP like", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpNotLike(String value) {
			addCriterion("OPERATE_IP not like", value, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpIn(List<String> values) {
			addCriterion("OPERATE_IP in", values, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpNotIn(List<String> values) {
			addCriterion("OPERATE_IP not in", values, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpBetween(String value1, String value2) {
			addCriterion("OPERATE_IP between", value1, value2, "operateIp");
			return (Criteria) this;
		}

		public Criteria andOperateIpNotBetween(String value1, String value2) {
			addCriterion("OPERATE_IP not between", value1, value2, "operateIp");
			return (Criteria) this;
		}

		public Criteria andAuthorizeIsNull() {
			addCriterion("AUTHORIZE is null");
			return (Criteria) this;
		}

		public Criteria andAuthorizeIsNotNull() {
			addCriterion("AUTHORIZE is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorizeEqualTo(Boolean value) {
			addCriterion("AUTHORIZE =", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeNotEqualTo(Boolean value) {
			addCriterion("AUTHORIZE <>", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeGreaterThan(Boolean value) {
			addCriterion("AUTHORIZE >", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("AUTHORIZE >=", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeLessThan(Boolean value) {
			addCriterion("AUTHORIZE <", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeLessThanOrEqualTo(Boolean value) {
			addCriterion("AUTHORIZE <=", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeIn(List<Boolean> values) {
			addCriterion("AUTHORIZE in", values, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeNotIn(List<Boolean> values) {
			addCriterion("AUTHORIZE not in", values, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeBetween(Boolean value1, Boolean value2) {
			addCriterion("AUTHORIZE between", value1, value2, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("AUTHORIZE not between", value1, value2, "authorize");
			return (Criteria) this;
		}

		public Criteria andModuleIsNull() {
			addCriterion("MODULE is null");
			return (Criteria) this;
		}

		public Criteria andModuleIsNotNull() {
			addCriterion("MODULE is not null");
			return (Criteria) this;
		}

		public Criteria andModuleEqualTo(String value) {
			addCriterion("MODULE =", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleNotEqualTo(String value) {
			addCriterion("MODULE <>", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleGreaterThan(String value) {
			addCriterion("MODULE >", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleGreaterThanOrEqualTo(String value) {
			addCriterion("MODULE >=", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleLessThan(String value) {
			addCriterion("MODULE <", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleLessThanOrEqualTo(String value) {
			addCriterion("MODULE <=", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleLike(String value) {
			addCriterion("MODULE like", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleNotLike(String value) {
			addCriterion("MODULE not like", value, "module");
			return (Criteria) this;
		}

		public Criteria andModuleIn(List<String> values) {
			addCriterion("MODULE in", values, "module");
			return (Criteria) this;
		}

		public Criteria andModuleNotIn(List<String> values) {
			addCriterion("MODULE not in", values, "module");
			return (Criteria) this;
		}

		public Criteria andModuleBetween(String value1, String value2) {
			addCriterion("MODULE between", value1, value2, "module");
			return (Criteria) this;
		}

		public Criteria andModuleNotBetween(String value1, String value2) {
			addCriterion("MODULE not between", value1, value2, "module");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("TYPE =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("TYPE <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("TYPE >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TYPE >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("TYPE <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("TYPE <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("TYPE like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("TYPE not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("TYPE in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("TYPE not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("TYPE between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("TYPE not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andAdcodeIsNull() {
			addCriterion("ADCODE is null");
			return (Criteria) this;
		}

		public Criteria andAdcodeIsNotNull() {
			addCriterion("ADCODE is not null");
			return (Criteria) this;
		}

		public Criteria andAdcodeEqualTo(String value) {
			addCriterion("ADCODE =", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeNotEqualTo(String value) {
			addCriterion("ADCODE <>", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeGreaterThan(String value) {
			addCriterion("ADCODE >", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeGreaterThanOrEqualTo(String value) {
			addCriterion("ADCODE >=", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeLessThan(String value) {
			addCriterion("ADCODE <", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeLessThanOrEqualTo(String value) {
			addCriterion("ADCODE <=", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeLike(String value) {
			addCriterion("ADCODE like", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeNotLike(String value) {
			addCriterion("ADCODE not like", value, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeIn(List<String> values) {
			addCriterion("ADCODE in", values, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeNotIn(List<String> values) {
			addCriterion("ADCODE not in", values, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeBetween(String value1, String value2) {
			addCriterion("ADCODE between", value1, value2, "adcode");
			return (Criteria) this;
		}

		public Criteria andAdcodeNotBetween(String value1, String value2) {
			addCriterion("ADCODE not between", value1, value2, "adcode");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNull() {
			addCriterion("LATITUDE is null");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNotNull() {
			addCriterion("LATITUDE is not null");
			return (Criteria) this;
		}

		public Criteria andLatitudeEqualTo(BigDecimal value) {
			addCriterion("LATITUDE =", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotEqualTo(BigDecimal value) {
			addCriterion("LATITUDE <>", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThan(BigDecimal value) {
			addCriterion("LATITUDE >", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LATITUDE >=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThan(BigDecimal value) {
			addCriterion("LATITUDE <", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LATITUDE <=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIn(List<BigDecimal> values) {
			addCriterion("LATITUDE in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotIn(List<BigDecimal> values) {
			addCriterion("LATITUDE not in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LATITUDE between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LATITUDE not between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeIsNull() {
			addCriterion("LONGITUDE is null");
			return (Criteria) this;
		}

		public Criteria andLongitudeIsNotNull() {
			addCriterion("LONGITUDE is not null");
			return (Criteria) this;
		}

		public Criteria andLongitudeEqualTo(BigDecimal value) {
			addCriterion("LONGITUDE =", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotEqualTo(BigDecimal value) {
			addCriterion("LONGITUDE <>", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeGreaterThan(BigDecimal value) {
			addCriterion("LONGITUDE >", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LONGITUDE >=", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeLessThan(BigDecimal value) {
			addCriterion("LONGITUDE <", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LONGITUDE <=", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeIn(List<BigDecimal> values) {
			addCriterion("LONGITUDE in", values, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotIn(List<BigDecimal> values) {
			addCriterion("LONGITUDE not in", values, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LONGITUDE between", value1, value2, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LONGITUDE not between", value1, value2, "longitude");
			return (Criteria) this;
		}

		public Criteria andAccuracyIsNull() {
			addCriterion("ACCURACY is null");
			return (Criteria) this;
		}

		public Criteria andAccuracyIsNotNull() {
			addCriterion("ACCURACY is not null");
			return (Criteria) this;
		}

		public Criteria andAccuracyEqualTo(Integer value) {
			addCriterion("ACCURACY =", value, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyNotEqualTo(Integer value) {
			addCriterion("ACCURACY <>", value, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyGreaterThan(Integer value) {
			addCriterion("ACCURACY >", value, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyGreaterThanOrEqualTo(Integer value) {
			addCriterion("ACCURACY >=", value, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyLessThan(Integer value) {
			addCriterion("ACCURACY <", value, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyLessThanOrEqualTo(Integer value) {
			addCriterion("ACCURACY <=", value, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyIn(List<Integer> values) {
			addCriterion("ACCURACY in", values, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyNotIn(List<Integer> values) {
			addCriterion("ACCURACY not in", values, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyBetween(Integer value1, Integer value2) {
			addCriterion("ACCURACY between", value1, value2, "accuracy");
			return (Criteria) this;
		}

		public Criteria andAccuracyNotBetween(Integer value1, Integer value2) {
			addCriterion("ACCURACY not between", value1, value2, "accuracy");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNull() {
			addCriterion("PROVINCE is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNotNull() {
			addCriterion("PROVINCE is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceEqualTo(String value) {
			addCriterion("PROVINCE =", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotEqualTo(String value) {
			addCriterion("PROVINCE <>", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThan(String value) {
			addCriterion("PROVINCE >", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThanOrEqualTo(String value) {
			addCriterion("PROVINCE >=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThan(String value) {
			addCriterion("PROVINCE <", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThanOrEqualTo(String value) {
			addCriterion("PROVINCE <=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLike(String value) {
			addCriterion("PROVINCE like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotLike(String value) {
			addCriterion("PROVINCE not like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceIn(List<String> values) {
			addCriterion("PROVINCE in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotIn(List<String> values) {
			addCriterion("PROVINCE not in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceBetween(String value1, String value2) {
			addCriterion("PROVINCE between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotBetween(String value1, String value2) {
			addCriterion("PROVINCE not between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andCityIsNull() {
			addCriterion("CITY is null");
			return (Criteria) this;
		}

		public Criteria andCityIsNotNull() {
			addCriterion("CITY is not null");
			return (Criteria) this;
		}

		public Criteria andCityEqualTo(String value) {
			addCriterion("CITY =", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotEqualTo(String value) {
			addCriterion("CITY <>", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThan(String value) {
			addCriterion("CITY >", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThanOrEqualTo(String value) {
			addCriterion("CITY >=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThan(String value) {
			addCriterion("CITY <", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThanOrEqualTo(String value) {
			addCriterion("CITY <=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLike(String value) {
			addCriterion("CITY like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotLike(String value) {
			addCriterion("CITY not like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityIn(List<String> values) {
			addCriterion("CITY in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotIn(List<String> values) {
			addCriterion("CITY not in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityBetween(String value1, String value2) {
			addCriterion("CITY between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotBetween(String value1, String value2) {
			addCriterion("CITY not between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andDistrictIsNull() {
			addCriterion("DISTRICT is null");
			return (Criteria) this;
		}

		public Criteria andDistrictIsNotNull() {
			addCriterion("DISTRICT is not null");
			return (Criteria) this;
		}

		public Criteria andDistrictEqualTo(String value) {
			addCriterion("DISTRICT =", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotEqualTo(String value) {
			addCriterion("DISTRICT <>", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictGreaterThan(String value) {
			addCriterion("DISTRICT >", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictGreaterThanOrEqualTo(String value) {
			addCriterion("DISTRICT >=", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictLessThan(String value) {
			addCriterion("DISTRICT <", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictLessThanOrEqualTo(String value) {
			addCriterion("DISTRICT <=", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictLike(String value) {
			addCriterion("DISTRICT like", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotLike(String value) {
			addCriterion("DISTRICT not like", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictIn(List<String> values) {
			addCriterion("DISTRICT in", values, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotIn(List<String> values) {
			addCriterion("DISTRICT not in", values, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictBetween(String value1, String value2) {
			addCriterion("DISTRICT between", value1, value2, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotBetween(String value1, String value2) {
			addCriterion("DISTRICT not between", value1, value2, "district");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("ADDRESS =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("ADDRESS <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("ADDRESS >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("ADDRESS >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("ADDRESS <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("ADDRESS <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("ADDRESS like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("ADDRESS not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("ADDRESS in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("ADDRESS not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("ADDRESS between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("ADDRESS not between", value1, value2, "address");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table S_POSITION
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
     * This class corresponds to the database table S_POSITION
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}