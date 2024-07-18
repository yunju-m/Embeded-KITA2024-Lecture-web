<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="jspbasic.product.ProductProc"%>

<%
	List<Product> productList = new ProductProc().listProduct();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>productList</title>
</head>
<body>
	<h2>상품리스트</h2>
	<button onclick="location.href='productRegistForm.jsp';">등록</button>
	<table>
		<thead>
			<tr>
				<th>품번</th>
				<th>제조사</th>
				<th>상품명</th>
				<th>색상</th>
				<th>수량</th>
				<th>가격</th>
				<th>제조일시</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<tr>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<%
				for(Product product : productList) {
			%>
			<tr>
				<td><%out.print(product.getPno());%></td>
				<td><%=product.getPcomp()%></td>
				<td><%=product.getPname()%></td>
				<td><%=product.getPcolor()%></td>
				<td><%=product.getPamt()%></td>
				<td><%=product.getPprice()%></td>
				<td><%=product.getPmdate()%></td>
				<td>
					<a href="productUpdateForm.jsp?pno=<%=product.getPno()%>">[수정]</a>
				</td>
				<td>
					<a href="productDeleteProc.jsp?pno=<%=product.getPno()%>">[삭제]</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>