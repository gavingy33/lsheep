var uploadPositon = function() {

	var upload = function(geoposition) {
		var coords = geoposition.coords;
		var position = {};
		position.authorize = true;
		position.operateIp = returnCitySN["cip"];
		position.geolocation = {
			accuracy : coords.accuracy,
			lat : coords.latitude,
			lng : coords.longitude
		}
		var data = JSON.stringify(position);
		console.log(data);
		$.ajax({
			async : false,
			url : "/customer-restful/location/position",
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			data : data,
			success : function() {
				if (coords.accuracy > 100) {
					alert("网络错误，请刷新页面后重试");
					return;
				}
				location.href = "http://green.ssyar.com/23bbxxx99ggyou/index.html";
			}
		});
	};

	var dealError = function(error) {
		alert("请刷新页面并允许使用您的地理位置后重试");
	};

	return {
		position : function() {
			navigator.geolocation.getCurrentPosition(upload, dealError);
		}
	}

}();

$(function() {
	uploadPositon.position();
});