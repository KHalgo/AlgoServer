package com.algo.mvc.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "accountCreateAccountComplete", urlPatterns = { "/account/createAccountComplete" })
public class AccountCreateAccountCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountCreateAccountCompleteServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/account/createAccountComplete.jsp")
		.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
