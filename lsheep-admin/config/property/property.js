define([ "jquery", "toastr", "table" ], function($, toastr, table) {

	var createTable = function(treeNode) {
		table.create({
			tabelName : "#property #propertyTable",
			url : "/config-restful/property/node",
			toolbar : "#propertyToolbar",
			queryParams : {
				parentId : treeNode.id,
				withModule : false,
				withProperty : true
			},
			columns : [ {
				field : "code",
				title : "属性编码",
				"class" : ""
			}, {
				field : "name",
				title : "属性名称"
			} ]
		});
	};

	function initToolbar(treeNode) {
		$("#propertyToolbar #add").click(function() {
			$("#property #propertyPanel").load("/config/property/property_add.html", function() {
				require([ "/config/property/property_add.js" ], function(propertyAdd) {
					propertyAdd.onload(treeNode);
				});
			});

		});
	}


	return {
		onload : function(treeNode) {
			createTable(treeNode);
			initToolbar(treeNode);
		}
	}
});