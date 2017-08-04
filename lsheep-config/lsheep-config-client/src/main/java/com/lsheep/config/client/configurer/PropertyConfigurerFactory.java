package com.lsheep.config.client.configurer;

import static com.lsheep.config.client.common.Constants.PATH_SPLIT;

import java.io.IOException;
import java.io.InputStream;
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

	private static final String COMMON_CONFIG_PATH = "/common";
	private static final String ZK_CONFIG_FILE = "/config/zk-config.properties";
	private static final String PLATFORM_CONFIG_FILE = "/config.properties";
	private static final String ZK_CONNECTION = "lsheep.config.zk.connection";
	private static final String ZK_NAMESPACE = "lsheep.config.zk.namespace";
	private static final String ZK_PLATFORM = "lsheep.config.zk.platform";
	private boolean loadPlatformConfig;// 从远程ZK服务器加载配置

	private Properties properties = new Properties();

	public PropertyPlaceholderConfigurer create() throws Exception {
		// 加载ZK连接地址和平台名称
		loadProperties();
		// 建立配置类
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setOrder(2);
		configurer.setIgnoreUnresolvablePlaceholders(true);
		configurer.setProperties(properties);
		ZkClient zkClient = createZkClient();
		// 加载并解析通用配置
		Cache commonCache = zkClient.childCache(COMMON_CONFIG_PATH);
		resolve(commonCache);
		commonCache.close();
		if (loadPlatformConfig) {
			// 加载并解析平台独立配置
			String platform = zkClient.getPlatform();
			String prefix = PATH_SPLIT.concat(platform.substring(0, platform.indexOf('-'))).concat(PATH_SPLIT);
			Cache platformCache = zkClient.childCache(prefix + platform);
			resolve(platformCache);
			platformCache.close();
		}
		// 释放资源
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
		properties.load(getClass().getResourceAsStream(ZK_CONFIG_FILE));
		InputStream platformConfig = getClass().getResourceAsStream(PLATFORM_CONFIG_FILE);
		if (platformConfig != null) {
			loadPlatformConfig = true;
			properties.load(platformConfig);
		}
	}

	private ZkClient createZkClient() {
		ZkConfig zkConfig = new ZkConfig();
		zkConfig.setConnection(properties.getProperty(ZK_CONNECTION));
		zkConfig.setNamespace(properties.getProperty(ZK_NAMESPACE));
		ZkClient zkClient = new ZkClient(zkConfig);
		zkClient.setPlatform(properties.getProperty(ZK_PLATFORM));
		return zkClient;
	}

}
