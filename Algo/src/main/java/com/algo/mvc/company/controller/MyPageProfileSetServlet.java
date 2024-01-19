package com.algo.mvc.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myPageProfileSet", urlPatterns = { "/myPage/profileSet" })
public class MyPageProfileSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageProfileSetServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/myPage/profileSet.jsp")
		.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
