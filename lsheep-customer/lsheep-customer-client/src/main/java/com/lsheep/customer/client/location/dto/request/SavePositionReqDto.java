package com.lsheep.customer.client.location.dto.request;

public class SavePositionReqDto {

	private String operateIp;
	private Boolean authorize;
	private LocationDto locationDto;

	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public Boolean getAuthorize() {
		return authorize;
	}

	public void setAuthorize(Boolean authorize) {
		this.authorize = authorize;
	}

	public LocationDto getLocationDto() {
		return locationDto;
	}

	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}

}
