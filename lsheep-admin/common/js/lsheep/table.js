define([ "jquery", "bootstrap-table", "toastr", "bootstrap" ], function($, table, toastr, bootstrap) {

	var create = function(tableConfig) {
		$(tableConfig.tabelName).bootstrapTable({
			pagination : true,
			paginationLoop : false,
			sidePagination : "server",
			pageNumber : 1,
			pageSize : tableConfig.pageSize || 10,
			pageList : tableConfig.pageList || [ 10, 15, "All" ],
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
			onShowColumns : tableConfig.onShowColumns,

			method : "GET",
			url : tableConfig.url,
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
			columns : tableConfig.columns,
			onLoadSuccess : tableConfig.onLoadSuccess,
		});
	};

	var getData = function(tableConfig) {
		var $table = $(tableConfig.tabelName);
		var prop = [];
		$("thead tr", $table).first().find("th").each(function() {
			prop.push($(this).attr("data-field"));
		});

		var data = [];
		$("tbody tr", $table).each(function() {
			var value = {};
			$("td", $(this)).each(function(i, element) {
				value[prop[i]] = $(this).text();
			});
			data.push(value);
		});
		return data;
	};

	return {
		create (tableConfig) {
			create(tableConfig);
		},
		getData (tableConfig) {
			return getData(tableConfig);
		}
	}
});