package com.lsheep.middleware.cache.redis;

import org.junit.Test;

import com.lsheep.test.BaseTest;

public class TestRedisCache extends BaseTest {

	private final String namespace = "ARTICLE";

	@Test
	public void testSet() {
		RedisCache.set(namespace, "article:001", "wenzhang");
	}

	@Test
	public void testGet() {
		System.out.println(RedisCache.get(namespace, "article:001"));
	}

}
