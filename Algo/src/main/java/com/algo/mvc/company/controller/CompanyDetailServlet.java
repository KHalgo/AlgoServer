package com.algo.mvc.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.company.model.service.CompanyService;
import com.algo.mvc.company.model.vo.Company;

@WebServlet(name = "companyDetail", urlPatterns = { "/companyReview/companyDetail" })
public class CompanyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompanyDetailServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int industryID = Integer.parseInt(request.getParameter("industryID"));
    	
    	Company company =new CompanyService().getCompanyByID(industryID);
    	
    	request.setAttribute("company", company);
    	
    	request.getRequestDispatcher("/views/companyReview/companyDetail.jsp")
		.forward(request, response);
	}
}
