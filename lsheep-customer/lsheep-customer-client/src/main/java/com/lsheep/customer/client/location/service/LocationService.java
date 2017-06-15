package com.lsheep.customer.client.location.service;

import javax.jws.WebService;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.location.dto.request.SavePositionReqDto;
import com.lsheep.customer.client.location.dto.response.SavePositionResDto;

@WebService
public interface LocationService {

	public TransferResponse<SavePositionResDto> savePosition(TransferRequest<SavePositionReqDto> request);

}
