<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>문제3 : 전 세계에서 가장 높은 산은?</h2>
<form action="quizProc3.jsp">
	<input type="hidden" name="quiz1" value='<%=request.getAttribute("quiz1")%>' />
	<input type="hidden" name="quiz2" value='<%=request.getAttribute("quiz2")%>' />
	정답 : <input type="text" name="quiz3" />&nbsp;
	<input type="submit" value="다음문제" />
</form>