package com.algo.mvc.account.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.account.model.service.UsersService;
import com.google.gson.Gson;

@WebServlet("/AccountNickCheckServlet")
public class AccountNickCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountNickCheckServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String userNick = request.getParameter("userNick");
    	Map<String, Boolean> map = new HashMap<>();
    	
    	
    	System.out.println(userNick);
    	
    	map.put("duplicate", new UsersService().isDuplicateNick(userNick));
    	
    	response.setContentType("application/json;charset=utf-8");
    	
    	new Gson().toJson(map, response.getWriter());
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
