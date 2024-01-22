package com.algo.mvc.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.service.CompanyService;

@WebServlet(name = "companyList", urlPatterns = { "/companyReview/list" })
public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompanyListServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int listCount = 0;
    	PageInfo pageInfo = null;
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
    		page = 1;
    	}
    	
    	listCount = new CompanyService().getCompanyCount();
		pageInfo = new PageInfo(page, 5, listCount, 12);
    	
		request.setAttribute("pageInfo", pageInfo);
    	request.getRequestDispatcher("/views/companyReview/list.jsp")
		.forward(request, response);
	}
	

}
