package com.lsheep.middleware.mq.factory.impl;

import com.lsheep.common.core.base.annotation.Factory;
import com.lsheep.common.core.check.ParamsCheck;
import com.lsheep.middleware.mq.MqConfig;
import com.lsheep.middleware.mq.MqConsumer;
import com.lsheep.middleware.mq.MqProducer;
import com.lsheep.middleware.mq.factory.MqFactory;
import com.lsheep.middleware.mq.rocketmq.producer.RocketMqProducer;

@Factory
public class MqFactoryImpl implements MqFactory {

	@Override
	public MqProducer producer(MqConfig mqConfig) {
		ParamsCheck.notNull("请配置消息类型", mqConfig.getMqType());
		ParamsCheck.notEmpty("请配置集群组名称", mqConfig.getGroupName());
		ParamsCheck.notEmpty("请配置集群地址", mqConfig.getConnection());
		switch (mqConfig.getMqType()) {
		case ROCKET_MQ:
			return new RocketMqProducer(mqConfig);
		default:
			break;
		}
		return null;
	}

	@Override
	public MqConsumer consumer(MqConfig mqConfig) {
		// TODO Auto-generated method stub
		return null;
	}

}
