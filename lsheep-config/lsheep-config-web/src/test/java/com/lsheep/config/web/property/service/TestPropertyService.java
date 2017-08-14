package com.lsheep.config.web.property.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.service.PropertyService;
import com.lsheep.test.BaseTest;

public class TestPropertyService extends BaseTest {

	@Resource
	private PropertyService propertyService;

	@Test
	public void testQueryProperty() {
		TransferRequest<QueryPropertyReqDto> request = new TransferRequest<>(QueryPropertyReqDto.class);
		QueryPropertyReqDto queryPropertyReqDto = request.model();
		queryPropertyReqDto.setPropertyId(1);
		queryPropertyReqDto.setChild(true);
		queryPropertyReqDto.setAll(false);
		propertyService.queryProperty(request);
	}

}
