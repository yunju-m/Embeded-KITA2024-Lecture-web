<%@page import="reply.Reply"%>
<%@page import="reply.ReplyDao"%>
<%@page import="reply.ReplyInterface"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ReplyInterface ri = new ReplyDao();
	String rwriter = request.getParameter("rwriter");
	String rcontent = request.getParameter("rcontent");
	int bid = Integer.parseInt(request.getParameter("bid"));
	
	Reply reply = new Reply(0, rwriter, rcontent, null, bid);
	ri.registReply(reply);
%>