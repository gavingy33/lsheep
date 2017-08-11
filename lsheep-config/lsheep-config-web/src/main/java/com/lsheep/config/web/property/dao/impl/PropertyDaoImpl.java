package com.lsheep.config.web.property.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lsheep.common.core.base.dao.impl.BaseDaoImpl;
import com.lsheep.common.database.util.CriteriaUtils;
import com.lsheep.config.database.mapper.SPropertyMapper;
import com.lsheep.config.database.model.SProperty;
import com.lsheep.config.database.model.SPropertyExample;
import com.lsheep.config.web.property.dao.PropertyDao;

@Repository
public class PropertyDaoImpl extends BaseDaoImpl implements PropertyDao {

	@Resource
	private SPropertyMapper sPropertyMapper;

	@Override
	public List<SProperty> select(SProperty example) {
		SPropertyExample propertyExample = new SPropertyExample();
		SPropertyExample.Criteria criteria = propertyExample.createCriteria();
		CriteriaUtils.buildEqualToCriteria(criteria, example);
		return sPropertyMapper.selectByExampleWithBLOBs(propertyExample);
	}

	@Override
	public int insert(SProperty sProperty) {
		return sPropertyMapper.insertSelective(sProperty);
	}

}
