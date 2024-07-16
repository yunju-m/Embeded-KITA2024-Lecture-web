<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>문제2 : 사과의 씨앗은 사과나무에서 몇 년이 지나야 열리나요?</h2>
<form action="quizProc2.jsp">
	<input type="hidden" name="quiz1" value='<%=request.getAttribute("quiz1")%>' />
	정답 : <input type="text" name="quiz2" />&nbsp;
	<input type="submit" value="다음문제" />
</form>