<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.product.ProductProc"%>
<%@page import="jspbasic.product.Product"%>
    
<%
	ProductProc productProc = new ProductProc();
	Product product = productProc.getProduct(Integer.parseInt(request.getParameter("pno")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정화면</title>
<link rel="stylesheet" href="../css/product.css">
<script src="../js/product.js"></script>
</head>
<body>
	<div id="wrapper">
		<h2>수정내역</h2>
		<form method="post" action="productUpdateProc.jsp">
			<input type="hidden" name="pno" value=<%=product.getPno()%> /> <br />
			회사명 : <input type="text" name="pcomp" value=<%=product.getPcomp()%> /><br />
			상품명 : <input type="text" name="pname" value=<%=product.getPname()%>/><br />
			색상 : <input type="color" name="pcolor" value=<%=product.getPcolor()%> /><br />
			수량 : <input type="text" name="pamt" value=<%=product.getPamt()%> /><br />
			가격 : <input type="text" name="pprice" value=<%=product.getPprice()%> /><br />
			제조일시 : <input type="date" name="pmdate" value=<%=product.getPmdate()%>/><br />
			<input type="submit" value="확인" />
		</form>
	</div>
</body>
</html>