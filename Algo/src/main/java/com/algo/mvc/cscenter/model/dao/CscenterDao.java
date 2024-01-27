package com.algo.mvc.cscenter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.vo.Cscenter;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

public class CscenterDao {
	
	
	public int getCscenterCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM CSCENTER WHERE CSCENTER_CATEGORY = 'NOTICE'";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
	
		System.out.println("count : " + count);
		return count;
	}
	
	public List<Cscenter> findAll(Connection connection, PageInfo pageInfo) {
		List<Cscenter> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, CSCENTER_NO, CSCENTER_CATEGORY, CSCENTER_TITLE, CSCENTER_CONTENT, CSCENTER_VIEW, USER_ID, CSCENTER_DATE "
						+ "FROM ( "
						+ "    SELECT ROWNUM AS RNUM, CSCENTER_NO, CSCENTER_CATEGORY, CSCENTER_TITLE, CSCENTER_CONTENT, CSCENTER_VIEW, USER_ID, CSCENTER_DATE "
						+ "    FROM ( "
						+ "        SELECT CSCENTER_NO, CSCENTER_CATEGORY, CSCENTER_TITLE, CSCENTER_CONTENT, CSCENTER_VIEW, USER_ID, CSCENTER_DATE "
						+ "        FROM CSCENTER "
						+ "        WHERE CSCENTER_CATEGORY = 'NOTICE' "
						+ "        ORDER BY CSCENTER_NO DESC "
						+ "    ) "
						+ ") "
						+ "WHERE RNUM BETWEEN ? AND ?; "
						+ "";
		try {
			pstmt = connection.prepareStatement(query);
			
//			pstmt.setInt(1, pageInfo.getStartList2());
//			pstmt.setInt(2, pageInfo.getEndList2());
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			Cscenter cscenter;
			
			while (rs.next()) {
				cscenter = new Cscenter();
				
				cscenter.setRowNum(rs.getInt("RNUM"));
				cscenter.setCsNo(rs.getInt("CSCENTER_NO"));
				cscenter.setCsCategory(rs.getString("CSCENTER_CATEGORY"));
				cscenter.setCsTitle(rs.getString("CSCENTER_TITLE"));
				cscenter.setCsContent(rs.getString("CSCENTER_CONTENT"));
				cscenter.setCsView(rs.getInt("CSCENTER_VIEW"));
				cscenter.setCsWriterId(rs.getString("USER_ID"));
				cscenter.setCsCreateDate(rs.getDate("CSCENTER_DATE"));
				
				list.add(cscenter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public Cscenter findBoardByNo(Connection connection, int no) {
		Cscenter cscenter = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String query = "SELECT CSCENTER_NO, CSCENTER_TITLE, USER_ID, CSCENTER_DATE, CSCENTER_VIEW, CSCENTER_CATEGORY, CSCENTER_CONTENT "
	    		+ "FROM CSCENTER "
	    		+ "WHERE CSCENTER_NO = ?; "
	    		+ "";
	    try {
	        pstmt = connection.prepareStatement(query);
	        pstmt.setInt(1, no);
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            cscenter = new Cscenter();
	            cscenter.setCsNo(rs.getInt("CSCENTER_NO"));
	            cscenter.setCsTitle(rs.getString("CSCENTER_TITLE"));
	            cscenter.setCsWriterId(rs.getString("USER_ID"));
	            cscenter.setCsCreateDate(rs.getDate("CSCENTER_DATE"));
	            cscenter.setCsView(rs.getInt("CSCENTER_VIEW"));
	            cscenter.setCsCategory(rs.getString("CSCENTER_CATEGORY"));
	            cscenter.setCsContent(rs.getString("CSCENTER_CONTENT"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    return cscenter;
	}

	
}