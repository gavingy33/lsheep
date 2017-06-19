package com.lsheep.customer.web.location.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.customer.client.location.dto.request.LocationDto;
import com.lsheep.customer.client.location.dto.request.SavePositionReqDto;
import com.lsheep.customer.client.location.dto.response.SavePositionResDto;
import com.lsheep.customer.client.location.service.LocationService;
import com.lsheep.customer.database.model.SPosition;
import com.lsheep.customer.web.location.bo.PositionBo;

@Service
public class LocationServiceImpl extends BaseServiceImpl implements LocationService {

	@Resource
	private PositionBo positionBo;

	@Override
	public TransferResponse<SavePositionResDto> savePosition(TransferRequest<SavePositionReqDto> request) {
		TransferResponse<SavePositionResDto> response = new TransferResponse<>(SavePositionResDto.class);
		try {
			SavePositionReqDto savePositionReqDto = request.model();

			SPosition sPosition = new SPosition();
			LocationDto locationDto = savePositionReqDto.getLocationDto();
			BeanUtils.copyProperties(locationDto, sPosition);
			sPosition.setAddress(locationDto.getAddr());
			sPosition.setAuthorize(savePositionReqDto.getAuthorize());
			sPosition.setOperateIp(savePositionReqDto.getOperateIp());
			positionBo.savePosition(sPosition);
		} catch (Exception e) {
			response.failure(e);
		}
		return response;
	}

}
