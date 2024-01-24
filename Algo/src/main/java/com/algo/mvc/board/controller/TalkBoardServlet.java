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


@WebServlet(name = "talkBoard", urlPatterns = { "/talkBoard/" })
public class TalkBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TalkBoardServlet() {
    }


    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int page = 0;
    	int listCount = 0;
    	List<Board> list = null;
    	
    	// 객체 생성
    	PageInfo pageinfo = null;
    	
    	try {
    		// 파라미터는 String타입이라 int 타입으로 받아올거면 형변환 필요    	
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch(NumberFormatException e) {
    		// null 처리 하는 코드도 필요(500 에러)
    		page = 1;
    	}

    	listCount = new BoardService().getBoardCount();	
    	pageinfo = new PageInfo(page, 5, listCount, 20);
    	list = new BoardService().getBoardList(pageinfo);
    	
    	System.out.println(list);
    	
    	
    	// 포워드 하기 전 pageinfo를 PageInfo.jsp로 전달 
    	request.setAttribute("pageInfo", pageinfo);
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("/views/board/talkBoard.jsp")
    		   .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
