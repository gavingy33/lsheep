package com.lsheep.customer.database.mapper;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.lsheep.customer.database.model.SCustomer;
import com.lsheep.customer.database.model.SCustomerExample;
import com.lsheep.test.BaseTest;

public class TestSCustomerMapper extends BaseTest {

	@Resource
	private SCustomerMapper sCustomerMapper;

	@Test
	public void testInsertSelective() {
		try {
			logger.info("ready to insert");
			SCustomer sCustomer = new SCustomer();
			sCustomer.setCustomerId("000001");
			sCustomer.setCreateDate(new Date());
			sCustomer.setDeleted(false);
			sCustomerMapper.insertSelective(sCustomer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Test
	public void testGetCustomer() {
		logger.info("start query customer");
		SCustomerExample example = new SCustomerExample();
		example.createCriteria().andCustomerIdEqualTo("000001");
		sCustomerMapper.selectByExample(example);
	}

}
