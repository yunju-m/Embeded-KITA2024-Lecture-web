window.onload = function() {
	
	// 1. 아래 URL에서 JSON데이터 받아서
	// 사용자아이디:1, 할일아이디:1, 할일제목:~~~,완료여부:완료
	// 형식으로 전체 데이터를 출력하는 프로그램
	// https://jsonplaceholder.typicode.com/todos
	
	document.getElementById("btn").addEventListener(
		"click",
		function() {
			const xhr = new XMLHttpRequest();
			xhr.open("GET", "https://jsonplaceholder.typicode.com/todos", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					const todoJsonText = xhr.responseText;
					const todoJsonObj = JSON.parse(todoJsonText);
					const todoJsonObjLen = todoJsonObj.length;
					let printStr = "";
					for (let i = 0; i < todoJsonObjLen; i++) {
						const todo = todoJsonObj[i];
						printStr += `
						<tr>
							<td>${todo.userId}</td>
							<td>${todo.id}</td>
							<td>${todo.title}</td>
							<td>${todo.completed==true ? '완료':'미완료'}</td>
						</tr>`; 
					}
					document.getElementsByTagName("TBODY")[0].innerHTML = printStr;
				}
			}		
		}
	);
}