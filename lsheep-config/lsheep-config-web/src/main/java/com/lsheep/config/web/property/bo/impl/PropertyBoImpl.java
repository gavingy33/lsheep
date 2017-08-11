package com.lsheep.config.web.property.bo.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;

import com.lsheep.common.core.base.annotation.Business;
import com.lsheep.common.core.base.bo.impl.BaseBoImpl;
import com.lsheep.config.database.model.SProperty;
import com.lsheep.config.web.property.bo.PropertyBo;
import com.lsheep.config.web.property.dao.PropertyDao;

@Business
public class PropertyBoImpl extends BaseBoImpl implements PropertyBo {

	@Resource
	private PropertyDao propertyDao;

	@Override
	public List<SProperty> selectProperty(SProperty sProperty) {
		List<SProperty> sProperties = propertyDao.select(sProperty);
		return CollectionUtils.isEmpty(sProperties) ? new ArrayList<>() : sProperties;
	}

	@Override
	public SProperty findProperty(SProperty sProperty) {
		List<SProperty> sProperties = propertyDao.select(sProperty);
		return CollectionUtils.isEmpty(sProperties) ? null : sProperties.get(0);
	}

	@Override
	public void saveProperty(SProperty sProperty) {
		Date current = new Date();
		sProperty.setCreateDate(current);
		sProperty.setModifyDate(current);
		sProperty.setDeleted(false);
		propertyDao.insert(sProperty);
	}

}
