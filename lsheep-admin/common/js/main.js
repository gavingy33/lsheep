requirejs.config({
	baseUrl : "/common/js",
	paths : {
		"jquery" : "jquery/jquery",
		"toastr" : "toastr/toastr",
		"ztree" : "ztree/jquery.ztree.all",
		"bootstrap" : "bootstrap/bootstrap",
		"table" : "bootstrap/bootstrap-table",
		"menu" : "bootstrap/bootstrap-menu",
		"validator-language" : "bootstrap/language/zh_CN",
		"bootstrap-validator" : "bootstrap/bootstrap-validator",
		"css" : "require/css",
		"domReady" : "require/domReady",
		"text" : "require/text",
		"avalon" : "avalon/avalon",
		"mmRouter" : "avalon/mmRouter",
		"tree" : "lsheep/tree",
		"validator" : "lsheep/validator"
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
		}
	},
});

require([ "domReady!" ], function(doc) {
	require([ "/index.js" ], function(index) {
		index.onload();
	})
});