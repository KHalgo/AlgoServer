package com.algo.mvc.board.controller;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.board.model.dao.BoardDao;
import com.algo.mvc.board.model.service.BoardService;
import com.algo.mvc.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet(name = "talkWrite", urlPatterns = { "/talkBoard/talkWrite" })
public class TalkWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TalkWriteServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
    		request.getRequestDispatcher("/views/board/talkWrite.jsp")
    			   .forward(request, response);
		} else {
			request.setAttribute("msg", "로그인 후 이용해 주세요.");
			request.setAttribute("location", "/views/account/login");
			request.getRequestDispatcher("/views/common/msg.jsp")
				   .forward(request, response);
		}

	}

    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
    		// 파일이 저장될 경로
    		String path = getServletContext().getRealPath("/resources/upload/talkBoard");
    		
    		// 파일의 최대 사이즈(10MB)
    		int maxSize = 10485760;

    		// 파일 인코딩 설정
    		String encoding = "UTF-8";
    		
    		// DefaultFileRenamePolicy : 중복되는 파일 이름 뒤에 1~9999 붙인다.
    		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    		
    		Board board = new Board();
    		
    		// 게시글 작성자의 ID 값
    		board.setWriterId(loginMember.getUserId());
    		
    		// 폼 파라미터로 넘어온 값들
    		board.setPostTitle(mr.getParameter("title"));
    		board.setPostContent(mr.getParameter("content"));
    		board.setSmallCategoryId(mr.getParameter("category"));
    		
    		// 파일에 대한 정보
    		board.setPostFile1(mr.getOriginalFileName("upfile1"));
    		board.setPostFile1(mr.getFilesystemName("upfile1"));
    		
    		board.setPostFile2(mr.getOriginalFileName("upfile2"));
    		board.setPostFile2(mr.getFilesystemName("upfile2"));
    		
    		board.setPostFile3(mr.getOriginalFileName("upfile3"));
    		board.setPostFile3(mr.getFilesystemName("upfile3"));
    		
    		board.setPostFile4(mr.getOriginalFileName("upfile4"));
    		board.setPostFile4(mr.getFilesystemName("upfile4"));
    		
    		
    		int result = new BoardService().save(board);  
    		
    		if (result > 0) {
    			// 게시글 등록 성공
    			request.setAttribute("msg", "게시글 등록이 완료되었습니다.");
    			request.setAttribute("location", "/talkBoard/");
    		} else {
    			// 게시글 등록 실패
    			request.setAttribute("msg", "게시글 등록에 실패하였습니다.");
    			request.setAttribute("location", "/talkBoard/talkWrite");
    		}
    		
		} else {
			request.setAttribute("msg", "로그인 후 작성해 주세요.");
			request.setAttribute("location", "/views/account/login");
		}
    	// 가장 마지막에 포워딩
    	request.getRequestDispatcher("/views/common/msg.jsp")
    		   .forward(request, response);
    }

}
