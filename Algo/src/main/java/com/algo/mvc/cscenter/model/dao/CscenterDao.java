package com.algo.mvc.cscenter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.board.model.vo.Board;
import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.vo.Cscenter;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

public class CscenterDao {
	
	
	public int getCscenterCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM BOARD WHERE BIG_CATEGORY_ID = 'NOTICE'";
		
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
	
	public List<Cscenter> findAll(Connection connection, PageInfo pageinfo) {
		List<Cscenter> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, POST_NO, USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID "
		                + "FROM ( "
		                +     "SELECT ROWNUM AS RNUM, POST_NO, USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID "
		                +     "FROM ( "
		                +         "SELECT POST_NO, U.USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID "
		                +         "FROM BOARD B JOIN USERS U ON (B.WRITER_ID = U.USER_ID) "
		                +         "WHERE BIG_CATEGORY_ID = 'NOTION'"
		                +		  "ORDER BY POST_NO "
		                +     ") "
		                + ") "
		                + "WHERE RNUM BETWEEN ? and ? "
		                + "ORDER BY RNUM DESC";
		
		
		try {
		pstmt =	connection.prepareStatement(query);
		
		pstmt.setInt(1, pageinfo.getEndList());
		pstmt.setInt(2, pageinfo.getStartList());
		
		System.out.println(pageinfo.getStartList() + ", "+ pageinfo.getEndList());
		System.out.println(pageinfo.getCurrentPage());
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			
			board.setPostNo(rs.getInt("POST_NO"));
			board.setRowNum(rs.getInt("RNUM"));
			board.setWriterId(rs.getString("USER_NICK"));
			board.setPostTitle(rs.getString("POST_TITLE"));
			board.setPostDate(rs.getDate("POST_DATE"));
			board.setPostViewCount(rs.getInt("POST_VIEW_COUNT"));
			board.setBigCategoryId(rs.getString("BIG_CATEGORY_ID"));
			board.setSmallCategoryId(rs.getString("SMALL_CATEGORY_ID"));
			
//			list.add(board);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	// 유저 아이디에 
}