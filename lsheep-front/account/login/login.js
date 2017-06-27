var login = function() {

	var initValidation = function() {
		$("#loginForm").bootstrapValidator({
			message : "This value is not valid",
			live : "enabled",
			feedbackIcons : {
				valid : "glyphicon glyphicon-ok",
				invalid : "glyphicon glyphicon-remove",
				validating : "glyphicon glyphicon-refresh"
			},
			fields : {
				"username" : {
					validators : {
						notEmpty : {
							message : "请输入登录名"
						}
					}
				},
				"password" : {
					validators : {
						notEmpty : {
							message : "请输入密码"
						}
					}
				}
			}
		});
	};

	var submitEvent = function() {
		var $_submit = $("#loginButton");
		$_submit.attr("disabled", "disabled");
		$_submit.click(function() {
			$.post("/sso-restful/sso/login", $("#loginForm").serialize(), function(response) {
				var header = response.header;
				if (200 != header.statusCode) {
					alert(header.message);
				}
			});
		});
	};

	return {
		onload : function() {
			initValidation();
			submitEvent();
		}
	}

}();

$(function() {
	login.onload();
});