package com.lsheep.customer.web.account.service.impl;

import org.springframework.stereotype.Service;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.LoginRequestDto;
import com.lsheep.customer.client.account.dto.response.LoginResponseDto;
import com.lsheep.customer.client.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public TransferResponse<LoginResponseDto> login(TransferRequest<LoginRequestDto> request) {
		// TODO Auto-generated method stub
		return null;
	}

}
