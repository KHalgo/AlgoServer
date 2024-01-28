package com.algo.mvc.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.cscenter.model.vo.Cscenter;
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
    		String path = getServletContext().getRealPath("/resources/upload/talkBoard");
    		
    		int maxSize = 10485760;

    		String encoding = "UTF-8";
    		
    		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    		
    		Cscenter cscenter = new Cscenter();
    		
    		cscenter.setCsTitle(mr.getParameter("csTitle"));
    		cscenter.setCsContent(mr.getParameter("csContent"));
    		cscenter.setCsCategory(mr.getParameter("csCategoey"));
		}
	}

}
