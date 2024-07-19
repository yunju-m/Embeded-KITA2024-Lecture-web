<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.board.Board"%>
<%@page import="jspbasic.board.BoardDao"%>
<%@page import="jspbasic.board.BoardInterface"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	BoardInterface bi = new BoardDao();
	Board board = bi.getBoard(Integer.parseInt(request.getParameter("bid")));
	pageContext.setAttribute("board", board);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판수정화면</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/boardForm.css">
<script src="../js/board.js"></script>
</head>
<body>
	<div class="regist-container">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">게시판 수정</h2>
                <form method="post" action="boardUpdateProc.jsp">
                	<input type="hidden" name="bid" value="${board.bid}" />
                	<div class="form-group">
                        <label>분류</label>
                        <select name="bsort">
                        	<option value="자유게시판" <c:if test="${board.bsort=='자유게시판'}">selected</c:if>>자유게시판</option>
                        	<option value="공지사항" <c:if test="${board.bsort=='공지사항'}">selected</c:if>>공지사항</option>
                        	<option value="사진" <c:if test="${board.bsort=='사진'}">selected</c:if>>사진</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>제목</label>
                        <input type="text" name="btitle" class="form-control" value="${board.btitle}" required />
                    </div>
                    <div class="form-group">
                        <label>내용</label>
                        <textarea name="bcontent" class="form-control">${board.bcontent}</textarea>
                    </div>
                    <div class="form-group text-center">
                        <a href="boardListProc.jsp" type="button" class="btn btn-danger">취소</a>
                        <input type="submit" value="수정" class="btn btn-info">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>