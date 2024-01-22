package com.algo.mvc.company.model.service;

import com.algo.mvc.company.model.dao.CompanyDao;
import java.sql.Connection;

import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

public class CompanyService {

	public int getCompanyCount() {
		int count = 0;
		Connection connection = getConnection();
		
		count = new CompanyDao().getCompanyCount(connection);
		
		close(connection);
		
		return count;
	}
	
}
