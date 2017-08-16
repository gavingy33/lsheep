package com.lsheep.config.web.property.service.impl;

import static com.lsheep.config.client.common.Constants.PATH_SPLIT;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsheep.common.core.base.service.impl.BaseServiceImpl;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.common.core.exception.BizException;
import com.lsheep.common.core.page.PageData;
import com.lsheep.common.core.page.PageQuery;
import com.lsheep.common.webservice.dto.request.TransferRequest;
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
		// 基本参数校验
		QueryPropertyReqDto queryPropertyReqDto = request.model();
		ParamsCheck.notNull("queryPropertyReqDto can't be null", queryPropertyReqDto);
		Integer propertyId = queryPropertyReqDto.getPropertyId();
		Integer parentId = queryPropertyReqDto.getParentId();
		ParamsCheck.notAllNull("propertyId and parentId can't be all null", propertyId, parentId);

		// 查询一级节点(分页)
		Boolean withModule = Boolean.TRUE.equals(queryPropertyReqDto.getWithModule());
		Boolean withProperty = Boolean.TRUE.equals(queryPropertyReqDto.getWithProperty());
		Boolean isModule = withModule == withProperty ? null : withModule;
		SProperty propertyQuery = new SProperty();
		propertyQuery.setPropertyId(propertyId);
		propertyQuery.setParentId(parentId);
		propertyQuery.setIsModule(isModule);
		PageQuery pageQuery = queryPropertyReqDto.getPageQuery();
		if (pageQuery == null) {
			pageQuery = new PageQuery();
		}
		Page<SProperty> page = PageHelper.startPage(pageQuery);
		List<SProperty> properties = propertyBo.selectProperty(propertyQuery);
		// 组装返回结果
		QueryPropertyResDto queryPropertyResDto = response.model();
		PageData<PropertyNode> pageData = new PageData<>(page, pageQuery);
		queryPropertyResDto.setPageData(pageData);
		if (CollectionUtils.isEmpty(properties)) {
			return response;
		}
		// 查询下级节点
		List<PropertyNode> propertyNodes = new ArrayList<>();
		for (SProperty sProperty : properties) {
			PropertyNode propertyNode = new PropertyNode();
			BeanUtils.copyProperties(sProperty, propertyNode);
			if (Boolean.TRUE.equals(queryPropertyReqDto.getChild())) {
				Boolean all = Boolean.TRUE.equals(queryPropertyReqDto.getAll());
				propertyNode.setChildren(children(propertyNode, all, isModule));
			}
			propertyNodes.add(propertyNode);
		}
		pageData.setRows(propertyNodes);
		return response;
	}

	private List<PropertyNode> children(PropertyNode parent, Boolean all, Boolean isModule) {
		SProperty query = new SProperty();
		query.setParentId(parent.getPropertyId());
		query.setIsModule(isModule);
		List<SProperty> children = propertyBo.selectProperty(query);
		if (CollectionUtils.isEmpty(children)) {
			return null;
		}
		List<PropertyNode> propertyNodes = new ArrayList<>();
		for (SProperty child : children) {
			PropertyNode propertyNode = new PropertyNode();
			BeanUtils.copyProperties(child, propertyNode);
			if (all) {
				propertyNode.setChildren(children(propertyNode, all, isModule));
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
		if (!parentProperty.getIsModule()) {
			throw new BizException(
					String.format("parent [%s] isn't a module, can't be added property", parentProperty.getName()));
		}

		// 验证PATH可用
		path = parentProperty.getPath().concat(path);
		query = new SProperty();
		query.setPath(path);
		SProperty exists = propertyBo.findProperty(query);
		if (exists != null) {
			throw new BizException(String.format("code [%s] already be used with name [%s]", code, exists.getName()));
		}

		// 保存属性
		SProperty sProperty = new SProperty();
		sProperty.setIsModule(isModule);
		sProperty.setParentId(parentId);
		sProperty.setPath(path);
		sProperty.setCode(code);
		sProperty.setWeight(savePropertyReqDto.getWeight());
		sProperty.setName(name);
		sProperty.setContext(context);
		sProperty.setHash(PropertyUtils.hash(context));
		propertyBo.saveProperty(sProperty);

		SavePropertyResDto savePropertyResDto = response.model();
		BeanUtils.copyProperties(sProperty, savePropertyResDto);
		return response;
	}

	@Override
	public TransferResponse<BatchUpdateResDto> batchUpdate(TransferRequest<BatchUpdateReqDto> request) {
		TransferResponse<BatchUpdateResDto> response = new TransferResponse<>(BatchUpdateResDto.class);
		BatchUpdateReqDto batchUpdateReqDto = request.model();
		ParamsCheck.notNull("batchUpdateReqDto can't be null", batchUpdateReqDto);
		List<Property> properties = batchUpdateReqDto.getProperties();
		ParamsCheck.notEmpty("properties can't be null", properties);

		for (Property property : properties) {
			Integer propertyId = property.getPropertyId();
			ParamsCheck.notNull("propertyId can't be null", propertyId);
			SProperty sProperty = new SProperty();
			sProperty.setPropertyId(propertyId);
			sProperty.setWeight(property.getWeight());
			propertyBo.updateProperty(sProperty);
		}
		return response;
	}

}
