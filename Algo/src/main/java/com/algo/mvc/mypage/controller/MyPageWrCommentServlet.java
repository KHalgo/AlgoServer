package com.algo.mvc.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myPageWrComment", urlPatterns = { "/myPage/wrComment" })
public class MyPageWrCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageWrCommentServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/myPage/wr_comment.jsp")
		.forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
