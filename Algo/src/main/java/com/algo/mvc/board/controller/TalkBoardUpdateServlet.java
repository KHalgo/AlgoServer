package com.algo.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.board.model.service.BoardService;
import com.algo.mvc.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(name = "talkBoardUpdate", urlPatterns = { "/talkBoard/update" })
public class TalkBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TalkBoardUpdateServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int no = 0;
    	Board board = null;
    	String url = "/views/common/msg.jsp";
    	HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
    		System.out.println("no2 : " + request.getParameter("no"));
			no = Integer.parseInt(request.getParameter("no"));
			board = new BoardService().BoardByNo(no, true);
			
			if(board != null && loginMember.getUserId().equals(board.getWriterId())) {
				request.setAttribute("board", board);
				url = "/views/board/talkUpdate.jsp";
			} else {
				request.setAttribute("msg", "잘못된 접근입니다.");
				request.setAttribute("location", "/talkBoard/");
			}
			
		} else {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.setAttribute("location", "/views/account/login");
		}
    	
    	request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int no = 0;
    	Board board = null;
    	// 로그인한 멤버만 접근할 수 있게
    	HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
    		String path = getServletContext().getRealPath("/resources/upload/talkBoard");
    		int maxSize = 10485760;
    		String encoding = "UTF-8";
    		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    		
			no = Integer.parseInt(mr.getParameter("no"));
			board = new BoardService().BoardByNo(no, true);
			
			if(board != null && loginMember.getUserId().equals(board.getWriterId())) {
				// 수정할 내용 set
				board.setPostTitle(mr.getParameter("title"));
				board.setPostContent(mr.getParameter("content"));
				board.setSmallCategoryId(mr.getParameter("category"));
				board.setPostFile1(mr.getOriginalFileName("upfile1"));		
				
//				System.out.println("제목 :" + mr.getParameter("postTitle"));
//				System.out.println(mr.getParameter("postContent"));
				
				// save 메소드 호출되면 정수값 리턴
				int result = new BoardService().save(board);
				
				if (result > 0 ) {
					// 게시글 수정 성공
					request.setAttribute("msg", "게시글 수정 성공");
					request.setAttribute("location", "/talkBoard/talkPost?no=" + board.getPostNo());
				} else {
					// 게시글 수정 실패
					request.setAttribute("msg", "게시글 수정 실패");
					request.setAttribute("location", "/talkBoard/update?no=" + board.getPostNo());
				}
				
			} else {
				request.setAttribute("msg", "잘못된 접근입니다.");
				request.setAttribute("location", "/talkBoard/");
			}
			
		} else {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.setAttribute("location", "/views/account/login");
		}
    	
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    
    }

}
