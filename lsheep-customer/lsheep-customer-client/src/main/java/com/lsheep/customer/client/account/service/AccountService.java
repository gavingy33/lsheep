package com.lsheep.customer.client.account.service;

import com.lsheep.common.core.webservice.dto.request.TransferRequest;
import com.lsheep.common.core.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.LoginRequestDto;
import com.lsheep.customer.client.account.dto.response.LoginResponseDto;

public interface AccountService {

	TransferResponse<LoginResponseDto> login(TransferRequest<LoginRequestDto> request);

}
