define([ "jquery", "validator", "toastr", "tree", "form" ], function($, validator, toastr, tree, form) {

	var initFormData = function(treeNode) {
		$("#moduleAddForm #parentPath").val(treeNode.path);
		$("#moduleAddForm #parentId").val(treeNode.id);

		var pathPrefix = treeNode.path + " /";
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
				},
				weight : {
					validators : {
						digits : {
							message : "请输入非负整数"
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

	var writeValue = function(treeNode) {
		$.ajax({
			url : "/config-restful/property/node/" + treeNode.id,
			type : "GET",
			success : function(response) {
				var header = response.header;
				if (header.statusCode != 200) {
					toastr.error(header.message);
					return;
				}
				var node = response.body;
				$("#moduleAdd #moduleAddForm").writeForm(node);
			}
		});
	}

	return {
		onload : function(treeNode) {
			initFormData(treeNode);
			initFormValidate();
		},
		initValue : function(treeNode) {
			this.onload(treeNode);
			writeValue(treeNode);
		}
	}
});