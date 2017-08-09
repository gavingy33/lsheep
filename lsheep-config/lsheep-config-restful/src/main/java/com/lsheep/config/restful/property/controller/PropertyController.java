package com.lsheep.config.restful.property.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsheep.common.core.restful.dto.response.RestResponse;
import com.lsheep.config.restful.property.dto.ConfigNode;

@RestController
@RequestMapping(value = "/property")
public class PropertyController {

	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public RestResponse<List<ConfigNode>> tree() {
		RestResponse<List<ConfigNode>> response = new RestResponse<>();

		List<ConfigNode> roots = new ArrayList<>();

		ConfigNode node = new ConfigNode();
		node.setName("AAA");

		roots.add(node);
		roots.add(node);
		roots.add(node);
		
		List<ConfigNode> children = new ArrayList<>();
		ConfigNode nodeb = new ConfigNode();
		nodeb.setName("BBB");
		children.add(nodeb);
		node.setChildren(children);
		response.setBody(roots);
		return response;
	}

}
