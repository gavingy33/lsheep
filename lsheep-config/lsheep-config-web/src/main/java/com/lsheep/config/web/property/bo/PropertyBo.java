package com.lsheep.config.web.property.bo;

import java.util.List;

import com.lsheep.config.database.model.SProperty;

public interface PropertyBo {

	List<SProperty> selectProperty(SProperty sProperty);

	SProperty findProperty(SProperty sProperty);

	void saveProperty(SProperty sProperty);

	void updateProperty(SProperty sProperty);

}
