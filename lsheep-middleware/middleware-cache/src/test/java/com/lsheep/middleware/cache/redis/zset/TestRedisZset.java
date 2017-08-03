package com.lsheep.middleware.cache.redis.zset;

import org.junit.Test;

import com.lsheep.middleware.cache.redis.RedisCache;
import com.lsheep.test.BaseTest;

public class TestRedisZset extends BaseTest {

	private final String namespace = "ARTICLE";

	@Test
	public void testZadd() {
		RedisCache.zadd(namespace, "article_sort:publish_time", "article:001", System.currentTimeMillis());
	}

	@Test
	public void testZcard() {
		System.out.println(RedisCache.zcard(namespace, "article_sort:publish_time"));
	}

}
