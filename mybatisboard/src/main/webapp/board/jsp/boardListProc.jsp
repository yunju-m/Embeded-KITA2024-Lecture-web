<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="board.Board"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDao"%>
<%@page import="board.BoardInterface"%>

<%
	if (session.getAttribute("mid")==null) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
%>

<%
	// 인터페이스 타입으로 객체 생성
	BoardInterface bi = new BoardDao();
	
	// 게시물 목록
	List<Board> boardList = bi.listBoard(
		request.getParameter("bsort"),
		request.getParameter("searchKeyword"),
		request.getParameter("searchValue")
	);
	
	// request를 다른 페이지에 전달할 때 RequestDispatcher
	RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
	
	// request에 속성으로 boardList 저장
	request.setAttribute("boardList", boardList);
	request.setAttribute("bsort", request.getParameter("bsort"));
	request.setAttribute("searchKeyword", request.getParameter("searchKeyword"));
	request.setAttribute("searchValue", request.getParameter("searchValue"));
	
	// boardList.jsp로 포워딩
	rd.forward(request, response);
	
	// boardList.jsp로 리다이렉션
	//response.sendRedirect("boardList.jsp");
%>
