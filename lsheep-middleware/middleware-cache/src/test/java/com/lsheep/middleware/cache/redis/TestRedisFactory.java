package com.lsheep.middleware.cache.redis;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.alibaba.fastjson.JSON;
import com.lsheep.test.BaseTest;

public class TestRedisFactory extends BaseTest {

	@Test
	public void testCreate01() {
		try {
			RedisTemplate<String, String> redisTemplate = TemplateFactory.createTemplate(String.class);
			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			System.err.println(operations.get("gao.feng"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreate02() {
		try {
			RedisTemplate<String, Person<Demo>> redisTemplate = TemplateFactory.createTemplate(Person.class,
					Demo.class);
			ValueOperations<String, Person<Demo>> operations = redisTemplate.opsForValue();
			System.err.println(JSON.toJSONString(operations.get("gao.feng")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreate03() {
		try {
			RedisTemplate<String, Person<Demo>> redisTemplate01 = TemplateFactory.createTemplate(Person.class,
					Demo.class);
			RedisTemplate<String, Person<Demo>> redisTemplate02 = TemplateFactory.createTemplate(Person.class,
					Demo.class);
			System.out.println(redisTemplate01 == redisTemplate02);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
