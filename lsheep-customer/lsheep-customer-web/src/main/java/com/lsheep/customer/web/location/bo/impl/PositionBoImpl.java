package com.lsheep.customer.web.location.bo.impl;

import javax.annotation.Resource;

import com.lsheep.common.core.annotation.Business;
import com.lsheep.customer.database.model.SPosition;
import com.lsheep.customer.web.location.bo.PositionBo;
import com.lsheep.customer.web.location.dao.PositionDao;

@Business
public class PositionBoImpl implements PositionBo {

	@Resource
	private PositionDao positionDao;

	@Override
	public void savePosition(SPosition sPosition) {
		positionDao.saveSPosition(sPosition);
	}

}
