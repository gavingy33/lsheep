package com.lsheep.middleware.zookeeper.utils;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.base.Charsets;
import com.lsheep.common.core.exception.BizException;

public class PropertyUtils {

	public static void validatePath(String path) {
		try {
			org.apache.curator.utils.PathUtils.validatePath(path);
		} catch (IllegalArgumentException e) {
			throw new BizException(String.format("the value of path [%s] is not a standard path", path));
		}
	}

	public static String hash(String context) {
		return context == null ? null : new String(DigestUtils.md5(context), Charsets.UTF_8);
	}

}
