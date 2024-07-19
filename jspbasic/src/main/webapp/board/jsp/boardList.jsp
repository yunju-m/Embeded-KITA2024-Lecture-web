<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/boardList.css" />
<body>
	<div class="container">
		<h2>게시판 목록</h2>
		<div class="text-right mb-4">
		<p>
			${sessionScope.mid}님 환영합니다!
			<input type="button" value="로그아웃" onclick="location.href='logoutProc.jsp';" />
		</p>
		<a href="boardRegistForm.jsp" class="btn btn-primary">상품 등록</a>
		</div>
		<div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일시</th>
                        <th scope="col">수정</th>
                        <th scope="col">삭제</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.bid}</td>
                        <td><a href="boardView.jsp?bid=${board.bid}">${board.btitle}</a></td>
                        <td>${board.bwriter}</td>
                        <td>${board.bcount}</td>
                        <td><fmt:formatDate value="${board.bregdate}" pattern="yy/MM/dd HH:mm" /></td>
                        <td>
                            <a href="boardUpdateForm.jsp?bid=${board.bid}" class="btn btn-sm btn-info">수정</a>
                        </td>
                        <td>
                            <a href="boardDeleteProc.jsp?bid=${board.bid}" class="btn btn-sm btn-danger">삭제</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
	</div>
</body>
</html>