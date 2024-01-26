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

@WebServlet("/AccountIdCheckServlet")
public class AccountIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountIdCheckServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ID 값을 가져와서 DB에 있는 값인지 확인하고 결과 (JSON)를 응답한다.
    	String userId = request.getParameter("userId");
    	Map<String, Boolean> map = new HashMap<>();
    	
    	
    	System.out.println(userId);
    	
    	map.put("duplicate", new UsersService().isDuplicateId(userId));
    	
    	response.setContentType("application/json;charset=utf-8");
    	
    	new Gson().toJson(map, response.getWriter());
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
