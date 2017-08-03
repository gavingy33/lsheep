package com.lsheep.middleware.cache.redis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.TypeReference;
import com.lsheep.common.core.base.annotation.Factory;
import com.lsheep.common.core.check.ParamsCheck;

@Factory
@SuppressWarnings("unchecked")
public class TemplateFactory implements ApplicationContextAware {

	private static JedisConnectionFactory jedisConnFactory;

	private static final Map<Object, RedisTemplate<?, ?>> TEMPLATE_POOL = new ConcurrentHashMap<>();

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		jedisConnFactory = applicationContext.getBean(JedisConnectionFactory.class);
	}

	public static <V> RedisTemplate<String, V> createTemplate(Class<V> clazz) {
		ParamsCheck.notNull("clazz can't be null", clazz);
		RedisTemplate<String, V> cachedTemplate = (RedisTemplate<String, V>) TEMPLATE_POOL.get(clazz);
		if (cachedTemplate != null) {
			return cachedTemplate;
		}
		RedisTemplate<String, V> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnFactory);
		StringRedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setHashValueSerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
		if (clazz != String.class) {
			JsonRedisSerializer<V> jsonSerializer = new JsonRedisSerializer<>(clazz);
			redisTemplate.setValueSerializer(jsonSerializer);
			redisTemplate.setHashValueSerializer(jsonSerializer);
		}
		redisTemplate.afterPropertiesSet();
		TEMPLATE_POOL.put(clazz, redisTemplate);
		return redisTemplate;
	}

	public static <V> RedisTemplate<String, V> createTemplate(TypeReference<V> typeReference) {
		ParamsCheck.notNull("typeReference can't be null", typeReference);
		RedisTemplate<String, V> cachedTemplate = (RedisTemplate<String, V>) TEMPLATE_POOL.get(typeReference);
		if (cachedTemplate != null) {
			return cachedTemplate;
		}
		RedisTemplate<String, V> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnFactory);
		StringRedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		JsonRedisSerializer<V> jsonSerializer = new JsonRedisSerializer<>(typeReference);
		redisTemplate.setValueSerializer(jsonSerializer);
		redisTemplate.setHashValueSerializer(jsonSerializer);
		redisTemplate.afterPropertiesSet();
		TEMPLATE_POOL.put(typeReference.getType(), redisTemplate);
		return redisTemplate;
	}

}
