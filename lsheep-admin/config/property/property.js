define([ "jquery", "toastr", "table" ], function($, toastr, table) {

	var createTable = function(treeNode) {
		table.create({
			tabelName : "#property #propertyTable",
			url : "/config-restful/property/node",
			queryParams : {
				parentId : treeNode.id
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

	return {
		onload : function(treeNode) {
			createTable(treeNode);
		}
	}
});