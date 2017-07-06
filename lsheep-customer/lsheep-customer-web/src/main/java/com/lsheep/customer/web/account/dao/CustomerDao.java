package com.lsheep.customer.web.account.dao;

import java.util.List;

import com.lsheep.customer.database.model.SCustomer;

public interface CustomerDao {

	int insert(SCustomer record);

	List<SCustomer> select(SCustomer example);

	int update(SCustomer record, SCustomer example);

	int delete(SCustomer example);

}
