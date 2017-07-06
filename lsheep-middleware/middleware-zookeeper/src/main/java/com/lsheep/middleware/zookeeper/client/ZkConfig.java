package com.lsheep.middleware.zookeeper.client;

public class ZkConfig {

	private String connection;
	private String namespace;

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

}
