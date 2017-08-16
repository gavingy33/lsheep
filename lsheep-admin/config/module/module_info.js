define([ "jquery", "toastr", "table", "order", "tree" ], function($, toastr, table, order, tree) {

	function initOrder() {
		order.init({
			name : "#moduleOrder",
			onOrderChange : orderModule
		});
	}

	function orderModule() {
		var modules = table.getData({
			tabelName : "#moduleOrder #moduleTable",
			useCurrentPage : true
		});
		$(modules).each(function(index, module) {
			module.weight = index;
		});
		$.ajax({
			type : "POST",
			data : JSON.stringify(modules),
			contentType : "application/json",
			url : "/config-restful/property/module/order",
			success : function(response) {
				var header = response.header;
				if (header.statusCode != 200) {
					toastr.error(header.message);
					return;
				}
				var treeConfig = {
					treeName : "#modulePanel #configTree"
				};
				tree.refreshNode(treeConfig);
			}
		});
	}

	var createTable = function(treeNode) {
		table.create({
			tabelName : "#moduleOrder #moduleTable",
			url : "/config-restful/property/node",
			queryParams : {
				parentId : treeNode.id,
				withModule : true,
				withProperty : false
			},
			columns : [ {
				field : "propertyId",
				title : "栏目ID"
			}, {
				field : "code",
				title : "栏目编码",
				align : "left"
			}, {
				field : "name",
				title : "栏目名称"
			}, {
				field : "path",
				title : "栏目路径",
				align : "left"
			}, {
				field : "weight",
				title : "排序",
				formatter : function(index, row) {
					return order.create();
				}
			} ],
			onLoadSuccess : function(data) {
				initOrder()
			},
			onShowColumns : function(data) {
				initOrder()
			}
		});
	};

	return {
		onload : function(treeNode) {
			createTable(treeNode);
		}
	}
});