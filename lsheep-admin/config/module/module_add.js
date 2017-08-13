define([ "jquery", "validator", "toastr", "tree" ], function($, validator, toastr, tree) {

	var initFormData = function(treeNode) {
		$("#moduleAddForm #parentPath").val(treeNode.path);
		$("#moduleAddForm #parentId").val(treeNode.id);

		var pathPrefix = treeNode.path + "/";
		$path = $("#moduleAddForm #path").val(pathPrefix);
		$("#moduleAddForm #code").bind("input", function() {
			$path.val(pathPrefix + this.value);
		});
	};

	var initFormValidate = function() {
		validator.validate({
			formId : "#moduleAddForm",
			fields : {
				code : {
					validators : {
						notEmpty : {
							message : "请输入栏目编码"
						}
					}
				},
				name : {
					validators : {
						notEmpty : {
							message : "请输入栏目名称"
						}
					}
				}
			},
			onSuccess : function(response) {
				var header = response.header;
				if (header.statusCode != 200) {
					toastr.error(header.message);
					return;
				}
				toastr.success("保存成功");
				$("#panelIndex").empty();
				var treeConfig = {
					treeName : "#modulePanel #configTree"
				};
				tree.refreshNode(treeConfig);
				tree.expandNode(treeConfig);
			}
		});
	};

	return {
		onload : function(treeNode) {
			initFormData(treeNode);
			initFormValidate();
		}
	}
});