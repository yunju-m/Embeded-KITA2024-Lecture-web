<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setAttribute("quiz1", request.getParameter("quiz1"));
	request.setAttribute("quiz2", request.getParameter("quiz2"));
	request.setAttribute("quiz3", request.getParameter("quiz3"));
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("quiz4.jsp");
	dispatcher.forward(request, response);
%>