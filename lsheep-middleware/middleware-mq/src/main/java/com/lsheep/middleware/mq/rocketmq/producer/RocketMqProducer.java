package com.lsheep.middleware.mq.rocketmq.producer;

import java.nio.charset.Charset;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionCheckListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import com.lsheep.common.core.base.Base;
import com.lsheep.middleware.mq.MqConfig;
import com.lsheep.middleware.mq.MqProducer;
import com.lsheep.middleware.mq.model.MqMessage;
import com.lsheep.middleware.mq.model.MqSendResult;

public class RocketMqProducer extends Base implements MqProducer {

	private TransactionMQProducer mqProducer;
	private TransactionCheckListener checkListener;

	public RocketMqProducer(MqConfig mqConfig) {
		try {
			mqProducer = new TransactionMQProducer(mqConfig.getGroupName());
			mqProducer.setNamesrvAddr(mqConfig.getConnection());
			mqProducer.setTransactionCheckListener(checkListener);
			mqProducer.start();
		} catch (MQClientException e) {
			logger.error("RocketMQ推送组启动失败", e);
		}
	}

	public void shutdown() {
		if (mqProducer != null) {
			mqProducer.shutdown();
		}
	}

	@Override
	public MqSendResult send(MqMessage<?> mqMessage) {
		MqSendResult mqSendResult = new MqSendResult();
		try {
			Message message = new Message();
			message.setTopic("");
			message.setTags("");
			message.setBody("".getBytes(Charset.forName("UTF-8")));
			message.setKeys("");
			SendResult sendResult = mqProducer.send(message);
			logger.info("RocketMQ消息推送结果:{}", sendResult);
			mqSendResult.success();
		} catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
			logger.error("RocketMQ消息推送异常", e);
		}
		return mqSendResult;
	}

	@Override
	public MqSendResult sendInTransaction(MqMessage<?> mqMessage) {
		MqSendResult mqSendResult = new MqSendResult();
		try {
			Message message = new Message();
			message.setTopic("");
			message.setTags("");
			message.setBody("".getBytes(Charset.forName("UTF-8")));
			message.setKeys("");
			SendResult sendResult = mqProducer.sendMessageInTransaction(message, null, null);
			logger.info("RocketMQ消息推送结果:{}", sendResult);
			mqSendResult.success();
		} catch (MQClientException e) {
			logger.error("RocketMQ消息推送异常", e);
		}
		return mqSendResult;
	}

}
