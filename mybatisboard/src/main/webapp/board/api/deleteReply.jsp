<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="reply.ReplyInterface"%>
<%@page import="reply.ReplyDao"%>

<%
	ReplyInterface ri = new ReplyDao();
	int rid = Integer.parseInt(request.getParameter("rid"));
	ri.deleteReply(rid);
%>