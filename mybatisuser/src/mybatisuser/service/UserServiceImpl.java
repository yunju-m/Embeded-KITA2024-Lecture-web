package mybatisuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatisuser.dao.UserDao;
import mybatisuser.domain.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public User getUser(int userNo) {
		return userDao.getUser(userNo);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int userNo) {
		return userDao.deleteUser(userNo);
	}

}
