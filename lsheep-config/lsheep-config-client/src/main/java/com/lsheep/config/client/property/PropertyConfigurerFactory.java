package com.lsheep.config.client.property;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lsheep.common.core.base.annotation.Factory;
import com.lsheep.middleware.zookeeper.cache.Cache;
import com.lsheep.middleware.zookeeper.client.ZkClient;
import com.lsheep.middleware.zookeeper.client.ZkConfig;

@Factory
public class PropertyConfigurerFactory {

	private Properties properties = new Properties();

	public PropertyPlaceholderConfigurer create() throws Exception {
		loadProperties();
		ZkClient zkClient = createZkClient();
		Cache commonCache = zkClient.childCache("/common");
		resolve(commonCache);
		String platform = zkClient.getPlatform();
		String prefix = "/" + platform.substring(0, platform.indexOf('-')) + "/";
		Cache platformCache = zkClient.childCache(prefix + platform);
		resolve(platformCache);
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setOrder(2);
		configurer.setIgnoreUnresolvablePlaceholders(true);
		configurer.setProperties(properties);
		// 释放资源
		commonCache.close();
		platformCache.close();
		zkClient.close();
		return configurer;
	}

	private void resolve(Cache cache) {
		Collection<String> configs = cache.all().values();
		for (String config : configs) {
			if (StringUtils.isEmpty(config)) {
				continue;
			}
			JSONObject object = JSON.parseObject(config);
			for (Map.Entry<String, Object> entry : object.entrySet()) {
				properties.put(entry.getKey(), entry.getValue());
			}
		}
	}

	private void loadProperties() throws IOException {
		properties.load(getClass().getResourceAsStream("/config/zk-config.properties"));
		properties.load(getClass().getResourceAsStream("/config.properties"));
	}

	private ZkClient createZkClient() {
		ZkConfig zkConfig = new ZkConfig();
		zkConfig.setConnection(properties.getProperty("lsheep.config.zk.connection"));
		zkConfig.setNamespace(properties.getProperty("lsheep.config.zk.namespace"));
		ZkClient zkClient = new ZkClient(zkConfig);
		zkClient.setPlatform(properties.getProperty("lsheep.config.zk.platform"));
		return zkClient;
	}

}
