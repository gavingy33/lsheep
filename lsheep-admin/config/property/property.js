define([ "jquery", "toastr", "table" ], function($, toastr, table) {

	var createTable = function(treeNode) {
		table.table({
			tabelName : "#property #propertyTable"
		});
	};




	return {
		onload : function(treeNode) {
			createTable(treeNode);
		}
	}
});