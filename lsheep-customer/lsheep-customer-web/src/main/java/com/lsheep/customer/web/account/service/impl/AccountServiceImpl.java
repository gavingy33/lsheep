package com.lsheep.customer.web.account.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.AccountLoginRequestDto;
import com.lsheep.customer.client.account.dto.response.CustomerDto;
import com.lsheep.customer.client.account.dto.response.AccountLoginResponseDto;
import com.lsheep.customer.client.account.service.AccountService;
import com.lsheep.customer.database.model.SCustomer;
import com.lsheep.customer.web.account.bo.CustomerBo;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {

	@Resource
	private CustomerBo customerBo;

	@Override
	public TransferResponse<AccountLoginResponseDto> accountLogin(TransferRequest<AccountLoginRequestDto> request) {
		TransferResponse<AccountLoginResponseDto> transferResponse = new TransferResponse<>(AccountLoginResponseDto.class);
		AccountLoginRequestDto loginRequestDto = request.model();
		ParamsCheck.notNull("loginRequestDto must not be null", loginRequestDto);
		ParamsCheck.notEmpty("username must not be null", loginRequestDto.getUsername());
		ParamsCheck.notEmpty("password must not be null", loginRequestDto.getPassword());

		AccountLoginResponseDto loginResponseDto = transferResponse.model();
		String username = loginRequestDto.getUsername();
		String password = customerBo.encrypt(loginRequestDto.getPassword());
		SCustomer sCustomer = new SCustomer();
		sCustomer.setUsername(username);
		sCustomer.setPassword(password);
		sCustomer = customerBo.findCustomer(sCustomer);
		if (sCustomer != null) {
			CustomerDto customerDto = new CustomerDto();
			BeanUtils.copyProperties(sCustomer, customerDto);
			loginResponseDto.setSuccess(true);
			loginResponseDto.setCustomerDto(customerDto);
		}
		return transferResponse;
	}

}
