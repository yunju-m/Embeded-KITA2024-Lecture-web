<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록화면</title>
<link rel="stylesheet" href="../css/product.css">
<script src="../js/product.js"></script>
</head>
<body>
	<div id="wrapper">
		<div class="product-container">
			<h2>상품 등록</h2>
			<form method="post" action="productRegistProc.jsp">
				회사명 : <input type="text" name="pcomp" /><br />
				상품명 : <input type="text" name="pname" /><br />
				색상 : <input type="color" name="pcolor" /><br />
				수량 : <input type="text" name="pamt" /><br />
				가격 : <input type="text" name="pprice" /><br />
				제조일시 : <input type="date" name="pmdate" /><br />
				<input type="submit" value="확인" />
			</form>
		</div>
	</div>
</body>
</html>