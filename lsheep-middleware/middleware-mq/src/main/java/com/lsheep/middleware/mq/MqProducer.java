package com.lsheep.middleware.mq;

import com.lsheep.middleware.mq.model.MqMessage;
import com.lsheep.middleware.mq.model.MqSendResult;

public interface MqProducer {

	MqSendResult send(MqMessage<?> mqMessage);

	MqSendResult sendInTransaction(MqMessage<?> mqMessage);

}
