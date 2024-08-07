package jspbasic.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardDao implements BoardInterface {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDao() {
		conn = ConnectionUtil.getConnection();
	}

	@Override
	public List<Board> listBoard(String bsort, String searchKeyword, String searchValue)
			throws SQLException {

		String sql = " SELECT * FROM BOARD ";

		if (bsort == null) bsort="";
		if (searchKeyword == null) searchKeyword="";
		if (searchValue == null) searchValue="";

		// 게시물 검색 기능
		if (searchKeyword.equals("btitle")) {
			sql += " WHERE BTITLE LIKE '%" + searchValue + "%' ";
		} else if (searchKeyword.equals("bcontent")) {
			sql += " WHERE BCONTENT LIKE '%" + searchValue + "%' ";
		} else if (searchKeyword.equals("")) {
			sql += " WHERE ( BTITLE LIKE '%" + searchValue + "%' ";
			sql += " OR BCONTENT LIKE '%" + searchValue + "%' ) ";
		}

		// 게시물 분류 기능
		if (!bsort.isEmpty()) {
			sql += " AND BSORT = '" + bsort + "'";
		}

		sql += " ORDER BY BID DESC ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Board> boardList = new ArrayList<Board>();
		if(rs != null) {
			while(rs.next()) {
				Board board = new Board(
						rs.getInt("BID"),
						rs.getString("BTITLE"),
						rs.getString("BCONTENT"),
						rs.getString("BWRITER"),
						rs.getInt("BCOUNT"),
						rs.getTimestamp("BREGDATE"),
						rs.getString("BSORT"),
						rs.getString("CFN")
						);
				boardList.add(board);
			}
			pstmt.close();
			return boardList;			
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public Board getBoard(int bid) throws SQLException {
		String sql = " SELECT * FROM BOARD WHERE BID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		Board board = null;
		if (rs.next()) {
			board = new Board(
					rs.getInt("BID"),
					rs.getString("BTITLE"),
					rs.getString("BCONTENT"),
					rs.getString("BWRITER"),
					rs.getInt("BCOUNT"),
					rs.getTimestamp("BREGDATE"),
					rs.getString("BSORT"),
					rs.getString("CFN")
					);
		}
		pstmt.close();
		return board;
	}

	@Override
	public int registBoard(Board board) throws SQLException {
		String sql = " INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, 0, SYSDATE, ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setString(4, board.getBsort());
		pstmt.setString(5, board.getCfn());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int updateBoard(Board board) throws SQLException {
		String sql = " UPDATE BOARD SET BSORT = ?, BTITLE = ?, BCONTENT = ?, CFN = ? WHERE BID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBsort());
		pstmt.setString(2, board.getBtitle());
		pstmt.setString(3, board.getBcontent());
		pstmt.setString(4, board.getCfn());
		pstmt.setInt(5,  board.getBid());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int deleteBoard(int bid) throws SQLException {
		String sql = " DELETE FROM BOARD WHERE BID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	@Override
	public int addCount(int bid) throws SQLException {
		String sql = " UPDATE BOARD SET BCOUNT = BCOUNT + 1 WHERE BID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

}
