package com.algo.mvc.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.board.model.vo.Board;
import com.algo.mvc.common.util.PageInfo;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;

// 데이터에 접근하기 위한 용도의 객체 dao
public class BoardDao {

	public int getBoardCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM BOARD WHERE BIG_CATEGORY_ID = 'TALK'";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// count(*) 
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

	public List<Board> findAll(Connection connection, PageInfo pageinfo) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, POST_NO, USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, POST_LIKE_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID  "
		                + "FROM ("
		                +     "SELECT ROWNUM AS RNUM, POST_NO, USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, POST_LIKE_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID  "
		                +     "FROM ("
		                +         "SELECT POST_NO, U.USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, POST_LIKE_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID  "
		                +         "FROM BOARD B JOIN USERS U ON (B.WRITER_ID = U.USER_ID) "
		                +         "WHERE BIG_CATEGORY_ID = 'TALK' "
		                +		  "ORDER BY POST_NO "
		                +     ")"
		                + ")"
		                + "WHERE RNUM BETWEEN ? and ? "
		                + "ORDER BY RNUM DESC";
		
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, pageinfo.getStartList2());
			pstmt.setInt(2, pageinfo.getEndList2());
			
//			System.out.println(pageinfo.getStartList()+","+ pageinfo.getEndList());
//			System.out.println(pageinfo.getCurrentPage());
			
			rs = pstmt.executeQuery();
			
			Board board;
			while (rs.next()) {
				board = new Board();
				
				board.setPostNo(rs.getInt("POST_NO"));
				board.setRowNum(rs.getInt("RNUM"));
				board.setWriterId(rs.getString("USER_NICK"));
				board.setPostTitle(rs.getString("POST_TITLE"));
				board.setPostDate(rs.getDate("POST_DATE"));
				board.setPostViewCount(rs.getInt("POST_VIEW_COUNT"));
				board.setPostLikeCount(rs.getInt("POST_LIKE_COUNT"));
				board.setBigCategoryId(rs.getString("BIG_CATEGORY_ID"));
				board.setSmallCategoryId(rs.getString("SMALL_CATEGORY_ID"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public Board findBoardByNo(Connection connection, int no) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT POST_NO, "
							+ "POST_TITLE, "
							+ "POST_DATE, "
							+ "SMALL_CATEGORY_ID, "
							+ "POST_VIEW_COUNT, "
							+ "POST_LIKE_COUNT, "
							+ "POST_CONTENT, "
							+ "POST_LOCATION, "
							+ "WRITER_ID, "
							+ "USER_NICK, "
							+ "SIDO, "
							+ "SIGUNGU "
					+ "FROM BOARD B "
					+ "JOIN USERS U ON (B.WRITER_ID  = U.USER_ID) "
					+ "WHERE BIG_CATEGORY_ID = 'TALK' AND POST_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			// ? 처리
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				
				board.setPostNo(rs.getInt("POST_NO"));
				board.setPostTitle(rs.getString("POST_TITLE"));
				board.setPostDate(rs.getDate("POST_DATE"));
				board.setSmallCategoryId(rs.getString("SMALL_CATEGORY_ID"));
				board.setPostViewCount(rs.getInt("POST_VIEW_COUNT"));
				board.setPostLikeCount(rs.getInt("POST_LIKE_COUNT"));
				board.setPostContent(rs.getString("POST_CONTENT"));
				board.setPostLocation(rs.getString("POST_LOCATION"));
				board.setWriterId(rs.getString("WRITER_ID"));
				board.setUserNick(rs.getString("USER_NICK"));
			} else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return board;
	}

}
