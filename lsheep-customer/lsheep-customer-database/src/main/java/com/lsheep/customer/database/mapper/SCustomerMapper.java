package com.lsheep.customer.database.mapper;

import com.lsheep.customer.database.model.SCustomer;
import com.lsheep.customer.database.model.SCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SCustomerMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	long countByExample(SCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int deleteByExample(SCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String customerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int insert(SCustomer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int insertSelective(SCustomer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	List<SCustomer> selectByExample(SCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	SCustomer selectByPrimaryKey(String customerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") SCustomer record, @Param("example") SCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") SCustomer record, @Param("example") SCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(SCustomer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_CUSTOMER
	 * @mbg.generated
	 */
	int updateByPrimaryKey(SCustomer record);
}