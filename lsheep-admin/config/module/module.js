define([ "jquery", "tree", "table", "toastr" ], function($, tree, table, toastr) {

	var initTree = function() {
		tree.asyncTree({
			treeName : "#modulePanel #configTree",
			url : "/config-restful/property/tree",
			onClick : function(event, treeId, treeNode) {
				$("#panelIndex").empty().load("/config/property/property.html", function() {
					require([ "/config/property/property.js" ], function(property) {
						property.onload(treeNode);
					});
				});
			},
			rigthClickMenus : function(treeNode) {
				return menus(treeNode);
			}
		});
	};

	var menus = function(treeNode) {
		$panelIndex = $("#panelIndex");
		var add = {
			name : "新增",
			action : function(event, treeId, treeNode) {
				$panelIndex.empty().load("/config/module/module_add.html", function() {
					require([ "/config/module/module_add.js" ], function(moduleAdd) {
						moduleAdd.onload(treeNode);
					});
				});
			}
		};
		var modify = {
			name : "修改",
			action : function(event, treeId, treeNode) {}
		};
		var del = {
			name : "删除",
			action : function(event, treeId, treeNode) {
				toastr.info("delete" + treeNode.name);
			}
		};

		var items = [];
		if (treeNode.isModule) {
			items.push(add);
			items.push(modify);
			items.push(del);
		}
		return items;
	}

	var nodePanel = function(treeNode) {
		$.ajax({
			url : "/config-restful/property/node/" + treeNode.id,
			type : "GET",
			success : function(response) {
				var header = response.header;
				if (header.statusCode != 200) {
					toastr.error(header.message);
					return;
				}
				var property = response.body;
			}
		});
	};

	return {
		onload : function() {
			initTree();
		}
	}

});