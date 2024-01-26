package com.algo.mvc.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.board.model.service.BoardService;
import com.algo.mvc.board.model.vo.Board;
import com.algo.mvc.common.util.PageInfo;

@WebServlet(name = "qnaBoard", urlPatterns = { "/qnaBoard/" })
public class QnABoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QnABoardServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int listCount = 0;
    	PageInfo pageinfo = null;
    	List<Board> list = null;
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
    		page = 1;
    	}
    	
    	listCount = new BoardService().getBoardCountQ();
		pageinfo = new PageInfo(page, 5, listCount, 20);
		list = new BoardService().getBoardListQ(pageinfo);
		
		System.out.println(list);
		System.out.println(list.size());
		
    	
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("list", list);
    	request.getRequestDispatcher("/views/board/qnaBoard.jsp")
				.forward(request, response);
	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
