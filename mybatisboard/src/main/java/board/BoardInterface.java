package board;

import java.sql.SQLException;
import java.util.List;

public interface BoardInterface {
	
	public abstract List<Board> listBoard(String bsort, String searchKeyword, String searchValue) throws SQLException; // 게시물 목록
	
	public abstract Board getBoard(int bid) throws SQLException; // 게시물 한개 조회
	
	public abstract int registBoard(Board board) throws SQLException; // 게시물 등록
	
	public abstract int updateBoard(Board board) throws SQLException; // 게시물 수정
	
	public abstract int deleteBoard(int bid) throws SQLException; // 게시물 삭제
	
	public abstract int addCount(int bid) throws SQLException; // 조회수 증가
	
}
