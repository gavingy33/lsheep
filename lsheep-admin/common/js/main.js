requirejs.config({
	baseUrl : "/common/js",
	paths : {
		"jquery" : "jquery/jquery",
		"ztree" : "ztree/jquery.ztree.all",
		"bootstrap" : "bootstrap/bootstrap",
		"table" : "bootstrap/bootstrap-table",
		"menu" : "bootstrap/bootstrap-menu",
		"css" : "require/css",
		"domReady" : "require/domReady",
		"text" : "require/text",
		"avalon" : "avalon/avalon",
		"mmRouter" : "avalon/mmRouter",
		"tree" : "lsheep/tree"
	},
	shim : {
		"avalon" : {
			exports : "avalon"
		},
		"mmRouter" : {
			deps : [ "avalon" ],
			exports : "mmRouter"
		}
	}
});

require([ "domReady!" ], function(doc) {
	require([ "/index.js" ], function(index) {
		index.onload();
	})
});