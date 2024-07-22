<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.board.BoardInterface"%>
<%@page import="jspbasic.board.BoardDao"%>

<jsp:useBean id="board" class="jspbasic.board.Board" />
<jsp:setProperty name="board" property="*" />

<%
	BoardInterface bi = new BoardDao();
	bi.registBoard(board);
	response.sendRedirect("boardListProc.jsp");
%>