package com.lsheep.config.web.property;

import org.springframework.stereotype.Component;

import com.lsheep.config.client.property.AbstractProperty;

@Component
public class ConfigProperty extends AbstractProperty {

	private static final String ROOT_PATH = "/";

	@Override
	protected String definePath() {
		return ROOT_PATH;
	}

}
