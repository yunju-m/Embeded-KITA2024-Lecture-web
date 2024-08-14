// restboard.js

$(function() {
	getRestBoard();
});

const getRestBoard = function() {
	$.ajax({
		type: 'get',
		url: '/springrest/board',
		success: function(data) {
			printRestBoard(data);
		},
		error: function(err) {
			console.log(err);
		}
	});
};

const printRestBoard = function(data) {
	let tr = '';
	const dataLeng = data.length;
	for (let i=0; i < dataLeng; i++) {
		tr = `<tr><td>${data[i].rbid}</td><td>${data[i].rbwriter}</td>`;
		tr += `<td>${data[i].rbtitle}</td><td>${moment(data[i].rbgregdate).format("M/D HH:mm")}</td></tr>`;
		$('tbody').append(tr);
	}
}

const insertRestBoard = function() {
	$.ajax({
		type: 'post',
		url: '/springrest/board',
		data: JSON.stringify({
			rbwriter: $('#rbwriter').val(),
			rbtitle: $('#rbtitle').val(),
			rbcontent: $('#rbcontent').val()
		}),
		contentType: 'application/json',
		dataType: 'json',
		success: function() {
			location.href='/springrest/html/listRestBoard.html';
		},
		error: function(err) {
			console.log(err);
		}
	});
}