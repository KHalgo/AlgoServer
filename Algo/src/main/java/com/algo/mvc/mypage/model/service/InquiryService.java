package com.algo.mvc.mypage.model.service;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.commit;
import static com.algo.mvc.common.jdbc.JDBCTemplate.rollback;
import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.common.jdbc.JDBCTemplate;
import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.mypage.model.dao.InquiryDao;
import com.algo.mvc.mypage.model.vo.Inquiry;

public class InquiryService {
	public Inquiry getInquiryByNo(int inquiryNo) {
		Inquiry inquiry = null;
		Connection connection = getConnection();
		
		inquiry = new InquiryDao().findInquiryByNo(connection, inquiryNo);
				
		close(connection);
		return inquiry;
	}
	
	public int getInquiryCount() {
		int count = 0;
		
		Connection connection = JDBCTemplate.getConnection();
		
		count = new InquiryDao().getInquiryCount(connection);
		close(connection);
		
		return count;
	}

	public List<Inquiry> getinquiryList(PageInfo pageInfo) {
		List<Inquiry> list = null;
		Connection connection = getConnection();
		
		list = new InquiryDao().findAll(connection, pageInfo);
		
		close(connection);
		
		return list;
	}
	
	public int save(Inquiry inquiry) {
		int result = 0;
		Connection connection = getConnection();
		
		// insert
		result = new InquiryDao().insertInquiry(connection, inquiry);
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}	
		
		return result;
	}

	public Inquiry getMypageByNo(int inquiryNo) {
		Inquiry inquiry = null;
		Connection connection = getConnection();
		
		inquiry = new InquiryDao().findInquiryByNo(connection, inquiryNo);
		
		close(connection);
		
		return inquiry;
	}
	
}
