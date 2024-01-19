package com.algo.mvc.cscenter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cscenterNotice", urlPatterns = { "/cscenter/notice" })
public class CScenterNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CScenterNoticeServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/cscenter/notice.jsp")
    		   .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
