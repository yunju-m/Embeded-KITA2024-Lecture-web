<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판등록화면</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/boardForm.css">
<script src="../js/board.js"></script>
</head>
<body>
	<div class="regist-container">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">게시판 등록</h2>
                <form method="post" action="boardRegistProc.jsp">
                    <div class="form-group">
                        <label>제목</label>
                        <input type="text" name="btitle" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label>내용</label>
                        <textarea name="bcontent" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label>작성자</label>
                        <input type="text" name="bwriter" class="form-control" required />
                    </div>
                    <div class="form-group text-center">
                        <a href="boardListProc.jsp" type="button" class="btn btn-danger">취소</a>
                        <input type="submit" value="확인" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>