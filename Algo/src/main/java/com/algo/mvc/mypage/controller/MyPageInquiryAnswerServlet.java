package com.algo.mvc.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myPageInquiryAnswer", urlPatterns = { "/myPage/inquiry/answer" })
public class MyPageInquiryAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageInquiryAnswerServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/myPage/inquiryAnswer.jsp")
		.forward(request, response);
	}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
