package com.lsheep.logger.factory;

import com.lsheep.common.core.context.SpringContext;
import com.lsheep.logger.Logger;
import com.lsheep.logger.LoggerConfig;
import com.lsheep.logger.LoggerConfig.LoggerType;
import com.lsheep.logger.log4j.Log4jLogger;

public class LoggerFactory {

	private static LoggerConfig loggerConfig;

	private static void initBinder() {
		if (loggerConfig != null)
			return;
		loggerConfig = SpringContext.getBean("loggerConfig", LoggerConfig.class);
		if (loggerConfig == null) {
			loggerConfig = new LoggerConfig();
		}
	}

	public static Logger getLogger(final String name) {
		initBinder();
		if (LoggerType.LOG4J == loggerConfig.getLoggerType()) {
			return new Log4jLogger(name);
		}
		return null;
	}

	public static Logger getLogger(final Class<?> clazz) {
		initBinder();
		if (LoggerType.LOG4J == loggerConfig.getLoggerType()) {
			return new Log4jLogger(clazz);
		}
		return null;
	}

}
