<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setAttribute("quiz1", request.getParameter("quiz1"));
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("quiz2.jsp");
	dispatcher.forward(request, response);
%>