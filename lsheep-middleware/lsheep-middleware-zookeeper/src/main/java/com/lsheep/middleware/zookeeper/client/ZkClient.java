package com.lsheep.middleware.zookeeper.client;

import java.io.Closeable;
import java.io.IOException;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.PathUtils;

import com.lsheep.middleware.zookeeper.cache.NodeCache;
import com.lsheep.middleware.zookeeper.cache.TreeCache;

public class ZkClient implements Closeable {

	private String platform;
	private CuratorFramework framework;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public ZkClient(ZkConfig zkConfig) {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		framework = CuratorFrameworkFactory.builder().retryPolicy(retryPolicy).connectString(zkConfig.getConnection())
				.namespace(zkConfig.getNamespace()).build();
		framework.start();
	}

	public TreeCache treeCache(String rootPath) throws Exception {
		PathUtils.validatePath(rootPath);
		return new TreeCache(framework, rootPath);
	}

	public NodeCache nodeCache(String path) throws Exception {
		PathUtils.validatePath(path);
		return new NodeCache(framework, path);
	}

	@Override
	public void close() throws IOException {
		framework.close();
	}

}
