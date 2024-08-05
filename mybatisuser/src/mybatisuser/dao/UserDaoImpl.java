package mybatisuser.dao;

import java.util.List;

//import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatisuser.domain.User;
import mybatisuser.mapper.UserMapper;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

//	@Autowired
//	private SqlSession session;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insertUser(User user) {
//		return session.insert("mybatis.mapper.UserMapper.insertUser", user);
		return userMapper.insertUser(user);
	}
	
	@Override
	public List<User> getUserList() {
//		return session.selectList("mybatis.mapper.UserMapper.getUserList");
		return userMapper.getuserList();
	}
	
	@Override
	public User getUser(int userNo) {
//		return session.selectOne("mybatis.mapper.UserMapper.getUser", userNo);
		return userMapper.getUser(userNo);
	}
	
	@Override
	public int updateUser(User user) {
//		return session.update("mybatis.mapper.UserMapper.updateUser", user);
		return userMapper.updateUser(user);
	}
	
	@Override
	public int deleteUser(int userNo) {
//		return session.delete("mybatis.mapper.UserMapper.deleteUser", userNo);
		return userMapper.deleteUser(userNo);
	}

	
}
