$(function(){	
	// https://jsonplaceholder.typicode.com/todos
	// 테이블에 출력
	$("#btn").on("click", function() {
		$.ajax({
			method: "GET",
			url: "https://jsonplaceholder.typicode.com/todos"
		}).done(function(jsonArr, result) {
			const tbodyLen = $("tbody tr").length;
			if (result == "success" && tbodyLen == 0) {
				const jsonArrLen = jsonArr.length;
				for (let i = 0; i < jsonArrLen; i++) {
					const tr = $("<tr></tr>");		
					tr.append(`<td>${jsonArr[i].userId}</td>`);
					tr.append(`<td>${jsonArr[i].id}</td>`);
					tr.append(`<td>${jsonArr[i].title}</td>`);
					tr.append(`<td>${jsonArr[i].completed == true ? "완료" : "미완료"}</td>`);
					$("tbody").append(tr);
				}
			}
		});
	});
	
});