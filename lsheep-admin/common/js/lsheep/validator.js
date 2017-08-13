define([ "bootstrap-validator", "toastr" ], function(validator, toastr) {

	var validate = function(validatorConfig) {
		var formId = validatorConfig.formId;
		// 表单验证默认配置
		$(formId).bootstrapValidator({
			//			live : "disabled",
			message : "This value is not valid",
			feedbackIcons : {
				valid : "glyphicon glyphicon-ok",
				invalid : "glyphicon glyphicon-remove",
				validating : "glyphicon glyphicon-refresh"
			},
			fields : validatorConfig.fields
		}).on("success.form.bv", function(e) {
			e.preventDefault();
			var $form = $(e.target);
			//异步提交表单
			$.ajax({
				type : "POST",
				url : $form.attr("action"),
				data : $(formId).serialize(),
				success : validatorConfig.onSuccess,
				error : validatorConfig.onError || function() {
						toastr.error("系统错误");
				}
			});
		});

	};

	return {
		validate : function(validatorConfig) {
			validate(validatorConfig);
		}
	}
});