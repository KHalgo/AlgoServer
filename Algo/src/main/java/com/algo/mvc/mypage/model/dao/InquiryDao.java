package com.algo.mvc.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algo.mvc.mypage.model.vo.Inquiry;

public class InquiryDao {
	
	// 아이디값 구하기 (inquiry 테이블)
	public Inquiry findInquiryById(Connection connection, int inquiryNo) {
		Inquiry inquiry = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT  I.INQUIRY_NO, "
						+ "              I.USER_ID, "
						+ "              I.INQUIRY_TITLE, "
						+ "              I.INQUIRY_CONTENT, "
						+ "              IA.ANSWER_NO, "
						+ "              IA.ANSWER_CONTENT "
						+ "FROM INQUIRY I "
						+ "INNER JOIN INQUIRY_ANSWER IA ON (I.INQUIRY_NO =  IA.INQUIRY_NO) "
						+ "WHERE I.INQUIRY_NO = ? "
						+ "ORDER BY I.INQUIRY_NO;";
		try {
			pstmt = connection.prepareStatement(query);
			// 마이페이지 카테고리 명으로 불러옴
			
			pstmt.setInt(1, inquiryNo);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				inquiry = new Inquiry();
				
				inquiry.setInquiryNo(rs.getInt("INQUIRY_NO"));
				inquiry.setInquiryTitle(rs.getString("INQUIRY_TITLE"));
				inquiry.setInquiryContent(rs.getString("INQUIRY_CONTENT"));
				inquiry.setInquiryAnswerNo(rs.getInt("ANSWER_NO"));
				inquiry.setInquiryAnswerContent(rs.getString("ANSWER_CONTENT"));
				inquiry.setUserId(rs.getString("USER_ID"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return null;
	}
}
