package com.lsheep.sso.account.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsheep.common.core.restful.constant.StatusCode;
import com.lsheep.common.core.restful.dto.response.ResponseHeader;
import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.common.core.webservice.dto.request.TransferRequest;
import com.lsheep.common.core.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.account.dto.request.LoginRequestDto;
import com.lsheep.customer.client.account.dto.response.CustomerDto;
import com.lsheep.customer.client.account.dto.response.LoginResponseDto;
import com.lsheep.customer.client.account.service.AccountService;
import com.lsheep.logger.Logger;
import com.lsheep.logger.factory.LoggerFactory;
import com.lsheep.sso.account.model.LoginModel;

@Controller
@RequestMapping("/sso")
public class AccountController {

	private Logger logger = LoggerFactory.getLogger("");

	@Resource
	private AccountService accountService;

	@ResponseBody
	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public RestResponse<CustomerDto> login(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute LoginModel loginModel) {
		RestResponse<CustomerDto> restResponse = new RestResponse<>();
		try {
			TransferRequest<LoginRequestDto> transferRequest = new TransferRequest<>();
			LoginRequestDto loginRequestDto = new LoginRequestDto();
			transferRequest.setModel(loginRequestDto);
			TransferResponse<LoginResponseDto> transferResponse = accountService.login(transferRequest);

			ResponseHeader responseHeader = restResponse.getHeader();
			if (!transferResponse.getHeader().success()) {
				responseHeader.setStatusCode(StatusCode.OK);
				return restResponse;
			}
			restResponse.setBody(transferResponse.getModel().getCustomerDto());
		} catch (Exception e) {
			logger.error("", e);
			restResponse.failure(e);
		}
		return restResponse;
	}

}
