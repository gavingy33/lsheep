define([ "jquery", "toastr", "table" ], function($, toastr, table) {

	var createTable = function(treeNode) {
		table.create({
			tabelName : "#moduleOrder #moduleTable",
			url : "/config-restful/property/node",
			queryParams : {
				parentId : treeNode.id,
				withModule : true,
				withProperty : false
			},
			columns : [ {
				field : "propertyId",
				title : "栏目ID"
			}, {
				field : "code",
				title : "栏目编码",
				align : "left"
			}, {
				field : "name",
				title : "栏目名称"
			}, {
				field : "path",
				title : "栏目路径",
				align : "left"
			}, {
				title : "排序",
				formatter : function(value, row, index) {
					return [
						'<div id="moduleOpertion" class="order">',
						'<a class="property-order" order-type="top" title="置顶"><i class="fa fa-angle-double-up fa-lg"></i></a>',
						'<a class="property-order" order-type="up" title="上移"><i class="fa fa-angle-up fa-lg"></i></a>',
						'<a class="property-order" order-type="down" title="下移"><i class="fa fa-angle-down fa-lg"></i></a>',
						'<a class="property-order" order-type="buttom" title="置底"><i class="fa fa-angle-double-down fa-lg"></i></a>',
						'</div>'
					].join('');
				}
			} ],
			onLoadSuccess : function(data) {
				// 失效部分操作
				$("#moduleOrder #moduleOpertion").each(function(index) {
					var $this = $(this);
					var length = $("tr", $this.parents("tbody")).length;
					if (index === 0) {
						$this.find(".property-order[order-type='top']").addClass("disabled");
						$this.find(".property-order[order-type='up']").addClass("disabled");
					}
					if (index === length - 1) {
						$this.find(".property-order[order-type='down']").addClass("disabled");
						$this.find(".property-order[order-type='buttom']").addClass("disabled");
					}
				});

				// 点击事件
				$("#moduleOrder #moduleOpertion a").click(function() {
					var $this = $(this);
					var length = $("tr", $this.parents("tbody")).length;
					//置顶
					if ($this.attr("order-type") == "top") {
						var $tr = $this.parents("tr");
						if ($tr.index() != 0) {
							$tr.fadeOut().fadeIn();
							$(".table").prepend($tr);
						}
					}
					//上移
					if ($this.attr("order-type") == "up") {
						var $tr = $this.parents("tr");
						if ($tr.index() != 0) {
							$tr.fadeOut().fadeIn();
							$tr.prev().before($tr);
						}
					}
					//下移
					if ($this.attr("order-type") == "down") {
						var $tr = $this.parents("tr");
						if ($tr.index() != length - 1) {
							$tr.fadeOut().fadeIn();
							$tr.next().after($tr);
						}
					}
					//置底
					if ($this.attr("order-type") == "buttom") {
						var $tr = $this.parents("tr");
						if ($tr.index() != length - 1) {
							$tr.fadeOut().fadeIn();
							$(".table").append($tr);
						}
					}
				});
			}
		});
	};

	return {
		onload : function(treeNode) {
			createTable(treeNode);
		}
	}
});