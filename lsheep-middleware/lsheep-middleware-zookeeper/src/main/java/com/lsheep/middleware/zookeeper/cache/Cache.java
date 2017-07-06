package com.lsheep.middleware.zookeeper.cache;

import java.io.Closeable;
import java.util.Map;

public interface Cache extends Closeable {

	String data();

	String data(String path);

	Map<String, String> children(String path);

	Map<String, String> all();

}
