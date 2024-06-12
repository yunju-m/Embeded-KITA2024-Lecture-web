// score.jsp 파일에 3명의 성적데이터(이름, 국어, 영어, 수학)를 보내서
// 이름, 국어, 영어, 수학, 총점 JSON을 응답으로 보내
// 테이블에 출력
window.onload = function() {
	
	document.getElementById("btn").addEventListener(
		"click",
		function() {
			const s1name = document.getElementById("s1name").value;
			const s1kor = document.getElementById("s1kor").value;
			const s1eng = document.getElementById("s1eng").value;
			const s1math = document.getElementById("s1math").value;
			const s2name = document.getElementById("s2name").value;
			const s2kor = document.getElementById("s2kor").value;
			const s2eng = document.getElementById("s2eng").value;
			const s2math = document.getElementById("s2math").value;
			const s3name = document.getElementById("s3name").value;
			const s3kor = document.getElementById("s3kor").value;
			const s3eng = document.getElementById("s3eng").value;
			const s3math = document.getElementById("s3math").value;
			
			const xhr = new XMLHttpRequest();
			xhr.open("POST", "http://localhost:8888/ajaxtest/score.jsp", true);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send(`s1name=${s1name}&s1kor=${s1kor}&s1eng=${s1eng}&s1math=${s1math}&s2name=${s2name}&s2kor=${s2kor}&s2eng=${s2eng}&s2math=${s2math}&s3name=${s3name}&s3kor=${s3kor}&s3eng=${s3eng}&s3math=${s3math}`);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					const studentjsonText = xhr.responseText;
					const studentjsonObj = JSON.parse(studentjsonText);
					const studentjsonObjLen = studentjsonObj.length;
					let trs = "";
					for (let i = 0; i < studentjsonObjLen; i++){
						const student = studentjsonObj[i];
						const total = Number(student.kor) + Number(student.eng) + Number(student.math);
						trs += `
						<tr>
							<td>${student.name}</td>
							<td>${student.kor}</td>
							<td>${student.eng}</td>
							<td>${student.math}</td>
							<td>${total}</td>
						</tr>`;
					}
					document.getElementsByTagName("TBODY")[0].innerHTML = trs;
				}
			}		
		}
	);
}