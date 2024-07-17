<%@page import="jspbasic.product.ProductProc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int pno = Integer.parseInt(request.getParameter("pno"));
	int result = new ProductProc().deleteProduct(pno);
	if (result > 0) {
		System.out.print("정상적으로 삭제되었습니다.");
	} else {
		System.out.print("삭제를 실패했습니다.");
	}
	response.sendRedirect("productList.jsp");
%>