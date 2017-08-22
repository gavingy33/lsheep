package com.lsheep.config.client.property.service;

import javax.jws.WebService;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.BatchUpdateReqDto;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.request.SavePropertyReqDto;
import com.lsheep.config.client.property.dto.request.UpdatePropertyReqDto;
import com.lsheep.config.client.property.dto.response.BatchUpdateResDto;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.dto.response.SavePropertyResDto;
import com.lsheep.config.client.property.dto.response.UpdatePropertyResDto;

@WebService
public interface PropertyService {

	TransferResponse<QueryPropertyResDto> queryProperty(TransferRequest<QueryPropertyReqDto> request);

	TransferResponse<SavePropertyResDto> saveProperty(TransferRequest<SavePropertyReqDto> request);
	
	TransferResponse<UpdatePropertyResDto> updateProperty(TransferRequest<UpdatePropertyReqDto> request);

	TransferResponse<BatchUpdateResDto> batchUpdate(TransferRequest<BatchUpdateReqDto> request);

}
