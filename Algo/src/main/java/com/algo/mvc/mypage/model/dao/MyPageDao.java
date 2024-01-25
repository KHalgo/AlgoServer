package com.algo.mvc.mypage.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algo.mvc.mypage.model.vo.MyPage;

public class MyPageDao {
	
	// 아이디값 구하기 (mypage 테이블)
	public MyPage findMyPageById(Connection connection, int myPageNo) {
		MyPage myPage = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM MYPAGE WHERE MYPAGE_NO = '?' ORDER BY MYPAGE_NO";
		
		try {
			pstmt = connection.prepareStatement(query);
			// 마이페이지 카테고리 명으로 불러옴
			
			pstmt.setInt(1, myPageNo);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				myPage = new MyPage();
				
				myPage.setMyPageNo(rs.getInt("MYPAGE_NO"));
				myPage.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPage.setMyPageCategory(rs.getString("MYPAGE_CATEGORY"));
				myPage.setMyPageCategoryTitle(rs.getString("MYPAGE_CATEGORY_TITLE"));
				myPage.setMyPageDate(rs.getDate("MYPAGE_DATE"));
				myPage.setMyPageView(rs.getInt("MYPAGE_VIEW"));
				myPage.setMyPageCheck(rs.getString("MYPAGE_CHECK"));
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
