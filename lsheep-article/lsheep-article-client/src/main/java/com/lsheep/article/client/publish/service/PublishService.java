package com.lsheep.article.client.publish.service;

import javax.jws.WebService;

import com.lsheep.article.client.publish.dto.request.PublishReqDto;
import com.lsheep.article.client.publish.dto.response.PublishResDto;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;

@WebService
public interface PublishService {

	TransferResponse<PublishResDto> publish(TransferRequest<PublishReqDto> request);

}
