package com.algo.mvc.account.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.account.model.service.UsersService;
import com.algo.mvc.account.model.vo.Sigungu;
import com.google.gson.Gson;


@WebServlet("/sigungu")
public class AccountDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountDemoServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidoId = request.getParameter("sidoId");
		
		List<Sigungu> sigungus = new UsersService().getSigungus(sidoId);
		
    	response.setContentType("application/json;charset=utf-8");
    	
    	new Gson().toJson(sigungus, response.getWriter());
	}

}
