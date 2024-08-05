package mybatisuser.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mybatisuser.domain.User;
import mybatisuser.service.UserService;
import mybatisuser.service.UserServiceImpl;

public class UserTest {

	private ApplicationContext context;
	
	private UserService userService;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("mybatisuser/conf/beans.xml");
		userService = (UserServiceImpl)context.getBean("userService");
	}
	
	@Test
	public void dataSourceTest() {
		DataSource ds = (DataSource)context.getBean("dataSource");
		
		try {
			Connection conn = ds.getConnection();
			System.out.println(conn);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	@Test
	public void insertUser() {
		User user = new User(0, "아이디", "이름", "성별", "도시");
		int result = userService.insertUser(user);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateUser() {
		User user = new User(1, "새로운아이디", "새로운이름", "여", "강남");
		userService.updateUser(user);
	}
	
	@Test
	public void deleteUser() {
		int userNo = 1;
		userService.deleteUser(userNo);
	}
	
	@Test
	public void getUser() {
		int userNo = 2;
		User user = userService.getUser(userNo);
		System.out.println(user);
	}
	
	@Test
	public void getUserList() {
		List<User> userList = userService.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
}
