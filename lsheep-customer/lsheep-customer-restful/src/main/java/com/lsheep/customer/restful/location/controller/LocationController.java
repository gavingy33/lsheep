package com.lsheep.customer.restful.location.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lsheep.customer.restful.location.dto.Position;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

	@RequestMapping(value = "/position", method = RequestMethod.POST)
	public void position(@RequestBody Position position) {
		System.out.println(JSON.toJSONString(position));
	}

}
