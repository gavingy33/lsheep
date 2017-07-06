package com.lsheep.customer.web.account.bo;

import java.util.List;

import com.lsheep.customer.database.model.SCustomer;

public interface CustomerBo {

	SCustomer findCustomer(SCustomer sCustomer);

	List<SCustomer> selectCustomer(SCustomer sCustomer);

	SCustomer saveCustomer(SCustomer sCustomer);

	String encrypt(String password);

}
