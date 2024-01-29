package com.algo.mvc.company.model.service;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.dao.CompanyCommentDao;
import com.algo.mvc.company.model.vo.CompanyComment;

public class CompanyCommentService {

	public int getCompanyCommentCount(int industryID) {
		int count = 0;
		Connection connection = getConnection();
		
		
		count = new CompanyCommentDao().getCompanyCommentCount(connection, industryID);
		
		close(connection);
		
		return count;
	}
	
	public List<CompanyComment> getCompanyCommentList(PageInfo pageInfo, int industryID) {
		List<CompanyComment> list = null;
		Connection connection = getConnection();
		
		list = new CompanyCommentDao().findAll(connection, pageInfo, industryID);
		
		close(connection);
		
		return list;
	}

	public CompanyComment getCompanyBestComment(int industryID) {
		CompanyComment bestComment = null;
		
		Connection connection = getConnection();
		
		bestComment = new CompanyCommentDao().findBestComment(connection, industryID);
		
		close(connection);
		
		return bestComment;
	}

	public List<CompanyComment> getCompanyRecentComment() {
		List<CompanyComment> comlist = null;
		
		Connection connection = getConnection();
		
		comlist = new CompanyCommentDao().findRecentComment(connection);
		
		close(connection);
		
		return comlist;
	}

}
