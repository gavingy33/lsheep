package com.lsheep.common.core.check;

import java.util.Collection;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public abstract class ParamsCheck {

	public static void notEmpty(String message, String target) {
		if (StringUtils.isEmpty(target)) {
			throw new CheckException(message);
		}
	}

	public static void notEmpty(String message, Collection<?> targes) {
		if (CollectionUtils.isEmpty(targes)) {
			throw new CheckException(message);
		}
	}

	public static void notNull(String message, Object target) {
		if (target == null) {
			throw new CheckException(message);
		}
	}

	public static void notAllNull(String message, Object... targets) {
		for (Object target : targets) {
			if (target != null) {
				return;
			}
		}
		throw new CheckException(message);
	}

}
