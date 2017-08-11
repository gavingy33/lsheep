package com.lsheep.sso.restful.account.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsheep.common.core.base.controller.impl.BaseControllerImpl;
import com.lsheep.common.core.restful.constant.StatusCode;
import com.lsheep.common.core.restful.dto.response.RestHeader;
import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.AccountLoginRequestDto;
import com.lsheep.customer.client.account.dto.response.AccountLoginResponseDto;
import com.lsheep.customer.client.account.dto.response.CustomerDto;
import com.lsheep.customer.client.account.service.AccountService;
import com.lsheep.sso.restful.account.form.LoginForm;

@RestController
@RequestMapping(value = "/sso")
public class AccountController extends BaseControllerImpl {

	@Resource
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestResponse<CustomerDto> login(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute LoginForm loginForm) {
		RestResponse<CustomerDto> restResponse = new RestResponse<>();
		try {
			TransferRequest<AccountLoginRequestDto> transferRequest = new TransferRequest<>(AccountLoginRequestDto.class);
			AccountLoginRequestDto loginRequestDto = transferRequest.model();
			loginRequestDto.setUsername(loginForm.getUsername());
			loginRequestDto.setPassword(loginForm.getPassword());
			TransferResponse<AccountLoginResponseDto> transferResponse = accountService.accountLogin(transferRequest);

			RestHeader restHeader = restResponse.getHeader();
			if (!transferResponse.header().success()) {
				restHeader.setStatusCode(StatusCode.OK);
				return restResponse;
			}
			restResponse.setBody(transferResponse.model().getCustomerDto());
		} catch (Exception e) {
			logger.error("", e);
			restResponse.failure(e);
		}
		return restResponse;
	}

}
