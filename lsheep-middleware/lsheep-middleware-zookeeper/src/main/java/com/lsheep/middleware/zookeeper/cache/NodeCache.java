package com.lsheep.middleware.zookeeper.cache;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.PathUtils;

import com.google.common.base.Charsets;

public class NodeCache implements Cache {

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

	@Override
	public String data() {
		return new String(nodeCache.getCurrentData().getData(), Charsets.UTF_8);
	}

	@Override
	public void close() throws IOException {
		nodeCache.close();
	}

	@Override
	public Map<String, String> all() {
		Map<String, String> result = new LinkedHashMap<>();
		result.put(path, data());
		return result;
	}

	@Override
	public Map<String, String> children(String path) {
		return new LinkedHashMap<>();
	}

	@Override
	public String data(String path) {
		PathUtils.validatePath(path);
		if (!path.equals(this.path)) {
			return null;
		}
		return data();
	}

}
