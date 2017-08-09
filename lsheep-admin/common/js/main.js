requirejs.config({
	baseUrl : "/common/js",
	paths : {
		"jquery" : "jquery/jquery",
		"ztree" : "ztree/jquery.ztree.all",
		"bootstrap" : "bootstrap/bootstrap",
		"bootstrap-table" : "bootstrap/bootstrap-table",
		"css" : "require/css",
		"domReady" : "require/domReady",
		"text" : "require/text",
		"avalon" : "avalon/avalon",
		"mmRouter" : "avalon/mmRouter"
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