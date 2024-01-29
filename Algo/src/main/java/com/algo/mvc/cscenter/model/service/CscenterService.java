package com.algo.mvc.cscenter.model.service;

import static com.algo.mvc.common.jdbc.JDBCTemplate.close;
import static com.algo.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.algo.mvc.common.jdbc.JDBCTemplate.commit;
import static com.algo.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.dao.CscenterDao;
import com.algo.mvc.cscenter.model.vo.Cscenter;

public class CscenterService {

	public int getCscenterCount() {
		int count = 0;
		Connection connection = getConnection();
		
		count = new CscenterDao().getCscenterCount(connection);
		close(connection);
		
		return count;
	}

	public List<Cscenter> getBoardList(PageInfo pageInfo) {
		
		return null;
	}

//	public Cscenter getCscenterByNo(int no, boolean hasRead) {
//		Board board = null;
//		Connection connection = getConnection();
//		
//		board = new BoardDao().findBoardByNo(connection, no);
//		
//		// 게시글 조회수를 증가시키는 로직
//		if(board != null && !hasRead) {
//			int result = new BoardDao().updateReadCount(connection, board);
//			
//			if(result > 0) {
//				commit(connection);
//			} else {
//				rollback(connection);
//			}
//		}
//		
//		close(connection);
//		
//		return board;
//	}

	
	public int getCscenterCount(String category) {
		int count = 0;
		Connection connection = getConnection();
		
		count = new CscenterDao().getCscenterCount(connection, category);
		close(connection);
		
		return count;
	}
	public List<Cscenter> getCscenterList(PageInfo pageInfo) {
		List<Cscenter> list = null;
		Connection connection = getConnection();
		
		list = new CscenterDao().findAll(connection, pageInfo);
		
		close(connection);
		
		return list;
	}

	public List<Cscenter> getCscenterList(PageInfo pageinfo, String category) {
		List<Cscenter> list = null;
		Connection connection = getConnection();
		
		list = new CscenterDao().findCscenterByCategory(connection, pageinfo, category);
		
		close(connection);
		
		return list;
	}
	
	public List<Cscenter> getCscenterCategory(PageInfo pageInfo ,String category) {
		List<Cscenter> cscenter = null;
		Connection connection = getConnection();
		cscenter = new CscenterDao().findCscenterByCategory(connection, pageInfo, category);
		
		close(connection);
		
		return cscenter;
	}
	
	public int save(Cscenter cscenter) {
		int result = 0;
		Connection connection = getConnection();
		
		if (cscenter.getCsNo() > 0) {
			// update
			result = new CscenterDao().updateCscenter(connection, cscenter);
		} else {
			// insert
			result = new CscenterDao().insertBoard(connection, cscenter);
		}
		
		if (result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}	
		
		return result;
	}
	
	//  조회수 관련
	public Cscenter getBoardByNo(int no, boolean hasRead) {
		
		Cscenter cscenter = null;
		Connection connection = getConnection();
		
		cscenter = new CscenterDao().findCscenterByNo(connection, no);
		
		if(cscenter != null && !hasRead) {
			int result = new CscenterDao().updateReadCount(connection, cscenter);
			
			if(result > 0) {
				commit(connection);
			} else {
				rollback(connection);
			}
		}
		
		close(connection);
		
		return cscenter;
	}

}
