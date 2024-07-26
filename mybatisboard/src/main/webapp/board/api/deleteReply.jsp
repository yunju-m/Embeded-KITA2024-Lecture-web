<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="reply.Reply"%>
<%@page import="reply.ReplyInterface"%>
<%@page import="reply.ReplyDao"%>

<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	int rid = Integer.parseInt(request.getParameter("rid"));
	
	ReplyInterface ri = new ReplyDao();
	Reply reply = new Reply();
	reply.setBid(bid);
	reply.setRid(rid);
	ri.deleteReply(reply);
%>