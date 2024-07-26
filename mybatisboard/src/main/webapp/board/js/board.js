$(function() {
});

const getReplyList = function(bid) {
	$.get("/mybatisboard/board/api/replyList.jsp?bid=" + bid, function(jsonStr) {
		const replyArr = JSON.parse(jsonStr);
		
		for (reply of replyArr) {
			$("#replyList").append("<p>"+reply.rwriter+ " : " + reply.rcontent +"</p>");
		}
	});
}