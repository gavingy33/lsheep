define([ "avalon", "mmRouter", "/index.js" ], function(avalon, mmRouter, index) {

	avalon.router.add("/config", function() {});

	avalon.router.error(function(a) {
		console.log("path error");
	});

	avalon.history.start();
	//启动扫描机制,让avalon接管页面
	avalon.scan(document.body);
});