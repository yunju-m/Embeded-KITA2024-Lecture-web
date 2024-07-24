<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="mybatisboard.board.BoardInterface"%>
<%@page import="mybatisboard.board.BoardDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>

<%
	String realPath = "D:/upload";
	
	File dir = new File(realPath);
	if (!dir.exists()) dir.mkdirs();
	
	MultipartRequest mr = new MultipartRequest(request, realPath, 5 * 1024 * 1024,
			"utf-8", new DefaultFileRenamePolicy());
	pageContext.setAttribute("mr", mr);
%>

<jsp:useBean id="board" class="mybatisboard.board.Board" />
<jsp:setProperty name="board" property="btitle" value='<%=mr.getParameter("btitle")%>' />
<jsp:setProperty name="board" property="bcontent" value='<%=mr.getParameter("bcontent")%>' />
<jsp:setProperty name="board" property="bwriter" value='<%=mr.getParameter("bwriter")%>' />
<jsp:setProperty name="board" property="bsort" value='<%=mr.getParameter("bsort")%>' />
<jsp:setProperty name="board" property="cfn" value='<%=mr.getOriginalFileName("cfn")%>' />

<%
	BoardInterface bi = new BoardDao();
	bi.registBoard(board);
	response.sendRedirect("boardListProc.jsp");
%>