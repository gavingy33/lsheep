
package com.lsheep.config.restful.property.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.core.base.controller.impl.BaseControllerImpl;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.core.exception.BizException;
import com.lsheep.common.core.page.PageData;
import com.lsheep.common.core.restful.constant.StatusCode;
import com.lsheep.common.core.restful.dto.response.RestHeader;
import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.ResponseHeader;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.BatchUpdateReqDto;
import com.lsheep.config.client.property.dto.request.Property;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.request.SavePropertyReqDto;
import com.lsheep.config.client.property.dto.response.BatchUpdateResDto;
import com.lsheep.config.client.property.dto.response.PropertyNode;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.dto.response.SavePropertyResDto;
import com.lsheep.config.client.property.service.PropertyService;
import com.lsheep.config.restful.property.dto.ConfigTreeNode;
import com.lsheep.config.restful.property.dto.ConfigTreeQuery;
import com.lsheep.config.restful.property.dto.PropertyPageQuery;
import com.lsheep.config.restful.property.form.PropertyForm;

@RestController
@RequestMapping(value = "/property")
public class PropertyController extends BaseControllerImpl {

	@Resource
	private PropertyService propertyService;

	private static final Integer ROOT_ID = 1;

	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public RestResponse<List<ConfigTreeNode>> tree(@ModelAttribute ConfigTreeQuery configTreeQuery) {
		RestResponse<List<ConfigTreeNode>> response = new RestResponse<>();
		RestHeader restHeader = response.getHeader();
		try {
			ParamsCheck.notNull("configTreeQuery can't be null", configTreeQuery);
			TransferRequest<QueryPropertyReqDto> transferRequest = new TransferRequest<>(QueryPropertyReqDto.class);
			QueryPropertyReqDto queryPropertyReqDto = transferRequest.model();
			Integer id = configTreeQuery.getId();
			if (id == null) {
				queryPropertyReqDto.setPropertyId(ROOT_ID);
			} else {
				queryPropertyReqDto.setParentId(id);
			}
			queryPropertyReqDto.setChild(false);
			queryPropertyReqDto.setAll(false);
			queryPropertyReqDto.setWithModule(true);
			TransferResponse<QueryPropertyResDto> transferResponse = propertyService.queryProperty(transferRequest);
			ResponseHeader responseHeader = transferResponse.header();
			if (!responseHeader.success()) {
				throw new BizException(responseHeader.getMessage());
			}

			QueryPropertyResDto queryPropertyResDto = transferResponse.model();
			List<PropertyNode> propertyNodes = queryPropertyResDto.getPropertyNodes();
			List<ConfigTreeNode> configTreeNodes = new ArrayList<>();
			if (!CollectionUtils.isEmpty(propertyNodes)) {
				for (PropertyNode propertyNode : propertyNodes) {
					configTreeNodes.add(newConfigNode(propertyNode));
				}
			}
			response.setBody(configTreeNodes);
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
			ResponseHeader responseHeader = transferResponse.header();
			if (!responseHeader.success()) {
				throw new BizException(responseHeader.getMessage());
			}

			QueryPropertyResDto queryPropertyResDto = transferResponse.model();
			List<PropertyNode> propertyNodes = queryPropertyResDto.getPropertyNodes();
			if (!CollectionUtils.isEmpty(propertyNodes)) {
				response.setBody(propertyNodes.get(0));
			}
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
			savePropertyReqDto.setWeight(propertyForm.getWeight());
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
			logger.error("saveModule exception", e);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/node", method = RequestMethod.GET)
	public RestResponse<PageData<PropertyNode>> child(@ModelAttribute PropertyPageQuery propertyPageQuery) {
		RestResponse<PageData<PropertyNode>> response = new RestResponse<>();
		RestHeader restHeader = response.getHeader();
		try {
			ParamsCheck.notNull("propertyPageQuery can't be null", propertyPageQuery);
			Integer parentId = propertyPageQuery.getParentId();
			ParamsCheck.notNull("parentId can't be null", parentId);

			TransferRequest<QueryPropertyReqDto> transferRequest = new TransferRequest<>(QueryPropertyReqDto.class);
			QueryPropertyReqDto queryPropertyReqDto = transferRequest.model();
			queryPropertyReqDto.setParentId(parentId);
			queryPropertyReqDto.setChild(false);
			queryPropertyReqDto.setAll(false);
			queryPropertyReqDto.setWithModule(propertyPageQuery.getWithModule());
			queryPropertyReqDto.setWithProperty(propertyPageQuery.getWithProperty());
			queryPropertyReqDto.setPageQuery(propertyPageQuery);
			TransferResponse<QueryPropertyResDto> transferResponse = propertyService.queryProperty(transferRequest);
			ResponseHeader responseHeader = transferResponse.header();
			if (!responseHeader.success()) {
				throw new BizException(responseHeader.getMessage());
			}

			QueryPropertyResDto queryPropertyResDto = transferResponse.model();
			PageData<PropertyNode> pageData = queryPropertyResDto.getPageData();
			response.setBody(pageData);
		} catch (Exception e) {
			restHeader.setStatusCode(StatusCode.SERVER_ERROR);
			restHeader.setMessage(e.getMessage());
			logger.error("query child error", e);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/module/order", method = RequestMethod.POST)
	public RestResponse<?> order(@RequestBody List<Property> properties) {
		RestResponse<?> response = new RestResponse<>();
		RestHeader restHeader = response.getHeader();
		try {
			ParamsCheck.notEmpty("propertyNodes can't be empty", properties);
			for (Property property : properties) {
				ParamsCheck.notNull("propertyId can't be null", property.getPropertyId());
			}
			TransferRequest<BatchUpdateReqDto> transferRequest = new TransferRequest<>(BatchUpdateReqDto.class);
			BatchUpdateReqDto batchUpdateReqDto = transferRequest.model();
			batchUpdateReqDto.setProperties(properties);
			transferRequest.setModel(batchUpdateReqDto);
			TransferResponse<BatchUpdateResDto> transferResponse = propertyService.batchUpdate(transferRequest);
			ResponseHeader responseHeader = transferResponse.header();
			if (!responseHeader.success()) {
				throw new BizException(responseHeader.getMessage());
			}
		} catch (Exception e) {
			restHeader.setStatusCode(StatusCode.SERVER_ERROR);
			restHeader.setMessage(e.getMessage());
			logger.error("update order error", e);
		}
		return response;
	}

}
