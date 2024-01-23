package com.algo.mvc.company.model.service;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.dao.CompanyDao;
import com.algo.mvc.company.model.vo.Company;

import java.sql.Connection;
import java.util.List;

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

	public List<Company> getCompanyList(PageInfo pageInfo) {
		List<Company> list = null;
		Connection connection = getConnection();
		
		list = new CompanyDao().findAll(connection, pageInfo);
		
		return list;
	}
	
}
