package com.algo.mvc.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.algo.mvc.board.model.vo.Board;
import com.algo.mvc.board.model.vo.Reply;
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
	
		System.out.println("count : " + count);
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
			
			pstmt.setInt(1, pageinfo.getEndList2());
			pstmt.setInt(2, pageinfo.getStartList2());
			
			System.out.println(pageinfo.getStartList2()+","+ pageinfo.getEndList2());
			System.out.println(pageinfo.getCurrentPage());
			
			rs = pstmt.executeQuery();
			
//			Board board;
			while (rs.next()) {
				Board board = new Board();
				
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
							+ "SIGUNGU, "
							+ "POST_FILE1, "
							+ "POST_FILE2, "
							+ "POST_FILE3, "
							+ "POST_FILE4 "
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
				board.setSido(rs.getString("SIDO"));
				board.setSigungu(rs.getString("SIGUNGU"));
				board.setPostFile1(rs.getString("POST_FILE1"));
				board.setPostFile2(rs.getString("POST_FILE2"));
				board.setPostFile3(rs.getString("POST_FILE3"));
				board.setPostFile4(rs.getString("POST_FILE4"));
				// 댓글 조회
//				board.setReplies(this.getRepliesByNo(connection, no));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return board;
	}

//	public List<Reply> getRepliesByNo(Connection connection, int postNo) {
//		List<Reply> replies = new ArrayList<>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String query = "SELECT C.COMMENT_NO, "
//							+ "C.POST_NO, "
//							+ "C.COMMENT_CONTENT, "
//							+ "U.USER_NICK, "
//							+ "C.COMMENT_DATE, "
//							+ "C.COMMENT_LIKE_COUNT "
//						+ "FROM COMMENTS "
//						+ "JOIN USERS U ON (C.WRITER_ID = U.USER_ID)"
//						+ "WHERE POST_NO=? "
//						+ "ORDER BY C.COMMENT_NO DESC";
//		
//		try {
//			pstmt = connection.prepareStatement(query);
//			
//			pstmt.setInt(1, postNo);
//			
//			while(rs.next()) {
//				Reply reply = new Reply();
//				
//				reply.setCommentNo(rs.getInt("COMMENT_NO"));
//				reply.setPostNo(rs.getInt("POST_NO"));
//				reply.setCommentContent(rs.getString("COMMENT_CONTENT"));
//				reply.setWriterId(rs.getString("USER_NICK"));
//				reply.setCommentDate(rs.getDate("COMMENT_DATE"));
//				reply.setCommentLikeCount(rs.getInt("COMMENT_LIKE_COUNT"));
//				
//			}
//			
//			rs = pstmt.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		
//		return replies;
//	}

	public int getBoardCountQ(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM BOARD WHERE BIG_CATEGORY_ID = 'QNA'";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			// 조회된 ResultSet 가져오기
			if(rs.next()) {
				// 쿼리문의 1번 컬럼을 가져오겠다(하나뿐임)
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

	public List<Board> findAllQ(Connection connection, PageInfo pageinfo) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, POST_NO, USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, POST_LIKE_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID  "
		                + "FROM ("
		                +     "SELECT ROWNUM AS RNUM, POST_NO, USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, POST_LIKE_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID  "
		                +     "FROM ("
		                +         "SELECT POST_NO, U.USER_NICK, POST_TITLE, POST_DATE, POST_VIEW_COUNT, POST_LIKE_COUNT, BIG_CATEGORY_ID, SMALL_CATEGORY_ID  "
		                +         "FROM BOARD B JOIN USERS U ON (B.WRITER_ID = U.USER_ID) "
		                +         "WHERE BIG_CATEGORY_ID = 'QNA' "
		                +		  "ORDER BY POST_NO "
		                +     ")"
		                + ")"
		                + "WHERE RNUM BETWEEN ? and ? "
		                + "ORDER BY RNUM DESC";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, pageinfo.getEndList2());
			pstmt.setInt(2, pageinfo.getStartList2());
			
			System.out.println(pageinfo.getStartList2()+","+ pageinfo.getEndList2());
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

	public Board findBoardByNoQ(Connection connection, int no) {
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
							+ "SIGUNGU, "
							+ "POST_FILE1, "
							+ "POST_FILE2, "
							+ "POST_FILE3, "
							+ "POST_FILE4 "
					+ "FROM BOARD B "
					+ "JOIN USERS U ON (B.WRITER_ID  = U.USER_ID) "
					+ "WHERE BIG_CATEGORY_ID = 'QNA' AND POST_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
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
				board.setSido(rs.getString("SIDO"));
				board.setSigungu(rs.getString("SIGUNGU"));
				board.setPostFile1(rs.getString("POST_FILE1"));
				board.setPostFile2(rs.getString("POST_FILE2"));
				board.setPostFile3(rs.getString("POST_FILE3"));
				board.setPostFile4(rs.getString("POST_FILE4"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return board;
	}

	public int insertBoard(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO BOARD VALUES(SEQ_POST_NO.NEXTVAL, ?, ?, 'TALK', ?, DEFAULT, DEFAULT, ?, '관심지역', DEFAULT, ?, ?, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, board.getWriterId());
			pstmt.setString(2, board.getSmallCategoryId());
			pstmt.setString(3, board.getPostTitle());
			pstmt.setString(4, board.getPostContent());
//			pstmt.setString(5, board.getPostLocation());
			pstmt.setString(5, board.getPostFile1());
			pstmt.setString(6, board.getPostFile2());
			pstmt.setString(7, board.getPostFile3());
			pstmt.setString(8, board.getPostFile4());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateBoard(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE BOARD SET POST_TITLE=?,POST_CONTENT=?,POST_FILE1=?,POST_FILE2=?, POST_FILE3=?, POST_FILE4=?, SMALL_CATEGORY_ID=?,POST_DATE=SYSDATE WHERE POST_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, board.getPostTitle());
			pstmt.setString(2, board.getPostContent());
			pstmt.setString(3, board.getPostFile1());
			pstmt.setString(4, board.getPostFile2());
			pstmt.setString(5, board.getPostFile3());
			pstmt.setString(6, board.getPostFile4());
			pstmt.setString(7, board.getSmallCategoryId());
			pstmt.setInt(8, board.getPostNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateStatus(Connection connection, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM BOARD WHERE POST_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReply(Connection connection, Reply reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO COMMENTS VALUES(SEQ_COMMENT_NO.NEXTVAL, ?, DEFAULT, DEFAULT, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, reply.getCommentContent());
			pstmt.setInt(2, reply.getPostNo());
			pstmt.setString(3, reply.getWriterId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoardQ(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO BOARD VALUES(SEQ_POST_NO.NEXTVAL, ?, 'NONE', 'QNA', ?, DEFAULT, DEFAULT, ?, '관심지역', DEFAULT, ?, ?, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, board.getWriterId());
			pstmt.setString(2, board.getPostTitle());
			pstmt.setString(3, board.getPostContent());
//			pstmt.setString(5, board.getPostLocation());
			pstmt.setString(4, board.getPostFile1());
			pstmt.setString(5, board.getPostFile2());
			pstmt.setString(6, board.getPostFile3());
			pstmt.setString(7, board.getPostFile4());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateBoardQ(Connection connection, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE BOARD SET POST_TITLE=?,POST_CONTENT=?,POST_FILE1=?,POST_FILE2=?, POST_FILE3=?, POST_FILE4=?, ,POST_DATE=SYSDATE WHERE POST_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, board.getPostTitle());
			pstmt.setString(2, board.getPostContent());
			pstmt.setString(3, board.getPostFile1());
			pstmt.setString(4, board.getPostFile2());
			pstmt.setString(5, board.getPostFile3());
			pstmt.setString(6, board.getPostFile4());
			pstmt.setInt(7, board.getPostNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateStatusQ(Connection connection, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM BOARD WHERE POST_NO = ?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
