package com.lsheep.common.core.utils;

public abstract class StringUtils extends org.springframework.util.StringUtils {

	public static String captureName(String name) {
		char[] character = name.toCharArray();
		character[0] -= 32;
		return String.valueOf(character);
	}

}
