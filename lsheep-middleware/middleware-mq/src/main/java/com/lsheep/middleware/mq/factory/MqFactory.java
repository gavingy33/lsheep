package com.lsheep.middleware.mq.factory;

import com.lsheep.middleware.mq.MqConfig;
import com.lsheep.middleware.mq.MqConsumer;
import com.lsheep.middleware.mq.MqProducer;

public interface MqFactory {

	MqProducer producer(MqConfig mqConfig);

	MqConsumer consumer(MqConfig mqConfig);

}
