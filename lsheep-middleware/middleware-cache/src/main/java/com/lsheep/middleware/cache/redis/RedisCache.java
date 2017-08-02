package com.lsheep.middleware.cache.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.lsheep.common.core.check.ParamsCheck;

@SuppressWarnings("unchecked")
public class RedisCache {

	private static final String NAMESPACE_SPLIT = "#";

	private static String cacheKey(String namespace, String key) {
		ParamsCheck.notEmpty("命名空间不能为空", namespace);
		ParamsCheck.notEmpty("键不能为空", key);
		return namespace.concat(NAMESPACE_SPLIT).concat(key);
	}

	public static String get(String namespace, String key) {
		RedisTemplate<String, String> redisTemplate = TemplateFactory.createTemplate(String.class);
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		return operations.get(cacheKey(namespace, key));
	}

	public static <V> V get(String namespace, String key, Class<V> clazz) {
		RedisTemplate<String, V> redisTemplate = TemplateFactory.createTemplate(clazz);
		ValueOperations<String, V> operations = redisTemplate.opsForValue();
		return operations.get(cacheKey(namespace, key));
	}

	public static <V> void set(String namespace, String key, V value) {
		RedisTemplate<String, V> redisTemplate = (RedisTemplate<String, V>) TemplateFactory
				.createTemplate(value.getClass());
		ValueOperations<String, V> operations = redisTemplate.opsForValue();
		operations.set(cacheKey(namespace, key), value);
	}

	public static <V> void hput(String namespace, String key, String hashKey, V value) {
		RedisTemplate<String, V> redisTemplate = (RedisTemplate<String, V>) TemplateFactory
				.createTemplate(value.getClass());
		HashOperations<String, String, V> operations = redisTemplate.opsForHash();
		operations.put(cacheKey(namespace, key), hashKey, value);
	}

}
