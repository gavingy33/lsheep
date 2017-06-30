package com.lsheep.middleware.mq.topic.base;

import java.util.HashSet;
import java.util.Set;

public abstract class MessageQueueTopic {

	protected String tag;
	protected static String TOPIC;
	protected static final Set<String> TAGS = new HashSet<>();

	public MessageQueueTopic(TopicTag topicTag) {
		this.tag = topicTag.name();
	}

	public String name() {
		return TOPIC;
	}

	public String tag() {
		return this.tag;
	}

	public static Set<String> tags() {
		return TAGS;
	}

}
