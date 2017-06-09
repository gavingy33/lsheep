package com.lsheep.customer.client.account.service;

import javax.jws.WebService;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.LoginRequestDto;
import com.lsheep.customer.client.account.dto.response.LoginResponseDto;

@WebService
public interface AccountService {

	TransferResponse<LoginResponseDto> login(TransferRequest<LoginRequestDto> request);

}
