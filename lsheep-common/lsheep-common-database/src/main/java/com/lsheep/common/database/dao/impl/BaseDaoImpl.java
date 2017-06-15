package com.lsheep.common.database.dao.impl;

import org.springframework.stereotype.Repository;

import com.lsheep.common.database.dao.BaseDao;
import com.lsheep.logger.Logger;
import com.lsheep.logger.factory.LoggerFactory;

@Repository
public class BaseDaoImpl implements BaseDao {

	protected Logger logger = LoggerFactory.getLogger(getClass());

}
