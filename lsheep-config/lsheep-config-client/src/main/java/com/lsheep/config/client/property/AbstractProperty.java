package com.lsheep.config.client.property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.zookeeper.common.PathUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.lsheep.middleware.zookeeper.cache.TreeCache;
import com.lsheep.middleware.zookeeper.client.ZkClient;

public abstract class AbstractProperty {

	private String rootPath;

	protected TreeCache treeCache;

	@Resource
	private ZkClient zkClient;

	@PostConstruct
	public void cache() throws Exception {
		rootPath = definePath();
		PathUtils.validatePath(rootPath);
		treeCache = zkClient.treeCache(rootPath);
	}

	public String getRootPath() {
		return rootPath;
	}

	protected abstract String definePath();

	public Node node(String path) {
		String data = treeCache.data(path);
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		Node node = JSON.parseObject(data, Node.class);
		node.setPath(path);
		return node;
	}

	public <T> T property(String path, Class<T> clazz) {
		Node node = node(path);
		return node == null ? null : JSON.parseObject(node.getBizModel(), clazz);
	}

	public List<Node> child(String path) {
		List<Node> nodes = new ArrayList<>();
		Map<String, String> child = treeCache.children(path);
		if (child == null) {
			return nodes;
		}
		for (Map.Entry<String, String> entry : child.entrySet()) {
			Node node = JSON.parseObject(entry.getValue(), Node.class);
			node.setPath(entry.getKey());
			nodes.add(node);
		}
		return nodes;
	}

}
