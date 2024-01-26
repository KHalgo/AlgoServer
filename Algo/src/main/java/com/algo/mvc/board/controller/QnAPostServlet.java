package com.algo.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.board.model.service.BoardService;
import com.algo.mvc.board.model.vo.Board;

@WebServlet(name = "qnaPost", urlPatterns = { "/qnaBoard/qnaPost" })
public class QnAPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnAPostServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	System.out.println("게시글 번호 : " + no);
    	
    	Board board = new BoardService().getBoardByNoQ(no);
    	
    	System.out.println(board);
    	
    	request.setAttribute("board", board);
    	request.getRequestDispatcher("/views/board/qnaPost.jsp")
		       .forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
