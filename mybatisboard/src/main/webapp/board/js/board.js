$(function() {
});

const getReplyList = function(bid) {
	$.get("/mybatisboard/board/api/replyList.jsp?bid=" + bid, function(jsonStr) {
		const replyArr = JSON.parse(jsonStr);
		$("#replyList").empty();
		for (reply of replyArr) {
			$("#replyList").append("<p>"+reply.rwriter+ " : " + reply.rcontent + " " + reply.rregdate + "</p>");
		}
	});
}

const registReply = function(rwriter, bid) {
	$.post("/mybatisboard/board/api/registReply.jsp",
	{
		"rwriter": rwriter,
		"rcontent": $("#rcontent").val(),
		"bid": bid
	}).done(function() {
		getReplyList(bid);	
		$("#rcontent").val('')
	});
}
