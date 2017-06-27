package com.lsheep.customer.web.account.service.impl;

import org.springframework.stereotype.Service;

import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.LoginRequestDto;
import com.lsheep.customer.client.account.dto.response.LoginResponseDto;
import com.lsheep.customer.client.account.service.AccountService;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {

	@Override
	public TransferResponse<LoginResponseDto> login(TransferRequest<LoginRequestDto> request) {
		logger.info("登陆进入");
		TransferResponse<LoginResponseDto> transferResponse = new TransferResponse<>(LoginResponseDto.class);
		return transferResponse;
	}

}
