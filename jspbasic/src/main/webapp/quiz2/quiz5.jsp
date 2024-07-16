<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>문제5 : 한국어를 만든 위인은?</h2>
<form action="quizProc5.jsp">
	<input type="hidden" name="quiz1" value='<%=request.getAttribute("quiz1")%>' />
	<input type="hidden" name="quiz2" value='<%=request.getAttribute("quiz2")%>' />
	<input type="hidden" name="quiz3" value='<%=request.getAttribute("quiz3")%>' />
	<input type="hidden" name="quiz4" value='<%=request.getAttribute("quiz4")%>' />
	정답 : <input type="text" name="quiz5" />&nbsp;
	<input type="submit" value="다음문제" />
</form>