package com.algo.mvc.mypage.model.service;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.algo.mvc.mypage.model.dao.InquiryDao;
import com.algo.mvc.mypage.model.vo.Inquiry;

public class InquiryService {
	public Inquiry getInquiryById(int inquiryNo) {
		Inquiry inquiry = null;
		Connection connection = getConnection();
		
		inquiry = new InquiryDao().findInquiryById(connection, inquiryNo);
				
		close(connection);
		return inquiry;
	}
	
}
