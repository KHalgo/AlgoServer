package com.algo.mvc.account.model.service;

import java.sql.Connection;

import com.algo.mvc.account.model.dao.UsersDao;
import com.algo.mvc.account.model.vo.Users;
import static com.algo.mvc.common.jdbc.JDBCTemplate.*;

public class UsersService {
	public Users findMemberById(String userId) {
		Users users = null;
		Connection connection = getConnection();
		
		users = new UsersDao().findMemberById(connection, userId);
		
		close(connection);
		
		return users;
		
	}
	
	
	public Users login(String userId, String userPwd) {
		Users users = this.findMemberById(userId);
		
		if (users != null && users.getUserPw().equals(userPwd)) {
			return users;
		} else {
			return null;
		}

	}
	
}
