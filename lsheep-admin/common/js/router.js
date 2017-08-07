define([ "avalon", "mmRouter" ], function(avalon, mmRouter) {
	var vm = avalon.define({
		$id : "lsheep-admin",
		currPath : ""
	});

	avalon.router.add("/aaa", function() {
		vm.currPath = this.path;
	});

	avalon.router.error(function(a) {
		console.log("path error");
	});

	avalon.history.start();
	//启动扫描机制,让avalon接管页面
	avalon.scan(document.body);

});