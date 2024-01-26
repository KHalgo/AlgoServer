package com.algo.mvc.cscenter.model.service;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.dao.CscenterDao;
import com.algo.mvc.cscenter.model.vo.Cscenter;

public class CscenterService {

	public int getBoardCount() {
		int count = 0;
		Connection connection = getConnection();
		
		count = new CscenterDao().getCsCount(connection);
		close(connection);
		
		return count;
	}

	public List<Cscenter> getBoardList(PageInfo pageInfo) {
		
		return null;
	}

	public Cscenter getCscenterByNo(int no, boolean hasRead) {
		Board board = null;
		Connection connection = getConnection();
		
		board = new BoardDao().findBoardByNo(connection, no);
		
		// 게시글 조회수를 증가시키는 로직
		if(board != null && !hasRead) {
			int result = new BoardDao().updateReadCount(connection, board);
			
			if(result > 0) {
				commit(connection);
			} else {
				rollback(connection);
			}
		}
		
		close(connection);
		
		return board;
	}
}
