package com.lsheep.middleware.mq.model;

import com.lsheep.middleware.mq.topic.base.MessageQueueTopic;

public class MqMessage<T> {

	private String key;
	private MessageQueueTopic topic;
	private T model;

	public MessageQueueTopic getTopic() {
		return topic;
	}

	public void setTopic(MessageQueueTopic topic) {
		this.topic = topic;
	}

	public void setTopic(MessageQueueTopic topic, String key) {
		this.topic = topic;
		this.key = key;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
