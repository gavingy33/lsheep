package com.lsheep.middleware.zookeeper.client;

import java.io.Closeable;
import java.io.IOException;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.PathUtils;

import com.lsheep.middleware.zookeeper.cache.ChildCache;
import com.lsheep.middleware.zookeeper.cache.NodeCache;
import com.lsheep.middleware.zookeeper.cache.TreeCache;

public class ZkClient implements Closeable {

	private CuratorFramework framework;

	public ZkClient(ZkConfig zkConfig) {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		framework = CuratorFrameworkFactory.builder().retryPolicy(retryPolicy).connectString(zkConfig.getConnection())
				.namespace(zkConfig.getNamespace()).build();
		framework.start();
	}

	public TreeCache treeCache(String path) throws Exception {
		PathUtils.validatePath(path);
		return new TreeCache(framework, path);
	}

	public NodeCache nodeCache(String path) throws Exception {
		PathUtils.validatePath(path);
		return new NodeCache(framework, path);
	}

	public ChildCache childCache(String path) throws Exception {
		PathUtils.validatePath(path);
		return new ChildCache(framework, path);
	}

	@Override
	public void close() throws IOException {
		framework.close();
	}

}
