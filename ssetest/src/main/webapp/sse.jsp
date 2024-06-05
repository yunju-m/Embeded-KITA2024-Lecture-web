<%@page import="java.util.Date"%>
<%
	response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type", "text/event-stream");
	response.setHeader("Cache-Control", "no-cache");
	out.print("retry: 1000\n\n");
	out.print("data: {" + new Date(System.currentTimeMillis()) +"}\n\n");
%>