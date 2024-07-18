<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록화면</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/productForm.css">
<script src="../js/product.js"></script>
</head>
<body>
	<div class="regist-container">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">상품 등록</h2>
                <form method="post" action="productRegistProc.jsp">
                    <div class="form-group">
                        <label>회사명</label>
                        <input type="text" name="pcomp" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>상품명</label>
                        <input type="text" name="pname" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>색상</label>
                        <input type="color" name="pcolor" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>수량</label>
                        <input type="text" name="pamt" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>가격</label>
                        <input type="text" name="pprice" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>제조일시</label>
                        <input type="date" name="pmdate" class="form-control" required>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" value="확인" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>