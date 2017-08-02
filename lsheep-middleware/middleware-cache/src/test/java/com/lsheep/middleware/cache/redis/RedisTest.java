package com.lsheep.middleware.cache.redis;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.alibaba.fastjson.JSON;
import com.lsheep.test.BaseTest;

public class RedisTest extends BaseTest {

	@Resource
	private RedisTemplate redisTemplate;

	@Test
	public void testSet() {
		ValueOperations<String, Person<Demo>> operations = redisTemplate.opsForValue();
		Person<Demo> person = new Person<>();
		person.setName("GaoFeng");
		person.setWeight(114d);
		Demo demo = new Demo();
		demo.setA("a");
		demo.setB(1L);
		person.setNickName(demo);
		operations.set("gao.feng", person);
	}

	@Test
	public void testGet01() {
		ValueOperations<String, Person<Demo>> operations = redisTemplate.opsForValue();
		Person<Demo> person = operations.get("gao.feng");
		System.out.println(JSON.toJSONString(person));
	}

	@Test
	public void testGet02() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		String person = operations.get("gao.feng");
		System.out.println(person);
	}

	@Test
	public void testPutHash() {
		HashOperations<String, String, String> hash = redisTemplate.opsForHash();
		Map<String, String> map = new HashMap<>();
		map.put("name", "gao.feng");
		map.put("weight", "114");
		hash.putAll("person", map);
	}

	@Test
	public void testGetHash() {
		HashOperations<String, String, String> hash = redisTemplate.opsForHash();
		Map<String, String> map = hash.entries("person");
		System.out.println(JSON.toJSONString(map));
	}

}
