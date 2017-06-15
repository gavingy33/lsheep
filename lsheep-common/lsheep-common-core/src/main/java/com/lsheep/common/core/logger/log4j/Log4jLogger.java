package com.lsheep.common.core.logger.log4j;

import org.apache.logging.log4j.LogManager;

import com.lsheep.common.core.logger.Logger;

public class Log4jLogger implements Logger {

	private final org.apache.logging.log4j.Logger logger;

	public Log4jLogger(String name) {
		logger = LogManager.getLogger(name);
	}

	public Log4jLogger(Class<?> clazz) {
		logger = LogManager.getLogger(clazz);
	}

	@Override
	public void trace(String message) {
		if (logger.isTraceEnabled()) {
			logger.trace(message);
		}
	}

	@Override
	public void trace(String message, Throwable t) {
		if (logger.isTraceEnabled()) {
			logger.trace(message, t);
		}
	}

	@Override
	public void trace(String message, Object... params) {
		if (logger.isTraceEnabled()) {
			logger.trace(message, params);
		}
	}

	@Override
	public void debug(String message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	@Override
	public void debug(String message, Throwable t) {
		if (logger.isDebugEnabled()) {
			logger.debug(message, t);
		}
	}

	@Override
	public void debug(String message, Object... params) {
		if (logger.isDebugEnabled()) {
			logger.debug(message, params);
		}
	}

	@Override
	public void info(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

	@Override
	public void info(String message, Throwable t) {
		if (logger.isInfoEnabled()) {
			logger.info(message, t);
		}
	}

	@Override
	public void info(String message, Object... params) {
		if (logger.isInfoEnabled()) {
			logger.info(message, params);
		}
	}

	@Override
	public void warn(String message) {
		if (logger.isWarnEnabled()) {
			logger.warn(message);
		}
	}

	@Override
	public void warn(String message, Throwable t) {
		if (logger.isWarnEnabled()) {
			logger.warn(message, t);
		}
	}

	@Override
	public void warn(String message, Object... params) {
		if (logger.isWarnEnabled()) {
			logger.warn(message, params);
		}
	}

	@Override
	public void error(String message) {
		if (logger.isErrorEnabled()) {
			logger.error(message);
		}
	}

	@Override
	public void error(String message, Throwable t) {
		if (logger.isErrorEnabled()) {
			logger.error(message, t);
		}
	}

	@Override
	public void error(String message, Object... params) {
		if (logger.isErrorEnabled()) {
			logger.error(message, params);
		}
	}

}
