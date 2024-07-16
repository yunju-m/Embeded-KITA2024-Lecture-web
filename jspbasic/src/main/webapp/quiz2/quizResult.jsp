<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int score = 0;
	String[] quizAnswers = {"", "", "", "", ""};
	String[] correctAnswers = {"목성", "5", "에베레스트", "피부", "세종대왕"};
	for (int i = 0; i < 5; i++) {
		if (correctAnswers[i].equals(application.getAttribute("quiz" + (i+1)))) score += 1;
		else {
			out.print("<h4 style=\"color:red;\">"+ (i+1) + "번 정답: " + correctAnswers[i] +"</h4>");
		}
	}
	
	out.print("<h2>" + score + "/5 문제 정답~~!</h2>");
	out.print("<button onclick=\"location.href='quiz1.jsp;'\">다시하기</button>");
%>