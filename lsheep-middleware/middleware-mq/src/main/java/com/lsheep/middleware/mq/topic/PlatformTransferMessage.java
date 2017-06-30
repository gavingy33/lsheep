package com.lsheep.middleware.mq.topic;

import com.lsheep.middleware.mq.topic.base.MessageQueueTopic;
import com.lsheep.middleware.mq.topic.base.TopicTag;

public class PlatformTransferMessage extends MessageQueueTopic {

	static {
		TOPIC = "PLATFORM_TRANSFER_MESSAGE";
		for (EnumTopicTag topicTag : EnumTopicTag.values()) {
			TAGS.add(topicTag.name());
		}
	}

	public PlatformTransferMessage(TopicTag topicTag) {
		super(topicTag);
	}

	public static enum EnumTopicTag implements TopicTag {
		REQUEST, RESPONSE
	}

}
