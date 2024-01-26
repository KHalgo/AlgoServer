package com.algo.mvc.cscenter.model.service;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.dao.CscenterDao;
import com.algo.mvc.cscenter.model.vo.Cscenter;

public class CscenterService {

	public int getBoardCount() {
		int count = 0;
		Connection connection = getConnection();
		
		count = new CscenterDao().getCscenterCount(connection);
		close(connection);
		
		return count;
	}

	public List<Cscenter> getBoardList(PageInfo pageInfo) {
		List<Cscenter> list = null;
		Connection connection = getConnection();
		
		list = new CscenterDao().findAll(connection, pageInfo);
		
		System.out.println(list);
		
		close(connection);
		
		return list;
	}
	
	
	
}
