package reply;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyDao implements ReplyInterface {

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
	public List<Reply> listReply() throws Exception {
		return ssf.openSession().selectList("reply.listReply");
	}

	@Override
	public int registReply(Reply reply) throws Exception {
		SqlSession ss = ssf.openSession(true);
		int result = ss.insert("reply.registReply", reply);
		ss.close();
		return result;
	}

	@Override
	public int deleteReply(int rid) throws Exception {
		SqlSession ss = ssf.openSession(true);
		int result = ss.insert("reply.deleteReply", rid);
		ss.close();
		return result;
	}

}
