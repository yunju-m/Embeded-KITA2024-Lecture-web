<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>문제4 : 인체에서 가장 큰 기관은?</h2>
<form action="quizProc4.jsp">
	<input type="hidden" name="quiz1" value='<%=request.getAttribute("quiz1")%>' />
	<input type="hidden" name="quiz2" value='<%=request.getAttribute("quiz2")%>' />
	<input type="hidden" name="quiz3" value='<%=request.getAttribute("quiz3")%>' />
	정답 : <input type="text" name="quiz4" />&nbsp;
	<input type="submit" value="다음문제" />
</form>