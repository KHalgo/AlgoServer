package com.algo.mvc.board.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		// 쿠키에 조회한 이력이 있는지 확인
		Cookie[] cookies = request.getCookies();
		String boardHistory = ""; // 조회한 게시글 번호를 저장하는 변수
		boolean hasRead = false; // 읽은 글이면 true, 안 읽었으면 false
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				//boardHistory인 쿠키 값을 찾기
				if (cookie.getName().equals("boardHistory")) {
					boardHistory = cookie.getValue(); // 현재 저장된 값 대입
					
					if(boardHistory.contains("|" + no + "|")) {
						// 읽은 게시글
						hasRead = true;
						
						break;
					}
				}
			}
		}
		
		// 읽지 않은 게시글이면 cookie에 기록
		if(!hasRead) {
			Cookie cookie = new Cookie("boardHistory", boardHistory + "|" + no + "|");
			
			cookie.setMaxAge(-1); // 브라우저 종료시 삭제
			response.addCookie(cookie);
		}
		
		
		System.out.println("게시글 번호 : " + no);
		
		
		Board board = new BoardService().BoardByNo(no, hasRead);
		
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
