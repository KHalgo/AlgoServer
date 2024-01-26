package com.algo.mvc.mypage.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.mypage.model.vo.MyPage;

public class MyPageDao {
	
	// 아이디값 구하기 (mypage 테이블)
	public MyPage findMyPageById(Connection connection, String userId) {
		MyPage myPage = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM MYPAGE WHERE MYPAGE_NO = '?'";
		
		try {
			pstmt = connection.prepareStatement(query);
			// 마이페이지 카테고리 명으로 불러옴
			
			pstmt.setString(1, userId);
			
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
		return myPage;
	}
	public int getMypageCount(Connection connection) {
		int count = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
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
	
	public List<MyPage> findAll(Connection connection, PageInfo pageInfo) {
		List<MyPage> myPages = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM MYPAGE";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myPages;
		
	}
}
