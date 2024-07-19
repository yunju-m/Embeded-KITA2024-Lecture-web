<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.board.Board"%>
<%@page import="jspbasic.board.BoardDao"%>
<%@page import="jspbasic.board.BoardInterface"%>

<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	BoardInterface bi = new BoardDao();
	
	bi.addCount(bid); // 조회수 증가
	
	Board board = bi.getBoard(bid);
	pageContext.setAttribute("board", board);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물상세화면</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/boardForm.css">
<script src="../js/board.js"></script>
</head>
<body>
	<div class="regist-container">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">${board.bid}. ${board.btitle}</h2>
               	<div class="form-group">
                  <p class="card-writer">${board.bwriter}</p>
                </div>
                <div class="form-group">
                	<p class="card-text">${board.bsort}</p>
                    <p class="card-text">${board.bcontent}</p>         
                </div>
                <div class="form-group text-center">
                    <input type="button" value="목록" class="btn btn-primary" onclick="location.href='boardListProc.jsp';" />
                </div>
            </div>
        </div>
    </div>
</body>
</html>