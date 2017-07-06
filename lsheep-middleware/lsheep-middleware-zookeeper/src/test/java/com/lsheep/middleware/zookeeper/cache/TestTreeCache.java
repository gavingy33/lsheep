package com.lsheep.middleware.zookeeper.cache;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.lsheep.middleware.zookeeper.client.ZkClient;
import com.lsheep.test.BaseTest;

public class TestTreeCache extends BaseTest {

	@Resource
	private ZkClient zkClient;

	@Test
	public void treeCache() throws Exception {
		TreeCache treeCache = zkClient.treeCache("/");
		Map<String, String> map = treeCache.all();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(String.format("path=%-30s vaule=%s", entry.getKey(), entry.getValue()));
		}
		treeCache.close();
	}

	@Test
	public void testNodeCache() throws Exception {
		NodeCache nodeCache = zkClient.nodeCache("/config/common/webservice");
		System.out.println(nodeCache.data());
		nodeCache.close();
	}

}
