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
<link rel="stylesheet" href="../css/boardLists.css">
<body>
	<div class="container">
		<h2>게시판 목록</h2>
		<p>현재 접속자 수 : ${applicationScope.userCount}명</p>
		<div class="text-right mb-4">
			<p>
				${sessionScope.mid}님 환영합니다!
				<input type="button" value="로그아웃" class="btn btn-dark" onclick="location.href='logoutProc.jsp';" />
			</p>
			<div class="search-container">
				<form method="get" action="boardListProc.jsp" class="searchForm">
					<select name="bsort">
						<option value="">--전체--</option>
						<option value="자유게시판" <c:if test="${bsort=='자유게시판'}">selected</c:if>>자유게시판</option>
						<option value="공지사항" <c:if test="${bsort=='공지사항'}">selected</c:if>>공지사항</option>
						<option value="사진" <c:if test="${bsort=='사진'}">selected</c:if>>사진</option>
					</select>
					<select name="searchKeyword">
						<option value="">--전체--</option>
						<option value="btitle" <c:if test="${searchKeyword=='btitle'}">selected</c:if>>제목</option>
						<option value="bcontent" <c:if test="${searchKeyword=='bcontent'}">selected</c:if>>내용</option>
					</select>
					<input type="text" name="searchValue" class="searchVal" />
					<input type="submit" value="검색" class="btn btn-dark" />
				</form>
				<a href="boardRegistForm.jsp" class="btn btn-outline-dark">게시물 등록</a>		
			</div>
		</div>
		<div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">분류</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일시</th>
                        <th scope="col">파일</th>
                        <th scope="col">수정</th>
                        <th scope="col">삭제</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.bid}</td>
                        <td>${board.bsort}</td>
                        <td><a href="boardView.jsp?bid=${board.bid}">${board.btitle}</a></td>
                        <td>${board.bwriter}</td>
                        <td>${board.bcount}</td>
                        <td><fmt:formatDate value="${board.bregdate}" pattern="yy/MM/dd HH:mm" /></td>
                        <td>
                        	<c:if test="${!empty board.cfn}">
                        	<a href="/jspbasic/filedownload?filename=${board.cfn}"><img class="fileImg" src="../img/file.png"></a>
                        	</c:if>
                       	</td>
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