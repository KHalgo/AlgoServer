package com.algo.mvc.cscenter.model.dao;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.vo.Cscenter;

public class CscenterDao {
	
	// 전체 게시물 수 조회
	public int getCscenterCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM CSCENTER";
		
		try {
			pstmt = connection.prepareStatement(query);
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
	
	// 카테고리 기준 게시물 수 조회
	public int getCscenterCount(Connection connection, String category) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM CSCENTER WHERE CSCENTER_CATEGORY = ?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, category);
			
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
						+ "        ORDER BY CSCENTER_DATE DESC "
						+ "    ) "
						+ ") "
						+ "WHERE RNUM BETWEEN ? AND ? "
						+ "";
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, pageInfo.getStartList());
			pstmt.setInt(2, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Cscenter cscenter = new Cscenter();
				
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
	
	public List<Cscenter> findCscenterByCategory(Connection connection, PageInfo pageInfo, String category) {
		List<Cscenter> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT RNUM, CSCENTER_NO, CSCENTER_CATEGORY, CSCENTER_TITLE, CSCENTER_CONTENT, CSCENTER_VIEW, USER_ID, CSCENTER_DATE "
						 + "FROM ( "
						 + "    SELECT ROWNUM AS RNUM, CSCENTER_NO, CSCENTER_CATEGORY, CSCENTER_TITLE, CSCENTER_CONTENT, CSCENTER_VIEW, USER_ID, CSCENTER_DATE "
						 + "    FROM ( "
						 + "        SELECT CSCENTER_NO, CSCENTER_CATEGORY, CSCENTER_TITLE, CSCENTER_CONTENT, CSCENTER_VIEW, USER_ID, CSCENTER_DATE "
						 + "        FROM CSCENTER "
						 + "    	   WHERE CSCENTER_CATEGORY = ? "
						 + "        ORDER BY CSCENTER_DATE DESC "
						 + "    ) "
						 + ") "
						 + "WHERE RNUM BETWEEN ? AND ? ";
		try {
			pstmt = connection.prepareStatement(query);
			
			
			pstmt.setString(1, category);
			pstmt.setInt(2, pageInfo.getStartList());
			pstmt.setInt(3, pageInfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Cscenter cscenter = new Cscenter();
				
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
	
	// 게시물 번호 따른 정보조회
	public Cscenter findCscenterByNo(Connection connection, int no) {
		Cscenter cscenter = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String query = "SELECT CSCENTER_NO, CSCENTER_TITLE, USER_ID, CSCENTER_DATE, CSCENTER_VIEW, CSCENTER_CATEGORY, CSCENTER_CONTENT "
	    		+ "FROM CSCENTER "
	    		+ "WHERE CSCENTER_NO = ? "
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

	public int updateReadCount(Connection connection, Cscenter cscenter) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE CSCENTER SET CSCENTER_VIEW = ? WHERE CSCENTER_NO = ? ";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			cscenter.setCsView(cscenter.getCsView() + 1);
			
			pstmt.setInt(1, cscenter.getCsView());
			pstmt.setInt(2, cscenter.getCsNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateCscenter(Connection connection, Cscenter cscenter) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "UPDATE CSCENTER SET CSCENTER_TITLE=?, CSCENTER_CATEGORY=? , CSCENTER_CONTENT=?, CSCENTER_DATE= SYSDATE WHERE CSCENTER_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, cscenter.getCsTitle());
			pstmt.setString(2, cscenter.getCsCategory());
			pstmt.setString(3, cscenter.getCsContent());
			pstmt.setInt(4, cscenter.getCsNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoard(Connection connection, Cscenter cscenter) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO CSCENTER (CSCENTER_NO, CSCENTER_TITLE, CSCENTER_CATEGORY, CSCENTER_CONTENT, CSCENTER_DATE, CSCENTER_VIEW, USER_ID) "
				+ "VALUES "
				+ "(SEQ_CSCENTER_NO.NEXTVAL, ?, ?, ?, SYSDATE , 0, ?)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, cscenter.getCsTitle());
			pstmt.setString(2, cscenter.getCsCategory());
			pstmt.setString(3, cscenter.getCsContent());
			pstmt.setString(4, cscenter.getCsWriterId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
}