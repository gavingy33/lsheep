package com.lsheep.customer.restful.location.controller;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.controller.impl.BaseControllerImpl;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.customer.client.location.dto.request.LocationDto;
import com.lsheep.customer.client.location.dto.request.SavePositionReqDto;
import com.lsheep.customer.client.location.service.LocationService;
import com.lsheep.customer.restful.location.dto.Geolocation;
import com.lsheep.customer.restful.location.dto.Position;

@RestController
@RequestMapping(value = "/location")
public class LocationController extends BaseControllerImpl {

	@Resource
	private LocationService locationService;

	@RequestMapping(value = "/position", method = RequestMethod.POST)
	public void position(@RequestBody Position position) {
		try {
			logger.info(JSON.toJSONString(position, true));
			TransferRequest<SavePositionReqDto> transferRequest = new TransferRequest<>(SavePositionReqDto.class);
			SavePositionReqDto savePositionReqDto = transferRequest.model();
			savePositionReqDto.setAuthorize(position.getAuthorize());
			savePositionReqDto.setOperateIp(position.getOperateIp());
			savePositionReqDto.setLocationDto(new LocationDto());
			LocationDto locationDto = savePositionReqDto.getLocationDto();
			Geolocation geolocation = position.getGeolocation();
			if (geolocation != null) {
				BeanUtils.copyProperties(geolocation, locationDto);
				locationDto.setLatitude(geolocation.getLat());
				locationDto.setLongitude(geolocation.getLng());
			}
			locationService.savePosition(transferRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
