<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.board.Board"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="jspbasic.board.BoardDao"%>
<%@page import="jspbasic.board.BoardInterface"%>

<%
	String realPath = "D:/upload";
	
	// 새로 업로드
	MultipartRequest mr = new MultipartRequest(request, realPath, 5 * 1024 * 1024,
			"utf-8", new DefaultFileRenamePolicy());
	
	// 기존 파일 삭제
	File file = new File(realPath + "/" + mr.getParameter("cfn"));
	if (file.exists()) file.delete();
	
	Board board = new Board();
	board.setBid(Integer.parseInt(mr.getParameter("bid")));
	board.setBsort(mr.getParameter("bsort"));
	board.setBtitle(mr.getParameter("btitle"));
	board.setBcontent(mr.getParameter("bcontent"));
	board.setCfn(mr.getOriginalFileName("newcfn"));

	BoardInterface bi = new BoardDao();
	bi.updateBoard(board);
	response.sendRedirect("boardListProc.jsp");
%>