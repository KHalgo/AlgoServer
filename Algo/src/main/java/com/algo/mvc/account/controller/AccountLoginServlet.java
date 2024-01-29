package com.algo.mvc.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.account.model.service.UsersService;
import com.algo.mvc.account.model.vo.Users;

@WebServlet(name = "accountLogin", urlPatterns = { "/views/account/login" })
public class AccountLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountLoginServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/account/login.jsp")
		.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String input_id = request.getParameter("input_id");
		String input_pass = request.getParameter("input_pass");
		
		System.out.println(input_id + " " + input_pass);
		
		Users loginMember = new UsersService().login(input_id, input_pass);

		System.out.println(loginMember);
		
		if (loginMember != null) {
			HttpSession session = request.getSession();

			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			// 1. 공용으로 사용하는 에러 메시지를 출력할 페이지에 전달할 메시지와 메시지 출력 후 이동할 페이지를 request 객체에 저장한다.
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다.");
			request.setAttribute("location", "/views/account/login");

			// 2. request 객체의 데이터를 유지해서 에러 메시지를 전달하기 위해 forward를 실행한다.
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}

	}

}
