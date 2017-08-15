define([ "jquery", "bootstrap-table", "toastr" ], function($, table, toastr) {


	var table = function(tableConfig) {
		$(tableConfig.tabelName).bootstrapTable({
			pagination : true,
			paginationLoop : false,
			sidePagination : "server",
			pageNumber : 1,
			pageSize : 2,
			pageList : [ 10, 20, 50, "ALL" ],
			paginationFirstText : "首页",
			paginationPreText : "上一页",
			paginationNextText : "下一页",
			paginationLastText : "尾页",
			//			toolbar : "#toolbar",
			undefinedText : "-",
			striped : true,
			search : true,
			showHeader : true,
			showRefresh : true,
			queryParamsType : "",
			clickToSelect : true,
			showColumns : true,

			method : "GET",
			url : "/config-restful/property/node",
			cache : false,
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			queryParams : function(params) {
				var queryParams = tableConfig.queryParams;
				for (var param in queryParams) {
					params[param] = queryParams[param];
				}
				return params;
			},

			ajaxOptions : {},
			responseHandler : function(response) {
				var header = response.header;
				if (header.statusCode != 200) {
					toastr.error(header.message);
					return [];
				}
				return response.body;
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
		table (tableConfig) {
			table(tableConfig);
		}
	}
});