package mybatisuser.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatisuser.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insertUser(User user) {
		return session.insert("User.insertUser", user);
	}
	
	@Override
	public List<User> getUserList() {
		return session.selectList("User.getUserList");
	}
	
	@Override
	public User getUser(int userNo) {
		return session.selectOne("User.getUser", userNo);
	}
	
	@Override
	public int updateUser(User user) {
		return session.update("User.updateUser", user);
	}
	
	@Override
	public int deleteUser(int userNo) {
		return session.delete("User.deleteUser", userNo);
	}

	
}
