define([ "jquery", "ztree" ], function($, ztree) {

	var treeName = null;
	var setting = {
		async : {
			//			url : "http://host/getNode.php",
			//			otherParam: { "id":"1", "name":"test"},
			enable : true,
			contentType : "application/x-www-form-urlencoded",
			autoParam : [ "id" ],
			dataType : "text",
			type : "GET",
			dataFilter : function(treeId, parentNode, response) {
				var header = response.header;
				if (header.statusCode != 200) {
					console.error(header.message);
					return;
				}
				var treeNodes = [];
				if (parentNode) {
					treeNodes = response.body.children;
				} else {
					treeNodes.push(response.body);
				}
				return treeNodes;
			}
		},
		callback : {
			onExpand : function(event, treeId, treeNode) {
				//树形菜单右击事件
				$("li, a", $(treeName)).contextmenu({
					target : '#zTreeRightMenuContainer', //此设置项是zTree的容器
					before : function(e, element, target) {
						var zTreeObj = $.fn.zTree.getZTreeObj(treeName);
						//当前右击节点ID
						var selectedId = element[0].tagName == 'LI' ? element.attr('id') : element.parent().attr('id');
						//根据节点ID获取当前节点详细信息
						curSelectNode = zTreeObj.getNodeByTId(selectedId);
						//当前节点的层级
						zTreeObj.selectNode(curSelectNode);
					},
					onItem : function(context, e) {
						var action = $(e.target).attr('action');
						this.closemenu();
						if (action) {
							zTreeRightMenuFuns[action]();
						}
					}
				});
			}
		}
	};

	var tree = function(treeConfig) {
		treeName = treeConfig.treeName;
		setting.async.url = treeConfig.url; //ajax地址
		setting.async.otherParam = treeConfig.queryParam; //ajax参数(可选)
		setting.callback.onClick = treeConfig.onClick; //左击回调事件
		setting.callback.onRightClick = treeConfig.onRightClick; //右击回调事件
		setting.callback.onExpand = treeConfig.onExpand; // 
		$.fn.zTree.init($(treeName), setting);
	};

	return {
		asyncTree (treeConfig) {
			tree(treeConfig);
		}
	}

});