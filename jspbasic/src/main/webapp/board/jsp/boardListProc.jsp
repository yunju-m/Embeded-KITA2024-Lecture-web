<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.board.Board"%>
<%@page import="java.util.List"%>
<%@page import="jspbasic.board.BoardInterface"%>
<%@page import="jspbasic.board.BoardDao"%>

<%
	// 인터페이스 타입으로 객체 생성
	BoardInterface bi = new BoardDao();
	
	// 게시물 목록
	List<Board> boardList = bi.listBoard();
	
	// request를 다른 페이지에 전달할 때 RequestDispatcher
	RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
	
	// request에 속성으로 boardList 저장
	request.setAttribute("boardList", boardList);
	
	// boardList.jsp로 포워딩
	rd.forward(request, response);
	
	// boardList.jsp로 리다이렉션
	//response.sendRedirect("boardList.jsp");
%>
