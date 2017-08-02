var ConfigIndex = function() {

	var initNavigationEvent = function() {
		var $_navigation = $("#navigation ul li");
		var $_placeholder = $("#panel #placeholder");
		$_navigation.click(function() {
			$_navigation.removeClass("active");
			$(this).addClass("active");
			$_placeholder.empty();
		});

		$("#navigation #config").click(function() {
			$_placeholder.load("/config/module/module.html", function() {
				
			});
		});
	};


	return {
		onload : function() {
			initNavigationEvent();
		}
	}
}();

$(function() {
	ConfigIndex.onload();
});