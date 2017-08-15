define([ "jquery", "ztree", "toastr" ], function($, ztree, toastr) {

	var getTreeObj = function(treeConfig) {
		var treeName = treeConfig.treeName;
		return $.fn.zTree.getZTreeObj(treeName.substring(treeName.lastIndexOf("#") + 1));
	};

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
				var treeNodes = [];
				var header = response.header;
				if (header.statusCode != 200) {
					toastr.error(header.message);
					return treeNodes;
				}
				return response.body;
			}
		},
		callback : {
		}
	};

	var asyncTree = function(treeConfig) {
		setting.async.url = treeConfig.url; //ajax地址
		setting.async.otherParam = treeConfig.queryParam; //ajax参数(可选)

		// 左击回调事件
		setting.callback.onClick = function(event, treeId, treeNode) {
			expandNode(treeConfig);
			treeConfig.onClick(event, treeId, treeNode);
		};
		var treeName = treeConfig.treeName;
		$zTree = $(treeName);
		$container = $zTree.parent();
		// 右击回调事件
		setting.callback.onRightClick = function(event, treeId, treeNode) {
			if (!treeNode) {
				return;
			}
			// 选中节点
			getTreeObj(treeConfig).selectNode(treeNode);
			var menus = treeConfig.rigthClickMenus(treeNode);
			if (!menus || menus.lenght == 0) {
				return;
			}
			// 定位
			$zTreeMenu = $("#zTreeMenu", $container).hide().empty().fadeIn();
			$(document).click(function() {
				$zTreeMenu.fadeOut();
			});

			$itemSpan = $("#" + treeNode.tId + "_span").position();
			$zTreeMenu.css("position", "absolute").css("top", $itemSpan.top + 21).css("left", $itemSpan.left);

			// 绑定单击事件
			$.each(menus, function(index, menu) {
				var itemId = "zTreeMenu_item_" + index;
				$zTreeMenu.append("<a href='javascript:void(0)' id='" + itemId + "'><i class='fa fa-th-list'>&nbsp;</i>" + menu.name + "</a><br/>");
				$menuItem = $("#" + itemId, $zTreeMenu);
				$menuItem.click(function() {
					menu.action(event, treeId, treeNode);
				});
			});
		};
		// 构造tree
		$.fn.zTree.init($zTree, setting);
		// 初始化菜单面板
		$container.append("<div id='zTreeMenu' class='tree-menu' style='display:none;'></div>");
	};

	var refreshNode = function(treeConfig) {
		var zTreeObj = getTreeObj(treeConfig);
		var nodes = zTreeObj.getSelectedNodes();
		zTreeObj.reAsyncChildNodes(nodes[0], "refresh", false);
	};

	var expandNode = function(treeConfig) {
		var zTreeObj = getTreeObj(treeConfig);
		var nodes = zTreeObj.getSelectedNodes();
		zTreeObj.expandNode(nodes[0], true, false, true, true);
	};

	return {
		asyncTree (treeConfig) {
			asyncTree(treeConfig);
		},
		refreshNode (treeConfig) {
			refreshNode(treeConfig);
		},
		expandNode (treeConfig) {
			expandNode(treeConfig);
		}
	}

});