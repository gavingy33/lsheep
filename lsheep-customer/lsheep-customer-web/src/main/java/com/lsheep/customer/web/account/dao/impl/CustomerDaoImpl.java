package com.lsheep.customer.web.account.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lsheep.common.core.base.dao.impl.BaseDaoImpl;
import com.lsheep.common.database.util.CriteriaUtils;
import com.lsheep.customer.database.mapper.SCustomerMapper;
import com.lsheep.customer.database.model.SCustomer;
import com.lsheep.customer.database.model.SCustomerExample;
import com.lsheep.customer.web.account.dao.CustomerDao;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao {

	@Resource
	private SCustomerMapper sCustomerMapper;

	@Override
	public int insert(SCustomer record) {
		return sCustomerMapper.insertSelective(record);
	}

	@Override
	public List<SCustomer> select(SCustomer example) {
		SCustomerExample customerExample = new SCustomerExample();
		SCustomerExample.Criteria criteria = customerExample.createCriteria();
		CriteriaUtils.buildCriteria(criteria, example);
		return sCustomerMapper.selectByExample(customerExample);
	}

	@Override
	public int update(SCustomer record, SCustomer example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SCustomer example) {
		// TODO Auto-generated method stub
		return 0;
	}

}
