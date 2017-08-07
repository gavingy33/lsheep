define([ "jquery", "avalon" ], function($, avalon) {
	avalon.define({
		$id : "navigation",

		active : function() {
			$navigation.removeClass("active");
			$(this).addClass("active");
			$placeholder.empty();
		}
	});

});