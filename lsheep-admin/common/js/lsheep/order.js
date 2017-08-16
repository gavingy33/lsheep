define([ "jquery" ], function($) {

	function create() {
		return [
			'<div id="moduleOpertion" class="order">',
			'<a class="property-order" order-type="top" data-toggle="tooltip" data-placement="top" title="置顶">'
			+ '<i class="fa fa-angle-double-up"></i></a>',
			'<a class="property-order" order-type="up" data-toggle="tooltip" data-placement="top" title="上移">'
			+ '<i class="fa fa-angle-up"></i></a>',
			'<a class="property-order" order-type="down" data-toggle="tooltip" data-placement="top" title="下移">'
			+ '<i class="fa fa-angle-down"></i></a>',
			'<a class="property-order" order-type="buttom" data-toggle="tooltip" data-placement="top" title="置底">'
			+ '<i class="fa fa-angle-double-down"></i></a>',
			'</div>'
		].join('');
	}

	function disable(orderConfig) {
		$(orderConfig.name + " #moduleOpertion").each(function(index) {
			var $this = $(this);
			$("a", $this).removeClass("disabled");
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
	}

	function initEvent(orderConfig) {
		disable(orderConfig);
		$("[data-toggle='tooltip']").tooltip();
		$(orderConfig.name + " #moduleOpertion a").mouseenter(function() {
			if (!$(this).hasClass("disabled")) {
				$("i", $(this)).addClass("fa-lg");
			}
		});

		$(orderConfig.name + " #moduleOpertion a").mouseleave(function() {
			$("i", $(this)).removeClass("fa-lg");
		});

		// 点击事件
		$(orderConfig.name + " #moduleOpertion a").click(function() {
			var $this = $(this);
			var length = $("tr", $this.parents("tbody")).length;
			var change = false;
			//置顶
			if ($this.attr("order-type") == "top") {
				var $tr = $this.parents("tr");
				if ($tr.index() != 0) {
					$tr.fadeOut().fadeIn();
					$(".table").prepend($tr);
					change = true;
				}
			}
			//上移
			if ($this.attr("order-type") == "up") {
				var $tr = $this.parents("tr");
				if ($tr.index() != 0) {
					$tr.fadeOut().fadeIn();
					$tr.prev().before($tr);
					change = true;
				}
			}
			//下移
			if ($this.attr("order-type") == "down") {
				var $tr = $this.parents("tr");
				if ($tr.index() != length - 1) {
					$tr.fadeOut().fadeIn();
					$tr.next().after($tr);
					change = true;
				}
			}
			//置底
			if ($this.attr("order-type") == "buttom") {
				var $tr = $this.parents("tr");
				if ($tr.index() != length - 1) {
					$tr.fadeOut().fadeIn();
					$(".table").append($tr);
					change = true;
				}
			}
			disable(orderConfig);
			if (change) {
				orderConfig.onOrderChange();
			}
		});
	}


	return {
		create : function() {
			return create();
		},
		init : function(orderConfig) {
			initEvent(orderConfig);
		}
	}
});