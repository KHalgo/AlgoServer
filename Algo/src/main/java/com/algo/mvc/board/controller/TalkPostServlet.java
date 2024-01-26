package com.algo.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.board.model.service.BoardService;
import com.algo.mvc.board.model.vo.Board;

@WebServlet(name = "talkPostServlet", urlPatterns = { "/talkBoard/talkPost" })
public class TalkPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TalkPostServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("게시글 번호 : " + no);
		
		Board board = new BoardService().BoardByNo(no);
		
		// ?no= 없는 번호라면 메시지 창 띄우게 하기
		request.setAttribute("board", board);
		
		System.out.println(board);
    	request.getRequestDispatcher("/views/board/talkPost.jsp")
			   .forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
