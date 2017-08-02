var Module = function() {

	var tree = [
		{
			text : "通用服务",
			nodes : [
				{
					text : "地址配置"
				},
				{
					text : "其他配置"
				}
			]
		},
		{
			text : "客户服务"
		},
		{
			text : "登陆服务"
		}
	];

	var initTree = function() {
		$("#module #module_panel").treeview({
			data : tree
		});


	};


	return {
		onload : function() {
			initTree();
		}
	}
}();

$(function() {
	Module.onload();
});