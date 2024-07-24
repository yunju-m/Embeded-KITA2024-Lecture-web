package mybatisboard.member;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao implements MemberInterface {

	String resource = "conf/configuration.xml";
	Reader reader;
	SqlSession session = null;

	public MemberDao() throws IOException{
		reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		session = ssf.openSession();
	}

	@Override
	public boolean getMember(Member m) {
		return session.selectOne("selectMember", m) != null;
	}

} // class
