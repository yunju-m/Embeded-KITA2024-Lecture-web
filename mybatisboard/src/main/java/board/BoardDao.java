package board;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements BoardInterface {

	private static Reader reader = null;
	private static SqlSessionFactory ssf = null;

	static {
		try {
			reader = Resources.getResourceAsReader("conf/configuration.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public List<Board> listBoard(String bsort, String searchKeyword, String searchValue)
			throws SQLException {
		Search search = new Search(bsort, searchKeyword, searchValue);
		return ssf.openSession().selectList("board.selectBoard", search);
	}

	@Override
	public Board getBoard(int bid) throws SQLException {
		SqlSession ss = ssf.openSession();
		Board board = ss.selectOne("board.getBoard", bid);
		ss.close();
		return board;
	}

	@Override
	public int registBoard(Board board) throws SQLException {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("board.registBoard", board);
		ss.commit();
		ss.close();
		return result;
	}

	@Override
	public int updateBoard(Board board) throws SQLException {
		SqlSession ss = ssf.openSession();
		int result = ss.update("board.updateBoard", board);
		ss.commit();
		ss.close();
		return result;
	}

	@Override
	public int deleteBoard(int bid) throws SQLException {
		SqlSession ss = ssf.openSession();
		int result = ss.delete("board.deleteBoard", bid);
		ss.commit();	
		ss.close();
		return result;
	}

	@Override
	public int addCount(int bid) throws SQLException {
		SqlSession ss = ssf.openSession();
		int result = ss.update("board.addCount", bid);
		ss.commit();
		ss.close();
		return result;
	}

}
