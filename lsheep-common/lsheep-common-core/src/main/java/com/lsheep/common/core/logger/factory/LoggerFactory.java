package com.lsheep.common.core.logger.factory;

import com.lsheep.common.core.logger.Logger;
import com.lsheep.common.core.logger.log4j.Log4jLogger;

public abstract class LoggerFactory {

	public static Logger getLogger(final String name) {
		return new Log4jLogger(name);
	}

	public static Logger getLogger(final Class<?> clazz) {
		return new Log4jLogger(clazz);
	}

}
