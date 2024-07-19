package jspbasic.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jspbasic.board.ConnectionUtil;

public class MemberDao implements MemberInterface {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDao() {
		conn = ConnectionUtil.getConnection();
	}

	@Override
	public boolean getMember(Member member) throws SQLException{
		String sql = " SELECT * FROM MEMBER WHERE MID = ? AND MPASS = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMpass());
		return pstmt.executeQuery().next();
	}

} // class
