package com.lsheep.middleware.zookeeper.cache;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.utils.PathUtils;

import com.google.common.base.Charsets;

public class ChildCache implements Cache {

	private String rootPath;
	private CuratorFramework client;
	private NodeCache rootCache;
	private PathChildrenCache childrenCache;

	public ChildCache(CuratorFramework client, String rootPath) throws Exception {
		this.client = client;
		this.rootPath = rootPath;
		loadCache();
	}

	private void loadCache() throws Exception {
		rootCache = new NodeCache(client, rootPath);
		rootCache.start(true);
		childrenCache = new PathChildrenCache(client, rootPath, true);
		childrenCache.start(StartMode.BUILD_INITIAL_CACHE);
	}

	@Override
	public void close() throws IOException {
		childrenCache.close();
		rootCache.close();
	}

	@Override
	public String data(String path) {
		PathUtils.validatePath(path);
		if (rootPath.equals(path)) {
			return new String(rootCache.getCurrentData().getData(), Charsets.UTF_8);
		}
		List<ChildData> childDatas = childrenCache.getCurrentData();
		for (ChildData childData : childDatas) {
			if (!path.equals(childData.getPath())) {
				continue;
			}
			return new String(childData.getData(), Charsets.UTF_8);
		}
		return null;
	}

	@Override
	public Map<String, String> all() {
		Map<String, String> result = new LinkedHashMap<>();
		result.put(rootPath, new String(rootCache.getCurrentData().getData(), Charsets.UTF_8));
		result.putAll(children(rootPath));
		return result;
	}

	@Override
	public Map<String, String> children(String path) {
		Map<String, String> result = new LinkedHashMap<>();
		for (ChildData childData : childrenCache.getCurrentData()) {
			result.put(childData.getPath(), new String(childData.getData(), Charsets.UTF_8));
		}
		return result;
	}

	@Override
	public String data() {
		return data(rootPath);
	}

}
