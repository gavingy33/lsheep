var login = function() {
	var commit = function() {
		var $_login = $("#login");
		$_login.click(function() {
			$_login.attr('disabled', 'disabled');
			console.log($("#loginForm").serialize());
			$.post("/sso-restful/sso/login", $("#loginForm").serialize(), function(restResponse) {
				var responseHeader = restResponse.header;
				if (200 != responseHeader.statusCode) {
					alert(responseHeader.message);
				}
			});
		});
	};

	return {
		init : function() {
			commit();
		}
	}

}();

$(function() {
	login.init();
});