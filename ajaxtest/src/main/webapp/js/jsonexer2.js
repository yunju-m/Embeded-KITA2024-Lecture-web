window.onload = function() {
	
	// 2. 아래 URL에서 JSON데이터 받아서
	// https://jsonplaceholder.typicode.com/photos
	// jsonexer2.html에 테이블로 출력
	
	document.getElementById("btn").addEventListener(
		"click",
		function() {
			const xhr = new XMLHttpRequest();
			xhr.open("GET", "https://jsonplaceholder.typicode.com/photos", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					const photoJsonText = xhr.responseText;
					const photoJsonObj = JSON.parse(photoJsonText);
					const photoJsonObjLen = photoJsonObj.length;
					let trs = "";
					for (let i = 0; i < photoJsonObjLen; i++) {
						const photo = photoJsonObj[i];
						trs += `
						<tr>
							<td>${photo.albumId}</td>
							<td>${photo.id}</td>
							<td>${photo.title}</td>
							<td>${photo.url}</td>
							<td>${photo.thumbnailUrl}</td>
						</tr>`; 
					}
					document.getElementsByTagName("TBODY")[0].innerHTML = trs;
				}
			}		
		}
	);
}