window.onload = function() {
	
	document.getElementById("btn").addEventListener(
		"click",
		function() {
			const name = document.getElementById("name").value;
			const age = document.getElementById("age").value;
			const xhr = new XMLHttpRequest();
			xhr.open("POST", "http://localhost:8888/ajaxtest/person.jsp", true);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send(`name=${name}&age=${age}`);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					const jsonText = xhr.responseText;
					const jsonObj = JSON.parse(jsonText);
					document.getElementById("result").innerHTML 
						= `이름: ${jsonObj.name}, 나이: ${jsonObj.age}`;
				}
			}		
		}
	);
}