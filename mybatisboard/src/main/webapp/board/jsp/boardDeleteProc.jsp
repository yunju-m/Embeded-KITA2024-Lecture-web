<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="board.Board"%>
<%@page import="board.BoardInterface"%>
<%@page import="board.BoardDao"%>
<%@page import="java.io.File"%>

<%
	String realPath = "D:/upload";

	// 기존 파일 삭제
	BoardInterface bi = new BoardDao();
	int bid = Integer.parseInt(request.getParameter("bid"));
	Board board = bi.getBoard(bid);	
	File file = new File(realPath + "/" + board.getCfn());
	if (file.exists()) file.delete();
	
	bi.deleteBoard(bid);
	response.sendRedirect("boardListProc.jsp");
%>