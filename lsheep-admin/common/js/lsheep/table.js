define([ "jquery", "bootstrap-table", "toastr" ], function($, table, toastr) {


	var table = function(tableConfig) {
		$(tableConfig.tabelName).bootstrapTable({
			//			ajax : function() {
			//				$.ajax({
			//					url : "/config-restful/property/child/1",
			//					type : "GET",
			//					success : function(response) {
			//						var header = response.header;
			//						if (header.statusCode != 200) {
			//							toastr.error(header.message);
			//							return;
			//						}
			//					}
			//				});
			//			}
			pagination : true,
			sidePagination : "server",
			toolbar : "#toolbar",
			undefinedText : "-",
			striped : true,
			search : true,
			showHeader : true,
			showRefresh : true,
			queryParamsType : "",
			//			showToggle:true,
			//			showPaginationSwitch:true,
			clickToSelect : true,
			showColumns : true,

			method : "GET",
			url : "/config-restful/property/child/1",
			cache : false,
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
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