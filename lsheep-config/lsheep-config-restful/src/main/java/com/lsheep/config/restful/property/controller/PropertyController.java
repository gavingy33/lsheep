
package com.lsheep.config.restful.property.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.controller.impl.BaseControllerImpl;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.core.exception.BizException;
import com.lsheep.common.core.restful.constant.StatusCode;
import com.lsheep.common.core.restful.dto.response.RestHeader;
import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.ResponseHeader;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.request.SavePropertyReqDto;
import com.lsheep.config.client.property.dto.response.PropertyNode;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.dto.response.SavePropertyResDto;
import com.lsheep.config.client.property.service.PropertyService;
import com.lsheep.config.restful.property.dto.ConfigTreeNode;
import com.lsheep.config.restful.property.dto.ConfigTreeQuery;
import com.lsheep.config.restful.property.form.PropertyForm;

@RestController
@RequestMapping(value = "/property")
public class PropertyController extends BaseControllerImpl {

	@Resource
	private PropertyService propertyService;

	private static final Integer ROOT_ID = 1;

	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public RestResponse<ConfigTreeNode> tree(@ModelAttribute ConfigTreeQuery configTreeQuery) {
		RestResponse<ConfigTreeNode> response = new RestResponse<>();
		RestHeader restHeader = response.getHeader();
		try {
			ParamsCheck.notNull("configTreeQuery can't be null", configTreeQuery);
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
		} catch (Exception e) {
			restHeader.setStatusCode(StatusCode.SERVER_ERROR);
			restHeader.setMessage(e.getMessage());
			logger.error("", e);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/node/{propertyId}", method = RequestMethod.GET)
	public RestResponse<PropertyNode> node(@PathVariable Integer propertyId) {
		RestResponse<PropertyNode> response = new RestResponse<>();
		RestHeader restHeader = response.getHeader();
		try {
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
		} catch (Exception e) {
			restHeader.setStatusCode(StatusCode.SERVER_ERROR);
			restHeader.setMessage(e.getMessage());
			logger.error("", e);
		}
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
		configTreeNode.setPath(propertyNode.getPath());
		configTreeNode.setChildren(children(propertyNode));
		return configTreeNode;
	}

	@ResponseBody
	@RequestMapping(value = "/module/add", method = RequestMethod.POST)
	public RestResponse<PropertyNode> saveModule(@ModelAttribute PropertyForm propertyForm) {
		RestResponse<PropertyNode> response = new RestResponse<>();
		RestHeader restHeader = response.getHeader();
		try {
			logger.info("enter in saveModule method, params is:{}", JSON.toJSONString(propertyForm, true));
			ParamsCheck.notNull("propertyForm can't be null", propertyForm);
			Integer parentId = propertyForm.getParentId();
			ParamsCheck.notNull("parentId can't be null", parentId);
			String code = propertyForm.getCode();
			ParamsCheck.notEmpty("code can't be empty", code);
			String name = propertyForm.getName();
			ParamsCheck.notEmpty("name can't be empty", name);

			TransferRequest<SavePropertyReqDto> transferRequest = new TransferRequest<>(SavePropertyReqDto.class);
			SavePropertyReqDto savePropertyReqDto = transferRequest.model();
			savePropertyReqDto.setIsModule(true);
			savePropertyReqDto.setParentId(parentId);
			savePropertyReqDto.setCode(code);
			savePropertyReqDto.setName(name);
			TransferResponse<SavePropertyResDto> transferResponse = propertyService.saveProperty(transferRequest);
			ResponseHeader responseHeader = transferResponse.header();
			if (!responseHeader.success()) {
				throw new BizException(responseHeader.getMessage());
			}

			SavePropertyResDto savePropertyResDto = transferResponse.model();
			PropertyNode propertyNode = new PropertyNode();
			BeanUtils.copyProperties(savePropertyResDto, propertyNode);
			response.setBody(propertyNode);
		} catch (Exception e) {
			restHeader.setStatusCode(StatusCode.SERVER_ERROR);
			restHeader.setMessage(e.getMessage());
			logger.error("", e);
		}
		return response;
	}

}
