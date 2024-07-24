package mybatisboard.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements BoardInterface {

	String resource = "conf/configuration.xml";
	Reader reader;
	SqlSession session = null;

	public BoardDao() throws IOException {
		reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		session = ssf.openSession();
	}

	@Override
	public List<Board> listBoard(String bsort, String searchKeyword, String searchValue)
			throws SQLException {

		if (bsort == null) bsort="";
		if (searchKeyword == null) searchKeyword="";
		if (searchValue == null) searchValue="";
		List<Board> boardList = session.selectList("selectAllBoards");
		//
		//		// 게시물 검색 기능
		//		if (searchKeyword.equals("btitle")) {
		//			sql += " WHERE BTITLE LIKE '%" + searchValue + "%' ";
		//		} else if (searchKeyword.equals("bcontent")) {
		//			sql += " WHERE BCONTENT LIKE '%" + searchValue + "%' ";
		//		} else if (searchKeyword.equals("")) {
		//			sql += " WHERE ( BTITLE LIKE '%" + searchValue + "%' ";
		//			sql += " OR BCONTENT LIKE '%" + searchValue + "%' ) ";
		//		}
		//
		//		// 게시물 분류 기능
		//		if (!bsort.isEmpty()) {
		//			sql += " AND BSORT = '" + bsort + "'";
		//		}
		//

		if(boardList.isEmpty()) {
			return Collections.emptyList();
		} else {
			return boardList;			
		}
	}

	@Override
	public Board getBoard(int bid) throws SQLException {
		Board board = session.selectOne("selectBoard", bid);
		return board;
	}

	@Override
	public int registBoard(Board b) throws SQLException {
		Board board = new Board(
				0,
				b.getBtitle(),
				b.getBcontent(),
				b.getBwriter(),
				1,
				new Timestamp(System.currentTimeMillis()),
				b.getBsort(),
				b.getCfn()
				);
		int result = session.insert("insertBoard", board);
		session.commit();
		return result;
	}

	@Override
	public int updateBoard(Board b) throws SQLException {
		Board board = new Board(
				b.getBid(),
				b.getBtitle(),
				b.getBcontent(),
				b.getBwriter(),
				1,
				new Timestamp(System.currentTimeMillis()),
				b.getBsort(),
				b.getCfn()
				);
		int result = session.update("updateBoard", board);
		session.commit();
		return result;
	}

	@Override
	public int deleteBoard(int bid) throws SQLException {
		int result = session.delete("deleteBoard", bid);
		session.commit();		
		return result;
	}

	@Override
	public int addCount(int bid) throws SQLException {
		int result = session.update("updateCount", bid);
		session.commit();
		return result;
	}

}
