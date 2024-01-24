package com.algo.mvc.company.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.vo.Company;
import com.algo.mvc.company.model.vo.CompanyComment;

public class CompanyCommentDao {

	public int getCompanyCommentCount(Connection connection, int industryID) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM INDUSTRY_REVIEW WHERE INDUSTRY_ID = ? ";
		
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, industryID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}

	public List<CompanyComment> findAll(Connection connection, PageInfo pageInfo, int industryID) {
		List<CompanyComment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM ( "
				+ "SELECT ROWNUM AS RNUM2, INDUSTRY_ID, POST_COMMENT, REVIEW_LIKE "
				+ "    FROM ( "
				+ "         SELECT I.INDUSTRY_ID AS INDUSTRY_ID, "
				+ "        R.POST_COMMENT AS POST_COMMENT, "
				+ "        R.REVIEW_LIKE AS REVIEW_LIKE "
				+ "    	   FROM INDUSTRY I "
				+ "        LEFT OUTER JOIN INDUSTRY_REVIEW R "
				+ "        ON R.INDUSTRY_ID = I.INDUSTRY_ID "
				+ "    	   WHERE I.INDUSTRY_ID = ? "
				+ "        ORDER BY POST_DATE DESC "
				+ "    ) "
				+ ") "
				+ "WHERE RNUM2 BETWEEN ? and ?";	
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, industryID);
			pstmt.setInt(2, pageInfo.getStartList());
			pstmt.setInt(3, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CompanyComment comment = new CompanyComment();
				
				comment.setIndustryID(rs.getInt("INDUSTRY_ID"));
				comment.setCoRowNum(rs.getInt("RNUM2"));
				comment.setPostComment(rs.getString("POST_COMMENT"));
				comment.setLike(rs.getInt("REVIEW_LIKE"));
				
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

}
