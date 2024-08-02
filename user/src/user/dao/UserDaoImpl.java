package user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import user.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertUser(User user) {
		String sql = " insert into users values(seq_users.nextval, ?, ?, ?, ?) ";
		int result = jdbcTemplate.update(sql, user.getUserId(), user.getName(),
				user.getGender(), user.getCity());
		return result;
	}

	@Override
	public List<User> getUserList() {
		String sql = " select * from users ";
		return jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserNo(rs.getInt("userno"));
				user.setUserId(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				return user;
			}
		});
	}

	@Override
	public User getUser(int userNo) {
		String sql = " select * from users where userno=? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {userNo}, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserNo(rs.getInt("userno"));
				user.setUserId(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				return user;
			}
		});
	}

	@Override
	public int updateUser(User user) {
		String sql = " update users set userid=?, name=?, gender=?, city=? where userno=? ";   
		int result = jdbcTemplate.update(sql, user.getUserId(), user.getName(),
				user.getGender(), user.getCity(), user.getUserNo());
		return result;
	}

	@Override
	public int deleteUser(int userNo) {
		String sql = " delete from users where userno=? ";
		int result = jdbcTemplate.update(sql, userNo);
		return result;
	}

}
