package com.algo.mvc.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "memberLogout", urlPatterns = { "/logout" })
public class AccountLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountLogoutServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그아웃 순서

		// 1. 세션을 얻어온다.
		HttpSession session = request.getSession();

		// 2. 세션을 삭제한다.
		session.invalidate();

		// 3. 삭제 후 홈 화면으로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/home");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
