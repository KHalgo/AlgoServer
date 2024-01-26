package com.algo.mvc.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.board.model.dao.BoardDao;
import com.algo.mvc.board.model.vo.Board;
import com.algo.mvc.board.model.vo.Reply;
import com.algo.mvc.common.jdbc.JDBCTemplate;
import com.algo.mvc.common.util.PageInfo;

import static com.algo.mvc.common.jdbc.JDBCTemplate.*;

//service쪽 로직 (db에 직접 접근 x)
public class BoardService {

	public int getBoardCount() {
		int count = 0;
		Connection connection = getConnection();
		
		// Dao에서 직접 connection 안함
		count = new BoardDao().getBoardCount(connection);
		
		close(connection);
		
//		System.out.println(count);
		
		return count;
	}

	
	public List<Board> getBoardList(PageInfo pageinfo) {
		List<Board> list = null;
		Connection connection = getConnection();
		
		list = new BoardDao().findAll(connection, pageinfo);
		
		System.out.println(list);
		
		close(connection);
		
		return list;
	}


	public Board BoardByNo(int no) {
		Board board = null;
		Connection connection = getConnection();
		
		board = new BoardDao().findBoardByNo(connection, no);
		
		close(connection);
		
		return board;
	}


	public int getBoardCountQ() {
		int count = 0;
		Connection connection = getConnection();
		
		count = new BoardDao().getBoardCountQ(connection);
		
		close(connection);
		
		return count;
	}


	public List<Board> getBoardListQ(PageInfo pageinfo) {
		List<Board> list = null;
		Connection connection = getConnection();
		
		list = new BoardDao().findAllQ(connection, pageinfo);
		
		
		close(connection);
		
		return list;
	}


	public Board getBoardByNoQ(int no) {
		Board board = null;
		Connection connection = getConnection();
		
		board = new BoardDao().findBoardByNoQ(connection, no);
		
		close(connection);
		
		return board;
	}


	public int save(Board board) {
		int result = 0;
		Connection connection = getConnection();
		
		if (board.getPostNo() > 0) {
			// update
			result = new BoardDao().updateBoard(connection, board);
		} else {
			// insert
			result = new BoardDao().insertBoard(connection, board);
		}
		
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}


	public int delete(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new BoardDao().updateStatus(connection, no);
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		return result;
	}


	public int saveReply(Reply reply) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new BoardDao().insertReply(connection, reply);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		
		return result;
	}


	public int saveQ(Board board) {
		int result = 0;
		Connection connection = getConnection();
		
		if (board.getPostNo() > 0) {
			// update
			result = new BoardDao().updateBoardQ(connection, board);
		} else {
			// insert
			result = new BoardDao().insertBoardQ(connection, board);
		}
		
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}


	public int deleteQ(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new BoardDao().updateStatusQ(connection, no);
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		return result;
	}

}
