$(function(){	
	// https://jsonplaceholder.typicode.com/albums
	// 테이블에 출력
	$("#btn").on("click", function() {
		$.ajax({
			method: "GET",
			url: "https://jsonplaceholder.typicode.com/albums"
		}).done(function(jsonArr, result) {
			const trLen = $("tbody tr").length;
			if (result == "success" && trLen == 0) {
				const jsonArrLen = jsonArr.length;
				for (let i = 0; i < jsonArrLen; i++) {
					const tr = $("<tr></tr>");
					tr.append(`<td>${jsonArr[i].userId}</td>`);
					tr.append(`<td>${jsonArr[i].id}</td>`);
					tr.append(`<td>${jsonArr[i].title}</td>`);
					$("tbody").append(tr);
				}
			}
		});
	});
	
});