package com.lsheep.logger;

public class LoggerConfig {

	private LoggerType loggerType = LoggerType.LOG4J;

	public LoggerType getLoggerType() {
		return loggerType;
	}

	public void setLoggerType(LoggerType loggerType) {
		this.loggerType = loggerType;
	}

	public enum LoggerType {
		LOG4J
	}

}
