requirejs.config({
	baseUrl : "/common/js",
	paths : {
		"jquery" : "jquery/jquery",
		"toastr" : "toastr/toastr",
		"ztree" : "ztree/jquery.ztree.all",
		"bootstrap" : "bootstrap/bootstrap",
		"bootstrap-table" : "bootstrap/bootstrap-table",
		"table-language" : "bootstrap/language/bootstrap-table-zh-CN",
		"menu" : "bootstrap/bootstrap-menu",
		"validator-language" : "bootstrap/language/zh_CN",
		"bootstrap-validator" : "bootstrap/bootstrap-validator",
		"css" : "require/css",
		"domReady" : "require/domReady",
		"text" : "require/text",
		"avalon" : "avalon/avalon",
		"mmRouter" : "avalon/mmRouter",
		"tree" : "lsheep/tree",
		"validator" : "lsheep/validator",
		"table" : "lsheep/table",
		"order" : "lsheep/order"
	},
	shim : {
		"avalon" : {
			exports : "avalon"
		},
		"tree" : {
			deps : [ "toastr" ],
			exports : "tree"
		},
		"bootstrap-validator" : {
			exports : "bootstrap-validator"
		},
		"validator-language" : {
			deps : [ "bootstrap-validator" ],
			exports : "validator-language"
		},
		"validator" : {
			deps : [ "bootstrap-validator", "validator-language" ],
			exports : "validator"
		},
		"bootstrap-table" : {
			exports : "bootstrap-table"
		},
		"table-language" : {
			deps : [ "bootstrap-table" ],
			exports : "table-language"
		},
		"table" : {
			deps : [ "bootstrap-table", "table-language" ],
			exports : "table"
		}
	},
});

require([ "domReady!" ], function(doc) {
	require([ "/index.js" ], function(index) {
		index.onload();
	})
});