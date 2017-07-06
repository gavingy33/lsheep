package com.lsheep.middleware.zookeeper.cache;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.utils.PathUtils;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Charsets;

public class TreeCache implements Closeable {

	private CuratorFramework client;
	private String rootPath;
	private org.apache.curator.framework.recipes.cache.NodeCache rootCache;
	private Map<String, PathChildrenCache> cacheMap = new ConcurrentHashMap<>();

	public TreeCache(CuratorFramework client, String rootPath) throws Exception {
		this.client = client;
		this.rootPath = rootPath;
		rootCache();
		loadCache();
	}

	private void rootCache() throws Exception {
		rootCache = new org.apache.curator.framework.recipes.cache.NodeCache(client, rootPath);
		rootCache.start(true);
	}

	private void loadCache() throws Exception {
		PathChildrenCache root = new PathChildrenCache(client, rootPath, true);
		root.start(StartMode.BUILD_INITIAL_CACHE);
		loadCache(rootPath, root);
	}

	private void loadCache(String parentPath, PathChildrenCache parent) throws Exception {
		cacheMap.put(parentPath, parent);
		List<ChildData> childDatas = parent.getCurrentData();
		if (CollectionUtils.isEmpty(childDatas)) {
			return;
		}
		for (ChildData childData : childDatas) {
			String path = childData.getPath();
			PathChildrenCache node = new PathChildrenCache(client, path, true);
			node.start(StartMode.BUILD_INITIAL_CACHE);
			loadCache(path, node);
		}
	}

	@Override
	public void close() throws IOException {
		rootCache.close();
		for (Map.Entry<String, PathChildrenCache> entry : cacheMap.entrySet()) {
			entry.getValue().close();
		}
	}

	public String data(String path) {
		PathUtils.validatePath(path);
		if (rootPath.equals(path)) {
			return new String(rootCache.getCurrentData().getData(), Charsets.UTF_8);
		}
		PathChildrenCache cache = cacheMap.get(path.substring(path.indexOf('/', 1)));
		if (cache == null) {
			return null;
		}
		for (ChildData childData : cache.getCurrentData()) {
			if (!path.equals(childData.getPath())) {
				continue;
			}
			return new String(childData.getData(), Charsets.UTF_8);
		}
		return null;
	}

	public Map<String, String> children(String path) {
		PathUtils.validatePath(path);
		Map<String, String> result = new TreeMap<>();
		PathChildrenCache cache = cacheMap.get(path);
		if (cache == null) {
			return result;
		}
		for (ChildData childData : cache.getCurrentData()) {
			result.put(childData.getPath(), new String(childData.getData(), Charsets.UTF_8));
		}
		return result;
	}

	public Map<String, String> all() {
		Map<String, String> result = new TreeMap<>();
		result.put(rootPath, new String(rootCache.getCurrentData().getData(), Charsets.UTF_8));
		for (Map.Entry<String, PathChildrenCache> entry : cacheMap.entrySet()) {
			PathChildrenCache cache = entry.getValue();
			for (ChildData childData : cache.getCurrentData()) {
				result.put(childData.getPath(), new String(childData.getData(), Charsets.UTF_8));
			}
		}
		return result;
	}

}
