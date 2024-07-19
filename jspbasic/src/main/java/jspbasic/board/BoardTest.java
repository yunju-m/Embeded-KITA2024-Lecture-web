package jspbasic.board;

import java.sql.SQLException;
import java.sql.Timestamp;

public class BoardTest {
	
	public static void main(String[] args) {

		BoardDao boardDao = new BoardDao();
		Board board = new Board(0, "제목1", "내용1", "작성자1", 0,
				new Timestamp(System.currentTimeMillis()), "자유게시판");
		int result;
		try {
			// 게시물 등록 테스트
			result = boardDao.registBoard(board);
			if (result > 0) {
				System.out.println("등록 성공!");
			} else {
				System.out.println("등록 실패!");
			}
			// 게시물 목록 출력 테스트
			System.out.println(boardDao.listBoard("제목", "내용"));
			
			// 게시물 수정 테스트
			Board board2 = new Board(1, "새로운 제목", "새로운 내용", "신인 작성자", 1,
					new Timestamp(System.currentTimeMillis()), "공지");
			result = boardDao.updateBoard(board2);
			if (result > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}
			
			// 게시물 삭제 테스트
			result = boardDao.deleteBoard(4);
			if (result > 0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패!");
			}
			
			// 게시물 조회수 증가 테스트
			result = boardDao.addCount(1);
			if (result > 0) {
				System.out.println("조회수 증가 성공!");
			} else {
				System.out.println("조회수 증가 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
