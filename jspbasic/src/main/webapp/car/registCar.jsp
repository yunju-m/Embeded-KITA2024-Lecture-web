<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="car" class="jspbasic.Car" />
<jsp:setProperty name="car" property="*" />

<jsp:forward page="registCarProc.jsp">
	<jsp:param name="company" value="${car.company}" />
	<jsp:param name="model" value="${car.model}" />
	<jsp:param name="cc" value="${car.cc}" />
	<jsp:param name="color" value="${car.color}" />
	<jsp:param name="price" value="${car.price}" />
</jsp:forward>

<p>연번: ${car.cno}</p>
<p>제조사: ${car.company}</p>
<p>모델명: ${car.model}</p>
<p>배기량: ${car.cc}</p>
<p>색상: ${car.color}</p>
<p>가격: ${car.price}</p>