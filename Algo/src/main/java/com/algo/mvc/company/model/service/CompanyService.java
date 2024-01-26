package com.algo.mvc.company.model.service;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.dao.CompanyCommentDao;
import com.algo.mvc.company.model.dao.CompanyDao;
import com.algo.mvc.company.model.vo.Company;
import com.algo.mvc.company.model.vo.CompanyComment;

import java.sql.Connection;
import java.util.List;

import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.commit;
import static com.algo.mvc.common.jdbc.JDBCTemplate.rollback;

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
		
		close(connection);
		
		return list;
	}
	
	public List<Company> getLocalCompanyList(PageInfo pageInfo, Users loginMember) {
		List<Company> list2 = null;
		Connection connection = getConnection();
		
		list2 = new CompanyDao().findLocal(connection, pageInfo, loginMember);
		
		close(connection);
		
		return list2;
	}
	
	public Company getCompanyByID(int industryID) {
		Company company = null;
		Connection connection = getConnection();
		
		company = new CompanyDao().findCompanyById(connection, industryID);
		
		close(connection);
		return company;
	}

	public Company getCompanyByIDRead(int industryID,  boolean hasRead) {
		Company company = null;
		Connection connection = getConnection();
		
		company = new CompanyDao().findCompanyById(connection, industryID);
		
		// 게시글 조회수를 증가시키는 로직
		if(company != null && !hasRead) {
			int result = new CompanyDao().updateReadCount(connection, company);
			
			if(result > 0) {
				commit(connection);
			} else {
				rollback(connection);
			}
		}
		
		close(connection);
		return company;
	}

	public int save(CompanyComment comment) {
		int result = 0;
		
		Connection connection = getConnection();
		
		result = new CompanyDao().insertComment(connection, comment);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	
}
