package reply;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyTest {

	public static void main(String[] args) {

		String resource = "conf/configuration.xml";
		Reader reader;
		SqlSession session = null;

		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			session = ssf.openSession();

			// 댓글 등록 테스트
			Reply reply1 = new Reply(0, "댓글작성자1", "댓글내용1", null, 2);
			Reply reply2 = new Reply(0, "댓글작성자1", "댓글내용1", null, 3);
			Reply reply3 = new Reply(0, "댓글작성자1", "댓글내용1", null, 3);

			int result1 = session.insert("registReply", reply1);
			int result2 =session.insert("registReply", reply2);
			int result3 = session.insert("registReply", reply3);
			session.commit();

			if (result1 > 0 && result2 > 0 && result3 > 0) {
				System.out.println("등록 성공!");
			} else {
				System.out.println("등록 실패!");
			} 

			// 전체 댓글 출력 테스트
			List<Reply> replyList = session.selectList("listReply", "");
			for (Reply reply : replyList) {
				System.out.println(reply);
			}

			// 댓글 삭제 테스트
			int result = session.delete("deleteReply", 3);
			session.commit();			
			if (result > 0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

} // class
