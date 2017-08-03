package com.lsheep.middleware.cache.redis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import com.lsheep.common.core.check.ParamsCheck;

@SuppressWarnings("unchecked")
public class RedisCache {

	private static final String NAMESPACE_SPLIT = "#";

	private static String cacheKey(String namespace, String key) {
		ParamsCheck.notEmpty("命名空间不能为空", namespace);
		ParamsCheck.notEmpty("键不能为空", key);
		return namespace.concat(NAMESPACE_SPLIT).concat(key);
	}

	// 字符串操作
	public static String get(String namespace, String key) {
		return get(namespace, key, String.class);
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

	// 哈希操作
	public static <V> void hset(String namespace, String key, String hashKey, V value) {
		RedisTemplate<String, V> redisTemplate = (RedisTemplate<String, V>) TemplateFactory
				.createTemplate(value.getClass());
		HashOperations<String, String, V> operations = redisTemplate.opsForHash();
		operations.put(cacheKey(namespace, key), hashKey, value);
	}

	public static <V> V hget(String namespace, String key, String hashKey, Class<V> clazz) {
		RedisTemplate<String, V> redisTemplate = (RedisTemplate<String, V>) TemplateFactory.createTemplate(clazz);
		HashOperations<String, String, V> operations = redisTemplate.opsForHash();
		return operations.get(cacheKey(namespace, key), hashKey);
	}

	public static <V> Map<String, V> hgetall(String namespace, String key, Class<V> clazz) {
		RedisTemplate<String, V> redisTemplate = (RedisTemplate<String, V>) TemplateFactory.createTemplate(clazz);
		HashOperations<String, String, V> operations = redisTemplate.opsForHash();
		return operations.entries(cacheKey(namespace, key));
	}

	// 有序集合操作
	public static Boolean zadd(String namespace, String key, String value, Number score) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.add(cacheKey(namespace, key), value, score.doubleValue());
	}

	public static Double zincrby(String namespace, String key, String value, Number score) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.incrementScore(cacheKey(namespace, key), value, score.doubleValue());
	}

	public static Long zcard(String namespace, String key) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.zCard(cacheKey(namespace, key));
	}

	public static Set<String> zrange(String namespace, String key, Number start, Number end) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.range(cacheKey(namespace, key), start.longValue(), end.longValue());
	}

	public static LinkedHashMap<String, Double> zrangeWithscores(String namespace, String key, Number start,
			Number end) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		Set<TypedTuple<String>> set = operations.rangeWithScores(cacheKey(namespace, key), start.longValue(),
				end.longValue());
		LinkedHashMap<String, Double> map = new LinkedHashMap<>();
		for (TypedTuple<String> typedTuple : set) {
			map.put(typedTuple.getValue(), typedTuple.getScore());
		}
		return map;
	}

	// 无序集合操作
	public static <V> Long sadd(String namespace, String key, String... values) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.add(cacheKey(namespace, key), values);
	}

	public static Boolean sismember(String namespace, String key, String value) {
		RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) TemplateFactory
				.createTemplate(String.class);
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.isMember(cacheKey(namespace, key), value);
	}

}
