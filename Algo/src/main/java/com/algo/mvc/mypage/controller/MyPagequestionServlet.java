package com.algo.mvc.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.mypage.model.service.InquiryService;
import com.algo.mvc.mypage.model.vo.Inquiry;

@WebServlet(name = "myPagequestion", urlPatterns = { "/myPage/question" })
public class MyPagequestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPagequestionServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
    	request.getRequestDispatcher("/views/myPage/question.jsp")
		.forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
