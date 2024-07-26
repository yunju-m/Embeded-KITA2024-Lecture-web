$(function() {
});

let loginMid;

const getReplyList = function(bid, mid) {
	loginMid = mid;
	$.get("/mybatisboard/board/api/replyList.jsp?bid=" + bid, function(jsonStr) {
		const replyArr = JSON.parse(jsonStr);
		$("#replyList").empty();
		
		for (reply of replyArr) {
			let formattedDate = moment(reply.rregdate).format("HH:MM");
			let eachReply = 
				"<p>["
				+ formattedDate
				+ "] "
				+ reply.rwriter
				+ " : " 
				+ reply.rcontent;
			if (mid === reply.rwriter) {
				eachReply += "<a href='javascript:deleteReply(\""+ reply.rid + "\", \"" + bid + "\");'>[X]</a>";				
			}
			eachReply += "</p>";
			$("#replyList").append(eachReply);
		}
	});
};

const registReply = function(rwriter, bid) {
	$.post("/mybatisboard/board/api/registReply.jsp",
	{
		"rwriter": rwriter,
		"rcontent": $("#rcontent").val(),
		"bid": bid
	}).done(function() {
		getReplyList(bid, loginMid);	
		$("#rcontent").val('')
	});
}

const deleteReply = function(rid, bid) {
	$.post("/mybatisboard/board/api/deleteReply.jsp?rid="+rid, function() {
	}).done(function() {
		getReplyList(bid, loginMid);
	});
}