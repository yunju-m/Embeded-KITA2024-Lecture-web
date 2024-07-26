<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="board.Board"%>
<%@page import="board.BoardInterface"%>
<%@page import="board.BoardDao"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	BoardInterface bi = new BoardDao();
	
	bi.addCount(bid); // 조회수 증가
	
	Board board = bi.getBoard(bid);
	pageContext.setAttribute("board", board);
	pageContext.setAttribute("lineChar", "\n");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물상세화면</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/boardForm.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment.min.js"></script>
<script src="../js/board.js"></script>
<script defer>
	getReplyList('${board.bid}', '${sessionScope.mid}');
</script>
</head>
<body>
	<div class="regist-container">
        <div class="card board-container">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">${board.bid}. ${board.btitle}</h2>
               	<div class="form-group">
                  <p class="card-writer">${board.bwriter}</p>
                </div>
                <div class="form-group">
                	<p class="card-text">${board.bsort}</p>
                    <p class="card-text">${fn:replace(board.bcontent, lineChar, "<br />")}</p>
                </div>
                <div class="form-group">
                  <c:if test="${!empty board.cfn}">
                  	첨부파일 : <a href="/mybatisboard/filedownload?filename=${board.cfn}">${board.cfn}</a>
                  </c:if>
                </div>
                <div class="form-group text-center">
                    <input type="button" value="목록" class="btn btn-primary" onclick="location.href='boardListProc.jsp';" />
                </div>
            </div>
        </div>
        <div class="card reply-container">
        	<h2 class="card-title">댓글창</h2>
		    <div id="replyList"></div>
	        <div class="input-reply-container">
			<div class="input-group mb-3">
		  		<span class="input-group-text">댓글</span>
		  		<input id="rcontent" type="text" class="form-control" placeholder="댓글을 입력해주세요!" aria-label="Reply">
	      		<input type="button" value="등록" class="btn btn-primary" onclick="registReply('${sessionScope.mid}', '${board.bid}');" />
			</div>
	    	</div>
        </div>
    </div>
</body>
</html>