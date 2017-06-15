package com.lsheep.common.core.logger;

public interface Logger {

	void trace(String message);

	void trace(String message, Throwable t);

	void trace(String message, Object... params);

	void debug(String message);

	void debug(String message, Throwable t);

	void debug(String message, Object... params);

	void info(String message);

	void info(String message, Throwable t);

	void info(String message, Object... params);

	void warn(String message);

	void warn(String message, Throwable t);

	void warn(String message, Object... params);

	void error(String message);

	void error(String message, Throwable t);

	void error(String message, Object... params);

}
