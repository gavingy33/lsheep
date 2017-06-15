package com.lsheep.customer.web.location.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lsheep.common.core.base.dao.impl.BaseDaoImpl;
import com.lsheep.customer.database.mapper.SPositionMapper;
import com.lsheep.customer.database.model.SPosition;
import com.lsheep.customer.web.location.dao.PositionDao;

@Repository
public class PositionDaoImpl extends BaseDaoImpl implements PositionDao {

	@Resource
	private SPositionMapper sPositionMapper;

	@Override
	public void saveSPosition(SPosition sPosition) {
		sPosition.setCreateDate(new Date());
		sPosition.setModifyDate(new Date());
		sPosition.setDeleted(false);
		sPositionMapper.insertSelective(sPosition);
	}

	@Override
	public void updateSPosition(SPosition sPosition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSPosition(SPosition sPosition) {
		// TODO Auto-generated method stub

	}

	@Override
	public SPosition getSPosition(SPosition sPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SPosition> getSPositions(SPosition sPosition) {
		// TODO Auto-generated method stub
		return null;
	}

}
