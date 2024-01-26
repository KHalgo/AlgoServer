package com.algo.mvc.mypage.model.service;
import java.sql.Connection;

import com.algo.mvc.mypage.model.dao.MyPageDao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.*;

public class MyPageService {
	public int getBoardCount() {
		int count = 0;
		Connection connection = getConnection();
		
		count = new MyPageDao().getMypageCount(connection);
		close(connection);
		
		return count;
		
	}
}
