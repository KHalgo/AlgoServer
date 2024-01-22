package com.algo.mvc.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myPageChangePwdSuccess", urlPatterns = { "/myPage/changePwd/success" })
public class MyPageChangePwdSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageChangePwdSuccessServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/myPage/changePwdSuccess.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
