package com.algo.mvc.cscenter.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algo.mvc.cscenter.model.vo.Cscenter;

public class CscenterDao {
	
	
	// 유저 아이디에 
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
		
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, csId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cscenter = new Cscenter();
				
			} else {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cscenter;
	}
	
	// 조회수 관련 dao
	public int getCsCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(MYPAGE_VIEW) FROM MYPAGE";
		
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

	// 검색 관련 dao 만들것
}