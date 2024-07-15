<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	int num1, num2;
	String operator = "";	
	
	num1 = request.getParameter("num1").equals("") ? 0 : Integer.parseInt(request.getParameter("num1"));
	num2 = request.getParameter("num2").equals("") ? 0 : Integer.parseInt(request.getParameter("num2"));
	operator = request.getParameter("operator");
	
	switch (operator) {
	case "+":
		out.print("두 수의 합은 " + (num1 + num2) + "입니다.");
		break;
	case "-":
		out.print("두 수의 차는 " + (num1 - num2) + "입니다.");
		break;
	case "*":
		out.print("두 수의 곱은 " + (num1 * num2) + "입니다.");
		break;
	case "/":
		int result = num2 != 0 ? num1 / num2 : 0;
		out.print("두 수의 몫은 " + result + "입니다.");
		break;
	default:
		out.print("올바른 연산자를 입력해주세요!");
	}
%>