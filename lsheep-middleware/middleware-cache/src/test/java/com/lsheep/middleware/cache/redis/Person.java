package com.lsheep.middleware.cache.redis;

public class Person<T> {
	private String name;
	private Double weight;
	private T nickName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public T getNickName() {
		return nickName;
	}

	public void setNickName(T nickName) {
		this.nickName = nickName;
	}

}
