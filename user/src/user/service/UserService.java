package user.service;

import java.util.List;

import user.domain.User;

public interface UserService {

	public abstract int insertUser(User user);

	public abstract List<User> getUserList();

	public abstract int getUser(int userNo);

	public abstract int updateUser(User user);

	public abstract int deleteUser(int userNo);

}
