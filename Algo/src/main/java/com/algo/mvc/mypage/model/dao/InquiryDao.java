package com.algo.mvc.mypage.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.mypage.model.vo.Inquiry;

public class InquiryDao {
	
	// 아이디값 구하기 (inquiry 테이블)
	public Inquiry findInquiryByNo(Connection connection, int inquiryNo) {
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
						+ "WHERE I.INQUIRY_NO = ? ";
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
		return inquiry;
	}

	public int getInquiryCount(Connection connection) {
		
		int count = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT COUNT(INQUIRY_NO) FROM INQUIRY";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(connection);
		}
		
		return count;
	}
	
	// 유저가 등록할시
	public List<Inquiry> findAll(Connection connection, PageInfo pageInfo) {
		List<Inquiry> list = new ArrayList<>();	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, I.INQUIRY_NO, I.USER_ID, I.INQUIRY_TITLE, I.INQUIRY_CREATE_DATE, I.INQUIRY_CONTENT, IA.ANSWER_NO, IA.ANSWER_CONTENT  "
				+ "FROM ( "
				+ "    SELECT ROWNUM AS RNUM, I.INQUIRY_NO, I.USER_ID, I.INQUIRY_TITLE, I.INQUIRY_CREATE_DATE, I.INQUIRY_CONTENT, IA.ANSWER_NO, IA.ANSWER_CONTENT "
				+ "    FROM ( "
				+ "            SELECT I.INQUIRY_NO, I.USER_ID, I.INQUIRY_TITLE, I.INQUIRY_CREATE_DATE, I.INQUIRY_CONTENT, IA.ANSWER_NO, IA.ANSWER_CONTENT "
				+ "            FROM INQUIRY I "
				+ "            INNER JOIN INQUIRY_ANSWER IA ON (I.INQUIRY_NO = IA.INQUIRY_NO) "
				+ "            ORDER BY I.INQUIRY_NO "
				+ "    ) "
				+ ") "
				+ "WHERE RNUM BETWEEN ? AND ? "
				+ "ORDER BY RNUM DESC; ";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getEndList());
			pstmt.setInt(2, pageInfo.getStartList());
			
			rs = pstmt.executeQuery();
			
			Inquiry inquiry;
			while (rs.next()) {
				inquiry = new Inquiry();
				
				inquiry.setInquiryNo(rs.getInt("INQUIRY_NO"));
				inquiry.setUserId(rs.getString(0));
				
				list.add(inquiry);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public int insertInquiry(Connection connection, Inquiry inquiry) {
		int rs = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO INQUIRY VALUES(SEQ_INQUIRY_NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, inquiry.getInquiryTitle());
			pstmt.setString(2, inquiry.getInquiryContent());
			pstmt.setString(3, inquiry.getUserId());
			
			rs = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return rs;
	}
	
	public int updateInqiry(Connection connection, Inquiry inquiry) {
		return 0;
	}

}
