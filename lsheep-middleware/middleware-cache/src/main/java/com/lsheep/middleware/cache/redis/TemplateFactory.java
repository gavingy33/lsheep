package com.lsheep.middleware.cache.redis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsheep.common.core.base.annotation.Factory;

@Factory
@SuppressWarnings("unchecked")
public class TemplateFactory implements ApplicationContextAware {

	private static JedisConnectionFactory jedisConnFactory;

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private static final Map<Object, RedisTemplate<?, ?>> TEMPLATE_POOL = new ConcurrentHashMap<>();

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		jedisConnFactory = applicationContext.getBean(JedisConnectionFactory.class);
	}

	private static JavaType buildJavaType(Class<?> parametrized, Class<?>... parameterClasses) {
		return MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
	}

	public static <V> RedisTemplate<String, V> createTemplate(Class<V> clazz) {
		RedisTemplate<String, V> cachedTemplate = (RedisTemplate<String, V>) TEMPLATE_POOL.get(clazz);
		if (cachedTemplate != null) {
			return cachedTemplate;
		}
		RedisTemplate<String, V> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnFactory);
		StringRedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
		if (clazz != String.class) {
			Jackson2JsonRedisSerializer<V> jsonSerializer = new Jackson2JsonRedisSerializer<>(clazz);
			redisTemplate.setValueSerializer(jsonSerializer);
		}
		redisTemplate.afterPropertiesSet();
		TEMPLATE_POOL.put(clazz, redisTemplate);
		return redisTemplate;
	}

	public static <V> RedisTemplate<String, V> createTemplate(Class<?> parametrized, Class<?>... parameterClasses) {
		JavaType javaType = buildJavaType(parametrized, parameterClasses);
		RedisTemplate<String, V> cachedTemplate = (RedisTemplate<String, V>) TEMPLATE_POOL.get(javaType);
		if (cachedTemplate != null) {
			return cachedTemplate;
		}
		RedisTemplate<String, V> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnFactory);
		StringRedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		Jackson2JsonRedisSerializer<V> jsonSerializer = new Jackson2JsonRedisSerializer<>(javaType);
		redisTemplate.setValueSerializer(jsonSerializer);
		redisTemplate.afterPropertiesSet();
		TEMPLATE_POOL.put(javaType, redisTemplate);
		return redisTemplate;
	}

}
