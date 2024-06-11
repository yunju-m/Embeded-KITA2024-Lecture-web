window.onload = function() {
	
	document.getElementById("btn").addEventListener(
		"click",
		function() {
			const xhr = new XMLHttpRequest();
			xhr.open("GET", "http://localhost:8888/ajaxtest/assets/hello.xml", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					const xmlObj = xhr.responseXML;
					const persons = xmlObj.getElementsByTagName("persons")[0];
					const personsLeng = persons.childNodes.length;
					let printStr = "";
					for (let i = 0; i < personsLeng; i++) {
						if (persons.childNodes[i].nodeType == 1) {
							const person = persons.childNodes[i];
							const name = person.getElementsByTagName("name")[0];
							const nameText = name.firstChild.nodeValue;
							const age = person.getElementsByTagName("age")[0];
							const ageText = age.firstChild.nodeValue;
							printStr += "이름: " + nameText + ", 나이: " + ageText + "<br />";
							document.getElementById("result").innerHTML = printStr;
							
						}
					}
				}
			}
		}
	);
}