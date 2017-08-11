package com.lsheep.config.client.property.service;

import javax.jws.WebService;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.request.SavePropertyReqDto;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.dto.response.SavePropertyResDto;

@WebService
public interface PropertyService {

	TransferResponse<QueryPropertyResDto> queryProperty(TransferRequest<QueryPropertyReqDto> request);

	TransferResponse<SavePropertyResDto> saveProperty(TransferRequest<SavePropertyReqDto> request);

}
