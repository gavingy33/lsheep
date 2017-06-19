var uploadPositon = function() {

	var successCallback = function(geoposition) {
		upload(geoposition, true);
	};

	var errorCallback = function(geoposition) {
		upload(geoposition, false);
	};

	var upload = function(geoposition, authorize) {
		var position = {};
		position.authorize = authorize;
		position.operateIp = returnCitySN["cip"];
		position.geolocation = geoposition;
		$.ajax({
			url : "/customer-restful/location/position",
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(position)
		});
	};

	return {
		position : function() {
			var geolocation = new qq.maps.Geolocation();
			geolocation.getLocation(successCallback, errorCallback, {
				timeout : 60,
				failTipFlag : true
			});
		}
	}

}();

$(function() {
	uploadPositon.position();
});