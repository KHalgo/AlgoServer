package com.algo.mvc.cscenter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cscenterNoticeDetail", urlPatterns = { "/cscenter/noticeDetail" })
public class CScenterNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CScenterNoticeDetailServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/cscenter/noticeDetail.jsp")
    		   .forward(request, response);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
