package com.lsheep.config.web.property.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.response.PropertyNode;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.service.PropertyService;
import com.lsheep.config.database.model.SProperty;
import com.lsheep.config.web.property.bo.PropertyBo;

@Service
public class PropertyServiceImpl extends BaseServiceImpl implements PropertyService {

	@Resource
	private PropertyBo propertyBo;

	@Override
	public TransferResponse<QueryPropertyResDto> queryProperty(TransferRequest<QueryPropertyReqDto> request) {
		TransferResponse<QueryPropertyResDto> response = new TransferResponse<>(QueryPropertyResDto.class);

		QueryPropertyReqDto queryPropertyReqDto = request.model();
		ParamsCheck.notNull("request can't be null", queryPropertyReqDto);
		Integer propertyId = queryPropertyReqDto.getPropertyId();
		ParamsCheck.notNull("propertyId can't be null", propertyId);
		SProperty query = new SProperty();
		query.setPropertyId(propertyId);
		SProperty rootProperty = propertyBo.findProperty(query);
		if (rootProperty == null) {
			return response;
		}

		QueryPropertyResDto queryPropertyResDto = response.model();
		PropertyNode propertyNode = new PropertyNode();
		BeanUtils.copyProperties(rootProperty, propertyNode);
		queryPropertyResDto.setPropertyNode(propertyNode);

		Boolean child = queryPropertyReqDto.getChild();
		if (child != null && child) {
			boolean all = Boolean.TRUE.equals(queryPropertyReqDto.getAll());
			propertyNode.setChildren(children(propertyNode, all));
		}
		return response;
	}

	private List<PropertyNode> children(PropertyNode parent, boolean all) {
		SProperty query = new SProperty();
		query.setParentId(parent.getPropertyId());
		List<SProperty> children = propertyBo.selectProperty(query);
		if (CollectionUtils.isEmpty(children)) {
			return null;
		}
		List<PropertyNode> propertyNodes = new ArrayList<>();
		for (SProperty child : children) {
			PropertyNode propertyNode = new PropertyNode();
			BeanUtils.copyProperties(child, propertyNode);
			if (all) {
				propertyNode.setChildren(children(propertyNode, all));
			}
			propertyNodes.add(propertyNode);
		}
		return propertyNodes;
	}

}
