// 1. 아래의 URL posts데이터 100건을 읽어서 테이블에 출력 
//    (id, title, thumbnail, status, category, publishedAt, updatedAt)
// 2. 이미지는 이미지를 표현하고 게시일, 수정일은 24/04/02 13:35 형식으로 출력
// 3. HTML 상단에 INPUT과 BUTTON 만들어서 제목으로 검색하는 기능
// 4. HTML 상단에 SELECT 만들어서 카테고리별로 테이블에 출력하는 기능
// https://jsonplaceholder.org/posts

/*
 * 1. 처음에 한 번만 데이터 로딩해서 배열에 저장
 * 2. 기능들을 메소드로 분리
 * 	1) 데이터 로딩해서 배열에 저장하는 기능
 * 	2) 게시일/수정일 출력형식을 변경하는 기능
 * 	3) 검색 기능
 * 	4) 카테고리 추출 기능
 * 	5) 카테고리별 출력 기능
 */

let datas = [];			// 전체 포스트 저장할 배열
const categories = [];	// 카테고리 저장할 배열
let categoriesIdx = 0;	// 카테고리 인덱스
 
$(function() {
	// 처음 로딩되면 포스트 AJAX로 가져와서 출력
	getPosts();
	
	// 검색 이벤트 핸들러
	$("#searchBtn").click(function() {
		printSearchPosts();
	});
	
	// 카테고리 변경 이벤트 핸들러
	$("select").change(function() {
		printCategoryPosts();
	});
}); 

// AJAX 호출해서 결과를 배열로 리턴하는 함수
function getPosts() {
	$.ajax({
		method: "GET",
		url: "https://jsonplaceholder.org/posts"
	}).done(function(arr, result) {
		if (result == "success") {
			datas = arr;
			printPosts(arr);
		}
	});
}

// 배열을 전달받으면 테이블에 출력하는 함수
function printPosts(posts) {
	$("tbody").empty();
	const postsLen = posts.length;
	for (let i = 0; i < postsLen; i++) {
		
		setCategory(posts[i]);
		
		const tr = $("<tr></tr>");
		tr.append(`<td>${posts[i].id}</td>`);
		tr.append(`<td>${posts[i].title}</td>`);
		tr.append(`<td>${posts[i].title}</td>`);
		tr.append(`<td><img src='${posts[i].thumbnail}'></td>`);
		tr.append(`<td>${posts[i].category}</td>`);
		tr.append(`<td>${getDateStr(posts[i].publishedAt)}</td>`);
		tr.append(`<td>${getDateStr(posts[i].updatedAt)}</td>`);
		$("tbody").append(tr);
	}
	initCategory();
}

// 게시일/수정일 출력형식을 변경하는 기능
function getDateStr(str) {
	return moment(str, "YY/MM/DD HH:mm").format("YY/MM/DD HH:mm");
}

// 검색어에 해당하는 포스트들을 테이블에 출력하는 기능
function printSearchPosts() {
	const titleVal = $("#title").val();
	const datasLen = datas.length;
	const newDatas = [];
	let newDatasIdx = 0;
	for (let i = 0; i < datasLen; i++) {
		if (datas[i].title.includes(titleVal)) {
			newDatas[newDatasIdx++] = datas[i];
		}
	}
	printPosts(newDatas);
}

// 카테고리 설정하는 함수
function setCategory(post) {
	if (!categories.includes(post.category)) {
		categories[categoriesIdx++] = post.category;
	}
}

// 카테고리 초기화하는 함수
function initCategory() {
	$("select").empty();
	$("select").append(`<option value="">전체</option>`);
	const categoriesLen = categories.length;
	for (let i = 0; i < categoriesLen; i++) {
		const option = `<option value="${categories[i]}">${categories[i]}</option>`;
		$("select").append(option);
	}
}

// 카테고리에 해당하는 포스트들을 테이블에 출력하는 기능 
function printCategoryPosts() {
	const selectVal = $("select").val();
	const datasLen = datas.length;
	const newDatas = [];
	let newDatasIdx = 0;
	for (let i = 0; i < datasLen; i++) {
		if (datas[i].category == selectVal) {
			newDatas[newDatasIdx++] = datas[i];
		}
	}
	printPosts(newDatas);
}

