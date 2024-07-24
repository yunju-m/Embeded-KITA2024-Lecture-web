package mybatisboard.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardTest {

	public static void main(String[] args) {

		String resource = "conf/configuration.xml";
		Reader reader;
		SqlSession session = null;

		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			session = ssf.openSession();

			// 게시물 등록 테스트
			Board board = new Board(0, "제목", "내용", "작성자", 1,
					new Timestamp(System.currentTimeMillis()), "공지", "file1");
			int result = session.insert("insertBoard", board);
			session.commit();
			if (result > 0) {
				System.out.println("등록 성공!");
			} else {
				System.out.println("등록 실패!");
			}

			// 게시물 전체 목록리스트 출력 테스트
			List<Board> boardList = session.selectList("selectAllBoards");
			for (Board b : boardList) {
				System.out.println(b);
			}

			// 게시물 하나 출력 테스트
			board = session.selectOne("selectBoard", 1);
			System.out.println(board);

			// 게시물 수정 테스트
			board = new Board(1, "새로운 제목", "새로운 내용", "새로운 작성자", 1,
					new Timestamp(System.currentTimeMillis()), "공지", "file2");
			result = session.update("updateBoard", board);
			session.commit();
			if (result > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

			// 게시물 삭제 테스트
			result = session.delete("deleteBoard", 3);
			session.commit();			
			if (result > 0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패!");
			}

			// 게시물 조회수 증가 테스트
			result = session.update("updateCount", 2);
			session.commit();
			if (result > 0) {
				System.out.println("조회수 증가 성공!");
			} else {
				System.out.println("조회수 증가 실패!");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (session != null) session.close();
		}

	} // main

} // class
