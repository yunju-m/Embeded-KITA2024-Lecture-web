// 1. 아래의 URL posts데이터 100건을 읽어서 테이블에 출력 
//    (id, title, thumbnail, status, category, publishedAt, updatedAt)
// 2. 이미지는 이미지를 표현하고 게시일, 수정일은 24/04/02 13:35 형식으로 출력
// 3. HTML 상단에 INPUT과 BUTTON 만들어서 제목으로 검색하는 기능
// 4. HTML 상단에 SELECT 만들어서 카테고리별로 테이블에 출력하는 기능
// https://jsonplaceholder.org/posts

const categoryArr = [];	// 카테고리 목록 배열

$(function() {	
	$.ajax({
		method: "GET",
		url: "https://jsonplaceholder.org/posts"
	}).done(function(postsData, result){
		if (result == "success") {
			const postsDataLen = postsData.length;
			for (let i = 0; i < postsDataLen; i++) {
				getCategoryList(postsData[i]);
				printPosts(postsData[i]);
			}
			setCategoryList();
			
			$("#searchBtn").click(function() {
    			getSameTitlePosts(postsData);
    		});
    		
    		$("select").change(function(){
				getSameCategoryPosts($(this).val(), postsData);
			});
		}
	});	
});

// 검색어가 제목에 포함된 게시물 출력 함수
function getSameTitlePosts(postsData) {
	$("tbody").empty();
	const searchVal = $("#title").val();
	for (let i = 0; i < postsData.length; i++) {
		if (postsData[i].title.indexOf(searchVal) != -1) {
			printPosts(postsData[i]);
		}
	}
}

// 카테고리 목록 구하는 함수
function getCategoryList(postsData) {
	const postsCategoris = postsData.category;
	if (!categoryArr.includes(postsCategoris)) {
		categoryArr.push(postsCategoris);
	}
}

// 카테고리 목록 추가하는 함수
function setCategoryList() {
	const categoryArrLen = categoryArr.length;
	for (let i = 0; i < categoryArrLen; i++) {
		const option = `<option value=${categoryArr[i]}>${categoryArr[i]}</option>`;
		$("select").append(option);
	}
}

// 카테고리 동일한 게시물 출력 함수
function getSameCategoryPosts(target, postsData) {
	$("tbody").empty();
	for (let i = 0; i < postsData.length; i++) {
		if (postsData[i].category.includes(target)) {
			printPosts(postsData[i]);
		}
	}
}

// 게시물 출력 함수
function printPosts(postsData) {
	const tr = $("<tr></tr>");
	/*
	// 동적으로 이미지 생성
	const thumnailImg = $('<img>', {
		src: `${postsData[i].thumbnail}`,
		alt: '썸네일 이미지'
	});
	*/
	const publishedAt = moment(postsData.publishedAt, 'YY/MM/DD HH:mm').format('YY/MM/DD HH:mm');
	const updatedAt = moment(postsData.updatedAt, 'YY/MM/DD HH:mm').format('YY/MM/DD HH:mm');
	
	tr.append(`<td>${postsData.id}</td>`);			
	tr.append(`<td>${postsData.title}</td>`);
	tr.append(`<td><img src='${postsData.thumbnail}'></td>`);
	//tr.append(thumnailImg.appendTo("<td></td>"));		
	tr.append(`<td>${postsData.status}</td>`);			
	tr.append(`<td>${postsData.category}</td>`);			
	tr.append(`<td>${publishedAt}</td>`);			
	tr.append(`<td>${updatedAt}</td>`);
	$("tbody").append(tr);	
}
