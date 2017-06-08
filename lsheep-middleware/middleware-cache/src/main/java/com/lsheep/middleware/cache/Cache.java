package com.lsheep.middleware.cache;

public interface Cache {

	String get(String key);

	boolean delete(String key);

	boolean put(String key, String value);

	boolean add(String key, String value);

}
