package com.lsheep.config.restful.property.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.response.PropertyNode;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.service.PropertyService;
import com.lsheep.config.restful.property.dto.ConfigTreeNode;
import com.lsheep.config.restful.property.dto.ConfigTreeQuery;

@RestController
@RequestMapping(value = "/property")
public class PropertyController {

	@Resource
	private PropertyService propertyService;

	private static final Integer ROOT_ID = 1;

	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public RestResponse<ConfigTreeNode> tree(@ModelAttribute ConfigTreeQuery configTreeQuery) {
		ParamsCheck.notNull("configTreeQuery can't be null", configTreeQuery);

		RestResponse<ConfigTreeNode> response = new RestResponse<>();
		TransferRequest<QueryPropertyReqDto> transferRequest = new TransferRequest<>(QueryPropertyReqDto.class);
		QueryPropertyReqDto queryPropertyReqDto = transferRequest.model();
		Integer propertyId = configTreeQuery.getId();
		queryPropertyReqDto.setPropertyId(propertyId == null ? ROOT_ID : propertyId);
		queryPropertyReqDto.setChild(true);
		queryPropertyReqDto.setAll(false);
		TransferResponse<QueryPropertyResDto> transferResponse = propertyService.queryProperty(transferRequest);

		QueryPropertyResDto queryPropertyResDto = transferResponse.model();
		PropertyNode propertyNode = queryPropertyResDto.getPropertyNode();
		response.setBody(newConfigNode(propertyNode));
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/node/{propertyId}", method = RequestMethod.GET)
	public RestResponse<PropertyNode> node(@PathVariable Integer propertyId) {
		RestResponse<PropertyNode> response = new RestResponse<>();
		ParamsCheck.notNull("propertyId can't be null", propertyId);

		TransferRequest<QueryPropertyReqDto> transferRequest = new TransferRequest<>(QueryPropertyReqDto.class);
		QueryPropertyReqDto queryPropertyReqDto = transferRequest.model();
		queryPropertyReqDto.setPropertyId(propertyId);
		queryPropertyReqDto.setChild(false);
		queryPropertyReqDto.setAll(false);
		TransferResponse<QueryPropertyResDto> transferResponse = propertyService.queryProperty(transferRequest);
		QueryPropertyResDto queryPropertyResDto = transferResponse.model();
		PropertyNode propertyNode = queryPropertyResDto.getPropertyNode();
		response.setBody(propertyNode);
		return response;
	}

	private List<ConfigTreeNode> children(PropertyNode parent) {
		List<PropertyNode> propertyNodes = parent.getChildren();
		if (CollectionUtils.isEmpty(propertyNodes)) {
			return null;
		}
		List<ConfigTreeNode> configTreeNodes = new ArrayList<>();
		for (PropertyNode propertyNode : propertyNodes) {
			configTreeNodes.add(newConfigNode(propertyNode));
		}
		return configTreeNodes;
	}

	private ConfigTreeNode newConfigNode(PropertyNode propertyNode) {
		if (propertyNode == null) {
			return null;
		}
		ConfigTreeNode configTreeNode = new ConfigTreeNode();
		configTreeNode.setId(propertyNode.getPropertyId());
		Boolean isModule = propertyNode.getIsModule();
		configTreeNode.setIsModule(isModule);
		configTreeNode.setIsParent(isModule);
		configTreeNode.setName(propertyNode.getName());
		configTreeNode.setChildren(children(propertyNode));
		return configTreeNode;
	}

}
