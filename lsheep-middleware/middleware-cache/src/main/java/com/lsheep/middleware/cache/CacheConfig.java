package com.lsheep.middleware.cache;

public class CacheConfig {

	private CacheType cacheType;
	private String connection;
	private String username;
	private String password;

	public CacheType getCacheType() {
		return cacheType;
	}

	public void setCacheType(CacheType cacheType) {
		this.cacheType = cacheType;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public enum CacheType {
		REDIS_CACHE, MEM_CACHE;
	}

}
