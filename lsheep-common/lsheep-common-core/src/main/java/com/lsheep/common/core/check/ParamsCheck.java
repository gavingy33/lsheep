package com.lsheep.common.core.check;

import org.springframework.util.StringUtils;

public abstract class ParamsCheck {

	public static void notEmpty(String message, String target) {
		if (StringUtils.isEmpty(message)) {
			throw new CheckException(message);
		}
	}

	public static void notNull(String message, Object target) {
		if (target == null) {
			throw new CheckException(message);
		}
	}

}
