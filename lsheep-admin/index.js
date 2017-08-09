define([ "jquery" ], function($) {

	var initNavigationEvent = function() {
		var $navigation = $("#navigation ul li");
		var $placeholder = $("#panel #placeholder");
		$navigation.click(function() {
			$navigation.removeClass("active");
			$(this).addClass("active");
			$placeholder.empty();
		});

		$("#navigation #config").click(function() {
			$placeholder.load("/config/module/module.html", function() {
				requirejs([ "/config/module/module.js" ], function(module) {
					module.onload();
				});
			});
		});
	};

	return {
		onload : function() {
			initNavigationEvent();
		}
	}

});