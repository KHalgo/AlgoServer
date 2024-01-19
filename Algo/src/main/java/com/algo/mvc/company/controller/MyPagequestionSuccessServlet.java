package com.algo.mvc.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myPagequestionSuccess", urlPatterns = { "/myPage/question/success" })
public class MyPagequestionSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPagequestionSuccessServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/myPage/question_success.jsp")
		.forward(request, response);
	}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

