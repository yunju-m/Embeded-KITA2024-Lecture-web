<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="jspbasic.board.Board"%>
<%@page import="jspbasic.board.BoardDao"%>
<%@page import="jspbasic.board.BoardInterface"%>

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