$(function() {
	$("#calBtn").on("click", () => {
		const num1 = $("input[name='num1']").val();
		const num2 = $("input[name='num2']").val();
		const operator = $("input[name='operator']").val();
		const operators = ['+', '-', '*', '/'];
		
		if (!num1 || isNaN(num1)) {
			alert('첫 번째 숫자를 입력해주세요!');
			return false;
		} 
		if (!num2 || isNaN(num2)) {
			alert('두 번째 숫자를 입력해주세요!');
			return false;
		}
		if (!operator){
			alert('+, -, *, / 중 연산자를 입력해주세요!');
			return false;
		}
		if (!operators.includes(operator)) {
			alert('연산자는 +, -, *, / 중에서 입력해주세요!');
			return false;
		}
		if (operator === '/' && num2 == 0) {
			alert("0으로 나눌 수 없습니다.");
			return false;
		}
		$("form[name='calForm']").submit();			
	});
})