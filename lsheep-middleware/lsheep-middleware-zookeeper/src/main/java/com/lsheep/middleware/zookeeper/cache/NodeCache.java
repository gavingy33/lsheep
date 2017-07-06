package com.lsheep.middleware.zookeeper.cache;

import java.io.Closeable;
import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;

import com.google.common.base.Charsets;

public class NodeCache implements Closeable {

	private String path;
	private CuratorFramework client;
	private org.apache.curator.framework.recipes.cache.NodeCache nodeCache;

	public NodeCache(CuratorFramework client, String path) throws Exception {
		this.client = client;
		this.path = path;
		loadCache();
	}

	private void loadCache() throws Exception {
		nodeCache = new org.apache.curator.framework.recipes.cache.NodeCache(client, path);
		nodeCache.start(true);
	}

	public String data() {
		return new String(nodeCache.getCurrentData().getData(), Charsets.UTF_8);
	}

	@Override
	public void close() throws IOException {
		nodeCache.close();
	}

}
