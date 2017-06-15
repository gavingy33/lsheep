package com.lsheep.customer.restful.location.dto;

public class Position {

	private String operateIp;
	private Boolean authorize;
	private Geolocation geolocation;

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

	public Geolocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}

}
