package com.lsheep.middleware.zookeeper.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;

public class TestCache {

	public static void main(String[] args) throws Exception {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.builder().retryPolicy(retryPolicy)
				.connectString("118.89.196.241:2181").namespace("config").build();
		client.start();
		
		Map<String, String> root = new HashMap<>();
		root.put("name", "根节点");
		root.put("code", "config");
		System.out.println(JSON.toJSONString(root));
		client.setData().forPath("/", JSON.toJSONString(root, true).getBytes(Charsets.UTF_8));

		Map<String, String> webservice = new HashMap<>();
		webservice.put("lsheep.customer.web.url", "http://127.0.0.1:8080");
		webservice.put("lsheep.config.web.url", "http://127.0.0.1:8080");
		System.out.println(JSON.toJSONString(webservice));
		client.setData().forPath("/common/webservice", JSON.toJSONString(webservice, true).getBytes(Charsets.UTF_8));
//		
//		Map<String, String> zookeeper = new HashMap<>();
//		zookeeper.put("lsheep.zk.connection", "118.89.196.241:2181");
//		zookeeper.put("lsheep.zk.namespace", "COMMON");
//		System.out.println(JSON.toJSONString(zookeeper));
//		client.setData().forPath("/common/zookeeper", JSON.toJSONString(zookeeper, true).getBytes(Charsets.UTF_8));
//
//		
//		Map<String, String> messageQueue = new HashMap<>();
//		messageQueue.put("lsheep.mq.type", "ROCKET_MQ");
//		messageQueue.put("lsheep.mq.connection", "118.89.196.241:9876");
//		messageQueue.put("lsheep.mq.groupName", "COMMON");
//		System.out.println(JSON.toJSONString(messageQueue));
//		client.setData().forPath("/common/mq", JSON.toJSONString(messageQueue, true).getBytes(Charsets.UTF_8));
//
//		Map<String, String> map2 = new HashMap<>();
//		map2.put("lsheep.mq.groupName", "LSHEEP_SSO_RESTFUL");
//		map2.put("lsheep.zk.namespace", "config/sso/sso-restful");
//		System.out.println(JSON.toJSONString(map2));
//		client.setData().forPath("/sso/sso-restful", JSON.toJSONString(map2, true).getBytes(Charsets.UTF_8));
//
//		Map<String, String> map3 = new HashMap<>();
//		map3.put("lsheep.mq.groupName", "LSHEEP_CUSTOMER_RESTFUL");
//		map3.put("lsheep.zk.namespace", "config/customer/customer-restful");
//		System.out.println(JSON.toJSONString(map3));
//		client.setData().forPath("/customer/customer-restful", JSON.toJSONString(map3, true).getBytes(Charsets.UTF_8));
//		
		Map<String, String> map8 = new HashMap<>();
		map8.put("lsheep.mq.groupName", "LSHEEP_CONFIG_WEB");
		map8.put("lsheep.zk.namespace", "config");
		map8.put("lsheep.db.driver", "com.mysql.jdbc.Driver");
		map8.put("lsheep.db.url", "jdbc:mysql://lsheep.com:3306/lsheep_config?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
		map8.put("lsheep.db.username", "lsheep");
		map8.put("lsheep.db.password", "lsheep");
		System.out.println(JSON.toJSONString(map8));
		client.setData().forPath("/config/config-web", JSON.toJSONString(map8, true).getBytes(Charsets.UTF_8));
//
//
//		Map<String, String> map4 = new HashMap<>();
//		map4.put("lsheep.mq.groupName", "LSHEEP_CUSTOMER_WEB");
//		map4.put("lsheep.zk.namespace", "config/customer/customer-web");
//		map4.put("lsheep.db.driver", "com.mysql.jdbc.Driver");
//		map4.put("lsheep.db.url",
//				"jdbc:mysql://lsheep.com:3306/lsheep_customer?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
//		map4.put("lsheep.db.username", "lsheep");
//		map4.put("lsheep.db.password", "lsheep");
//
//		System.out.println(JSON.toJSONString(map4));
//		client.setData().forPath("/customer/customer-web", JSON.toJSONString(map4, true).getBytes(Charsets.UTF_8));
//
//		Map<String, String> map5 = new HashMap<>();
//		map5.put("lsheep.mq.groupName", "LSHEEP_ARTICLE_WEB");
//		map5.put("lsheep.zk.namespace", "config/article/article-web");
//		map5.put("lsheep.db.url", "jdbc:mysql://lsheep.com:3306/lsheep_article?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
//		map5.put("lsheep.db.username", "lsheep");
//		map5.put("lsheep.db.password", "lsheep");
//
//		System.out.println(JSON.toJSONString(map4));
//		client.setData().forPath("/article/article-web", JSON.toJSONString(map5, true).getBytes(Charsets.UTF_8));
//
//		PathChildrenCache cache = new PathChildrenCache(client, "/", true);
//		cache.start(StartMode.BUILD_INITIAL_CACHE);
//
//		List<ChildData> childDatas = cache.getCurrentData();
//		for (ChildData childData : childDatas) {
//			System.out.println(String.format("path=%-10s data=[%s]", childData.getPath(),
//					new String(childData.getData(), Charsets.UTF_8)));
//		}
//
//		System.out.println(cache);
//		cache.close();
		client.close();
	}
}
