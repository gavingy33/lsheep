package com.lsheep.middleware.cache.redis;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonRedisSerializer<T> implements RedisSerializer<T> {

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	private Class<T> clazz;
	private TypeReference<T> typeReference;
	private DeserializeType deserializeType;

	public JsonRedisSerializer(Class<T> clazz) {
		this.clazz = clazz;
		this.deserializeType = DeserializeType.CLAZZ_TYPE;
	}

	public JsonRedisSerializer(TypeReference<T> typeReference) {
		this.typeReference = typeReference;
		this.deserializeType = DeserializeType.REFERENCE_TYPE;
	}

	@Override
	public byte[] serialize(T value) throws SerializationException {
		if (value == null) {
			return new byte[0];
		}
		try {
			return JSON.toJSONString(value).getBytes();
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
		}
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		try {
			String context = new String(bytes, DEFAULT_CHARSET);
			switch (deserializeType) {
			case REFERENCE_TYPE:
				return JSON.parseObject(context, typeReference);
			case CLAZZ_TYPE:
			default:
				return JSON.parseObject(context, clazz);
			}
		} catch (Exception ex) {
			throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
		}
	}

	private enum DeserializeType {
		CLAZZ_TYPE, REFERENCE_TYPE
	}

}