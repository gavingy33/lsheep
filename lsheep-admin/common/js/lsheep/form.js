(function($) {

	var form = function() {};

	form.prototype.value = function(name, data) {
		var value = data;
		$(name.split(".")).each(function(i, name) {
			value = value[name];
		});
		return value;
	}

	form.prototype.writeForm = function($form, data) {
		// 填充<input:text>,<input:hidden>,<select>标签
		$("input[type='text'],input[type='hidden'],select", $form).each(function() {
			$(this).val(form.prototype.value($(this).attr("name"), data));
		});
		//填充<input:radio>标签
		$("input[type='radio']", $form).each(function() {
			var value = form.prototype.value($(this).attr("name"), data);
			var radioValue = $(this).attr("value");
			if (value === radioValue) {
				$(this).prop("checked", true);
			}
		});
		//填充<input:checkbox>标签
		$("input[type='checkbox']", $form).each(function() {
			var value = form.prototype.value($(this).attr("name"), data);
			if (!value) return;
			var checkboxValue = $(this).attr("value");
			if (value === checkboxValue || value.indexOf(checkboxValue) !== -1) {
				$(this).prop("checked", true);
			}
		});
	}

	$.fn.writeForm = function(data) {
		form.prototype.writeForm(this, data);
	}

})(jQuery);