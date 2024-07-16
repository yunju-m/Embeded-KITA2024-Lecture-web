<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.Enumeration" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	String[] hobby = request.getParameterValues("hobby");
	out.print("이름: " + name + "<br />");
	out.print("취미: ");
	int hobbyLeng = hobby.length;
	for (int i = 0; i < hobbyLeng; i++) {
		out.print(hobby[i] + "&nbsp;");
	}
	
	out.print("<br />");
	Map<String, String[]> requestMap = request.getParameterMap();
	Set<String> keySet = requestMap.keySet();
	for (String key : keySet) {
		out.print(key + " = ");
		String[] values = requestMap.get(key);
		for (String value : values) {
			out.print(value + " ");
		}
		out.print("<br />");
	}
	
	Enumeration<String> en = request.getParameterNames();
	while (en.hasMoreElements()) {
		String ename = (String)en.nextElement();
		out.print(ename + "&nbsp;");
	}
%>