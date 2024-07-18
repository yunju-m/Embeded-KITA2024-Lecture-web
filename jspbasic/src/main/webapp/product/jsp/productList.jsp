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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/productList.css" />
</head>
<body>
	<div class="container">
        <h2 class="my-4 text-center">상품리스트</h2>
        <div class="text-right mb-4">
            <a href="productRegistForm.jsp" class="btn btn-primary">상품 등록</a>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">품번</th>
                        <th scope="col">제조사</th>
                        <th scope="col">상품명</th>
                        <th scope="col">색상</th>
                        <th scope="col">수량</th>
                        <th scope="col">가격</th>
                        <th scope="col">제조일시</th>
                        <th scope="col">수정</th>
                        <th scope="col">삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Product product : productList) { %>
                    <tr>
                        <td><%= product.getPno() %></td>
                        <td><%= product.getPcomp() %></td>
                        <td><%= product.getPname() %></td>
                        <td><%= product.getPcolor() %></td>
                        <td><%= product.getPamt() %></td>
                        <td><%= product.getPprice() %></td>
                        <td><%= product.getPmdate() %></td>
                        <td>
                            <a href="productUpdateForm.jsp?pno=<%= product.getPno() %>" class="btn btn-sm btn-info">수정</a>
                        </td>
                        <td>
                            <a href="productDeleteProc.jsp?pno=<%= product.getPno() %>" class="btn btn-sm btn-danger">삭제</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>