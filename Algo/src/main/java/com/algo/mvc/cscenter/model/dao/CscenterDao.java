package com.algo.mvc.cscenter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.algo.mvc.cscenter.model.vo.Cscenter;

public class CscenterDao {
	
	
	// 아이디값 구하기 (카테고리)
	public Cscenter findCsCenterById(Connection connection, String csId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cscenter cscenter = null;
		String query = "SELECT  I.INQUIRY_NO, "
						+ "              I.USER_ID, "
						+ "              I.INQUIRY_TITLE, "
						+ "              I.INQUIRY_CONTENT, "
						+ "              IA.ANSWER_NO, "
						+ "              IA.ANSWER_CONTENT "
						+ "FROM INQUIRY I "
						+ "INNER JOIN INQUIRY_ANSWER IA ON (I.INQUIRY_NO =  IA.INQUIRY_NO) "
						+ "WHERE I.USER_ID = ? "
						+ "ORDER BY I.INQUIRY_NO;";
				
				
		
		pstmt = connection.prepareStatement(query);
		// 마이페이지 카테고리 명으로 불러옴
		pstmt.setString(1, csId);
		
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			cscenter = new Cscenter();
			
			
		}
	}
	
	// 조회수 관련 dao
	public int getCsCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM MYPAGE WHERE MYPAGE_CATEGORY = 'QNA'";
		
		return count;
	}
	
	// 검색 관련 dao
	puublic 
}
