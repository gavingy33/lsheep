package com.lsheep.middleware.zookeeper.utils;

public class PathUtils {

	public static String validatePath(String path) throws IllegalArgumentException {
		return org.apache.curator.utils.PathUtils.validatePath(path);
	}

}
