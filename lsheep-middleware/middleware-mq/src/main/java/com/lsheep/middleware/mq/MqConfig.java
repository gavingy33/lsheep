package com.lsheep.middleware.mq;

public class MqConfig {

	private MqType mqType;
	private String connection;
	private String groupName;

	public MqType getMqType() {
		return mqType;
	}

	public void setMqType(MqType mqType) {
		this.mqType = mqType;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public enum MqType {
		ROCKET_MQ
	}

	@Override
	public String toString() {
		return "MqConfig [mqType=" + mqType + ", connection=" + connection + ", groupName=" + groupName + "]";
	}

}
