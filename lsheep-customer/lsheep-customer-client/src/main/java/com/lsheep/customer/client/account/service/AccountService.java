package com.lsheep.customer.client.account.service;

import javax.jws.WebService;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.AccountLoginRequestDto;
import com.lsheep.customer.client.account.dto.response.AccountLoginResponseDto;

@WebService
public interface AccountService {

	TransferResponse<AccountLoginResponseDto> accountLogin(TransferRequest<AccountLoginRequestDto> request);

}
