<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>inner.jsp</h2>
<p>
	<%=request.getParameter("name")%><br />
	<%=request.getParameter("age")%><br />
	name 파라미터의 값 : ${param.name}<br />
	age 파라미터의 값 : ${param.age}
</p>