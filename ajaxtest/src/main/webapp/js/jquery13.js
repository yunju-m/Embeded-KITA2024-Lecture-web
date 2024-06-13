$(function(){	
	// https://jsonplaceholder.typicode.com/comments?postId=1
	// 게시물에 있는 정보를 테이블에 출력
	$("#btn").click(function() {
		$("tbody").empty();
		const postIdVal = $("#postId").val();
		$.ajax({
			method: "GET",
			url: `https://jsonplaceholder.typicode.com/comments?postId=${postIdVal}`	
		}).done(function(jsonArr, result) {
			if (result == "success") {
				const jsonArrLen = jsonArr.length;
				for (let i = 0; i < jsonArrLen; i++) {
					const tr1 = $("<tr></tr>");
					tr1.append(`<td>${jsonArr[i].postId}</td>`);
					tr1.append(`<td>${jsonArr[i].id}</td>`);
					tr1.append(`<td>${jsonArr[i].name}</td>`);
					tr1.append(`<td>${jsonArr[i].email}</td>`);
					
					const tr2 = $("<tr></tr>");
					tr2.append(`<td colspan='4'>${jsonArr[i].body}</td>`);
					$("tbody").append(tr1);
					$("tbody").append(tr2);
				}		
			}
		});
	});
});