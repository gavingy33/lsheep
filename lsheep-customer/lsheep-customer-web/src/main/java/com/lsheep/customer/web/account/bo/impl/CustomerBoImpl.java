package com.lsheep.customer.web.account.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.CollectionUtils;

import com.lsheep.common.core.base.annotation.Business;
import com.lsheep.common.core.base.bo.impl.BaseBoImpl;
import com.lsheep.customer.database.model.SCustomer;
import com.lsheep.customer.web.account.bo.CustomerBo;
import com.lsheep.customer.web.account.dao.CustomerDao;

@Business
public class CustomerBoImpl extends BaseBoImpl implements CustomerBo {

	@Resource
	private CustomerDao customerDao;

	@Override
	public SCustomer saveCustomer(SCustomer sCustomer) {
		Date now = new Date();
		sCustomer.setCreateDate(now);
		sCustomer.setModifyDate(now);
		customerDao.insert(sCustomer);
		return sCustomer;
	}

	@Override
	public SCustomer findCustomer(SCustomer sCustomer) {
		List<SCustomer> sCustomers = customerDao.select(sCustomer);
		return CollectionUtils.isEmpty(sCustomers) ? null : sCustomers.get(0);
	}

	@Override
	public List<SCustomer> selectCustomer(SCustomer sCustomer) {
		List<SCustomer> sCustomers = customerDao.select(sCustomer);
		return CollectionUtils.isEmpty(sCustomers) ? new ArrayList<>() : sCustomers;
	}

	@Override
	public String encrypt(String password) {
		return DigestUtils.md5Hex(password).toUpperCase();
	}

}
