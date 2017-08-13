define([ "jquery", "validator", "toastr", "tree" ], function($, validator, toastr, tree) {

	var initFormData = function(treeNode) {
		$("#moduleAddForm #parentPath").val(treeNode.path);
		$("#moduleAddForm #parentId").val(treeNode.id);

		$path = $("#moduleAddForm #path").val(treeNode.path);
		$("#moduleAddForm #code").bind("input", function() {
			$path.val(treeNode.path + "/" + this.value);
		});
	};

	var initFormValidate = function() {
		validator.validate({
			formId : "#moduleAddForm",
			fields : {
				code : {
					validators : {
						notEmpty : {
							message : "请输入属性编码"
						}
					}
				},
				name : {
					validators : {
						notEmpty : {
							message : "请输入属性名称"
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
				var zTree = $.fn.zTree.getZTreeObj("configTree");
				var nodes = zTree.getSelectedNodes();
				zTree.reAsyncChildNodes(nodes[0], "refresh", false);
				zTree.expandNode(nodes[0], true, false, true, true);
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