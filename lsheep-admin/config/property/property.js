define([ "jquery", "toastr", "table" ], function($, toastr, table) {

	var createTable = function(treeNode) {
		table.table({
			tabelName : "#property #propertyTable",
			queryParams : {
				parentId : treeNode.id
			}
		});
	};




	return {
		onload : function(treeNode) {
			createTable(treeNode);
		}
	}
});