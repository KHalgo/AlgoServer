package com.algo.mvc.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.account.model.service.UsersService;
import com.algo.mvc.account.model.vo.Users;

@WebServlet(name = "accountCreateAccount", urlPatterns = { "/views/account/createAccount" })
public class AccountCreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountCreateAccountServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/account/createAccount.jsp")
		.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Users users = new Users();
    	
    	
    	
    	users.setAgrMarketing(request.getParameter("agrMarketing"));
    	users.setAgrSms(request.getParameter("agrSms"));
    	users.setAgrEmail(request.getParameter("agrEmail"));
    	users.setAgrLocation(request.getParameter("agrLocation"));
    	
    	users.setUserName(request.getParameter("userName"));
//    	users.setUserBirthday(request.getParameter("userBirthday"));
    	users.setUserId(request.getParameter("userId"));
    	users.setUserPw(request.getParameter("userPw"));
    	users.setUserNick(request.getParameter("userNick"));
		users.setUserPhone(request.getParameter("userPhone"));
		users.setUserEmail(request.getParameter("userEmail"));
		users.setSido(request.getParameter("sido"));
		users.setSigungu(request.getParameter("sigungu"));
    	
		System.out.println(users);
		
		int result = new UsersService().save(users);

		request.getRequestDispatcher("/views/account/createAccountComplete.jsp").forward(request, response);

		System.out.println(result);
	}

}
