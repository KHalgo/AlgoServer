package com.algo.mvc.account.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algo.mvc.account.model.vo.Users;

public class UsersDao {

	public Users findMemberById(Connection connection, String userId) {
		Users users = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM USERS WHERE USER_ID=?";

		try {
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, userId); // 쿼리문(rs = pstmt.executeQuery();)을 수행하기 전에 이 코드를 작성해야 함.

			rs = pstmt.executeQuery();

			if (rs.next()) {
				users = new Users();
				
				users.setUserId(rs.getString("USER_ID"));
				users.setUserName(rs.getString("USER_NAME"));
				users.setUserPw(rs.getString("USER_PW"));
				users.setUserPhone(rs.getString("USER_PHONE"));
				users.setUserEmail(rs.getString("USER_EMAIL"));
				users.setUserBirthday(rs.getDate("USER_BIRTHDAY"));
//				users.setUserAddress(rs.getString("USER_ADDRESS"));
				users.setUserDormant(rs.getString("USER_DORMANT"));
				users.setUserDate(rs.getDate("USER_DATE"));
				users.setUserPhoto(rs.getString("USER_PHOTO"));
				users.setUserNick(rs.getString("USER_NICK"));
				users.setAdminYn(rs.getString("ADMIN_YN"));
				users.setSido(rs.getString("SIDO"));
				users.setSigungu(rs.getString("SIGUNGU"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return users;
	}
	public Users findMemberByNick(Connection connection, String userNick) {
		Users users = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM USERS WHERE USER_NICK=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, userNick); // 쿼리문(rs = pstmt.executeQuery();)을 수행하기 전에 이 코드를 작성해야 함.
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				users = new Users();
				
				users.setUserId(rs.getString("USER_ID"));
				users.setUserName(rs.getString("USER_NAME"));
				users.setUserPw(rs.getString("USER_PW"));
				users.setUserPhone(rs.getString("USER_PHONE"));
				users.setUserEmail(rs.getString("USER_EMAIL"));
				users.setUserBirthday(rs.getDate("USER_BIRTHDAY"));
//				users.setUserAddress(rs.getString("USER_ADDRESS"));
				users.setUserDormant(rs.getString("USER_DORMANT"));
				users.setUserDate(rs.getDate("USER_DATE"));
				users.setUserPhoto(rs.getString("USER_PHOTO"));
				users.setUserNick(rs.getString("USER_NICK"));
				users.setAdminYn(rs.getString("ADMIN_YN"));
				users.setSido(rs.getString("SIDO"));
				users.setSigungu(rs.getString("SIGUNGU"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return users;
	}

	public int insertUsers(Connection connection, Users users) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO USERS VALUES(?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,?,DEFAULT,?,?)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, users.getUserId());
			pstmt.setString(2, users.getUserName());
			pstmt.setString(3, users.getUserPw());
			pstmt.setString(4, users.getUserPhone());
			pstmt.setString(5, users.getUserEmail());
//			pstmt.setString(6, users.getUserBirthday());
			pstmt.setString(6, users.getUserNick());
			pstmt.setString(7, users.getSido());
			pstmt.setString(8, users.getSigungu());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
}
