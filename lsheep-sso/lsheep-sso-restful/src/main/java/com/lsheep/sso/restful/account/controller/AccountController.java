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
import com.lsheep.common.core.restful.dto.response.ResponseHeader;
import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.LoginRequestDto;
import com.lsheep.customer.client.account.dto.response.CustomerDto;
import com.lsheep.customer.client.account.dto.response.LoginResponseDto;
import com.lsheep.customer.client.account.service.AccountService;
import com.lsheep.sso.restful.account.model.LoginModel;

@RestController
@RequestMapping(value = "/sso")
public class AccountController extends BaseControllerImpl {

	@Resource
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestResponse<CustomerDto> login(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute LoginModel loginModel) {
		RestResponse<CustomerDto> restResponse = new RestResponse<>();
		try {
			TransferRequest<LoginRequestDto> transferRequest = new TransferRequest<>(LoginRequestDto.class);
			TransferResponse<LoginResponseDto> transferResponse = accountService.login(transferRequest);

			ResponseHeader responseHeader = restResponse.getHeader();
			if (!transferResponse.header().success()) {
				responseHeader.setStatusCode(StatusCode.OK);
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
