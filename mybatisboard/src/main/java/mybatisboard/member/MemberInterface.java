package mybatisboard.member;

import java.sql.SQLException;

public interface MemberInterface {

	public abstract boolean getMember(Member member) throws SQLException;
	
}
