define([ "jquery", "ztree", "toastr" ], function($, ztree, toastr) {

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
		}
	};

	var tree = function(treeConfig) {
		setting.async.url = treeConfig.url; //ajax地址
		setting.async.otherParam = treeConfig.queryParam; //ajax参数(可选)
		setting.callback.onClick = treeConfig.onClick; //左击回调事件
		$zTree = $(treeConfig.treeName);
		$container = $zTree.parent();
		// 右击回调事件
		setting.callback.onRightClick = function(event, treeId, treeNode) {
			if (!treeNode) {
				return;
			}
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
				$zTreeMenu.append("<a class='tree-menu' href='javascript:void(0)' id='" + itemId + "'><i class='fa fa-edit'></i>" + menu.name + "</a><br/>");
				$menuItem = $("#" + itemId, $zTreeMenu);
				$menuItem.click(function() {
					menu.action(event, treeId, treeNode);
				});
			});
		};
		// 构造tree
		$.fn.zTree.init($zTree, setting);
		// 初始化菜单面板
		$container.append("<div id='zTreeMenu' style='display:none;'></div>");
	};

	return {
		asyncTree (treeConfig) {
			tree(treeConfig);
		}
	}

});