package com.lsheep.middleware.mq.factory.impl;

import com.lsheep.common.core.base.annotation.Factory;
import com.lsheep.middleware.mq.MqConfig;
import com.lsheep.middleware.mq.MqConsumer;
import com.lsheep.middleware.mq.MqProducer;
import com.lsheep.middleware.mq.factory.MqFactory;
import com.lsheep.middleware.mq.rocketmq.producer.RocketMqProducer;

@Factory
public class MqFactoryImpl implements MqFactory {

	@Override
	public MqProducer producer(MqConfig mqConfig) {
		switch (mqConfig.getMqType()) {
		case ROCKET_MQ:
			return new RocketMqProducer(mqConfig);
		default:
			break;
		}
		throw new RuntimeException("错误的MQ配置: " + mqConfig);
	}

	@Override
	public MqConsumer consumer(MqConfig mqConfig) {
		// TODO Auto-generated method stub
		return null;
	}

}
