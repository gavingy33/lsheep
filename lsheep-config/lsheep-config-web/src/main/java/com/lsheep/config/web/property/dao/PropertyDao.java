package com.lsheep.config.web.property.dao;

import java.util.List;

import com.lsheep.config.database.model.SProperty;

public interface PropertyDao {

	List<SProperty> select(SProperty sProperty);

}
