package com.lsheep.config.web.property.service.impl;

import static com.lsheep.config.client.common.Constants.PATH_SPLIT;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.core.exception.BizException;
import com.lsheep.common.webservice.dto.request.TransferRequest;
import com.lsheep.common.webservice.dto.response.TransferResponse;
import com.lsheep.config.client.property.dto.request.QueryPropertyReqDto;
import com.lsheep.config.client.property.dto.request.SavePropertyReqDto;
import com.lsheep.config.client.property.dto.response.PropertyNode;
import com.lsheep.config.client.property.dto.response.QueryPropertyResDto;
import com.lsheep.config.client.property.dto.response.SavePropertyResDto;
import com.lsheep.config.client.property.service.PropertyService;
import com.lsheep.config.database.model.SProperty;
import com.lsheep.config.web.property.bo.PropertyBo;
import com.lsheep.middleware.zookeeper.utils.PropertyUtils;

@Service
public class PropertyServiceImpl extends BaseServiceImpl implements PropertyService {

	@Resource
	private PropertyBo propertyBo;

	@Override
	public TransferResponse<QueryPropertyResDto> queryProperty(TransferRequest<QueryPropertyReqDto> request) {
		TransferResponse<QueryPropertyResDto> response = new TransferResponse<>(QueryPropertyResDto.class);

		QueryPropertyReqDto queryPropertyReqDto = request.model();
		ParamsCheck.notNull("queryPropertyReqDto can't be null", queryPropertyReqDto);
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

	@Override
	public TransferResponse<SavePropertyResDto> saveProperty(TransferRequest<SavePropertyReqDto> request) {
		TransferResponse<SavePropertyResDto> response = new TransferResponse<>(SavePropertyResDto.class);
		// 基本参数校验
		SavePropertyReqDto savePropertyReqDto = request.model();
		ParamsCheck.notNull("savePropertyReqDto can't be null", savePropertyReqDto);
		Boolean isModule = savePropertyReqDto.getIsModule();
		ParamsCheck.notNull("isModule can't be null", isModule);
		Integer parentId = savePropertyReqDto.getParentId();
		ParamsCheck.notNull("parentId can't be null", parentId);
		String code = savePropertyReqDto.getCode();
		ParamsCheck.notEmpty("code can't be empty", code);
		String path = PATH_SPLIT.concat(code);
		PropertyUtils.validatePath(path);
		String name = savePropertyReqDto.getName();
		ParamsCheck.notEmpty("name can't be empty", name);
		String context = savePropertyReqDto.getContext();
		if (!isModule) {
			ParamsCheck.notEmpty("when property isn't a module, context can't be empty", context);
		}

		// 查找父属性
		SProperty query = new SProperty();
		query.setPropertyId(parentId);
		SProperty parentProperty = propertyBo.findProperty(query);
		if (parentProperty == null) {
			throw new BizException(String.format("can't find parent property with id [%d]", parentId));
		}

		// 验证PATH可用
		path = parentProperty.getPath().concat(path);
		query = new SProperty();
		query.setPath(path);
		SProperty exists = propertyBo.findProperty(query);
		if (exists != null) {
			throw new BizException(String.format("code [%s] in parent propertyId [%d] already is use", code, parentId));
		}

		// 保存属性
		SProperty sProperty = new SProperty();
		sProperty.setIsModule(isModule);
		sProperty.setParentId(parentId);
		sProperty.setPath(path);
		sProperty.setCode(code);
		sProperty.setName(name);
		sProperty.setContext(context);
		sProperty.setHash(PropertyUtils.hash(context));
		propertyBo.saveProperty(sProperty);

		SavePropertyResDto savePropertyResDto = response.model();
		BeanUtils.copyProperties(sProperty, savePropertyResDto);
		return response;
	}

}
