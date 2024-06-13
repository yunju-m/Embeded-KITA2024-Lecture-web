// jQuery AJAX 실습
// users 데이터를 ajax로 비동기 호출하여
// 위도 경도만 콘솔에 출력
// https://jsonplaceholder.typicode.com/users

$(function() {	
	$.ajax({
		method: "GET",
		url: "https://jsonplaceholder.typicode.com/users"
	}).done(function(userdata, result) {
		if (result == "success") {
			const userdataLen = userdata.length;
			for (let i = 0; i < userdataLen; i++) {
				console.log(`위도: ${userdata[i].address.geo.lat}, 경도: ${userdata[i].address.geo.lng}`);
			}
		}
	});
});