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
import com.algo.mvc.board.model.vo.Reply;

@WebServlet(name = "tallkReplyServlet", urlPatterns = { "/tallkBoard/reply" })
public class TallkReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TallkReplyServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int result = 0;
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String content = request.getParameter("content");
    	HttpSession session = request.getSession(false);
    	Users loginMember = session != null ? (Users)session.getAttribute("loginMember") : null;
    	
    	if(loginMember != null) {
    		Reply reply = new Reply();
    		
    		reply.setPostNo(postNo);
    		reply.setWriterId(loginMember.getUserId());
    		reply.setCommentContent(content);
    		
    		result = new BoardService().saveReply(reply);
    		
    		if(result > 0) {
    			request.setAttribute("msg", "댓글 등록 성공");
    			request.setAttribute("location", "/talkBoard/talkPost?no=" + postNo);
    		} else {
    			request.setAttribute("msg", "댓글 등록 실패");
    			request.setAttribute("location", "/talkBoard/talkPost?no=" + postNo);
    		}
    	
    	} else {
    		request.setAttribute("msg", "로그인 후 사용할 수 있습니다.");
     		request.setAttribute("location", "/talkBoard/talkPost?no=" + postNo);
    	}
    	
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    	
    }

}
