package com.algo.mvc.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.board.model.dao.BoardDao;
import com.algo.mvc.board.model.vo.Board;
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

}
