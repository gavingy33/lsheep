package com.lsheep.customer.restful.location.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.controller.impl.BaseControllerImpl;
import com.lsheep.common.core.logger.Logger;
import com.lsheep.common.core.logger.factory.LoggerFactory;
import com.lsheep.customer.restful.location.dto.Position;

@RestController
@RequestMapping(value = "/location")
public class LocationController extends BaseControllerImpl {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/position", method = RequestMethod.POST)
	public void position(@RequestBody Position position) {
		logger.info(JSON.toJSONString(position));
	}

}
