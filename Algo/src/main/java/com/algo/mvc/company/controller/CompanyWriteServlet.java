package com.algo.mvc.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.company.model.service.CompanyService;
import com.algo.mvc.company.model.vo.Company;

@WebServlet(name = "companyWrite", urlPatterns = { "/companyReview/write" })
public class CompanyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CompanyWriteServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int industryID = Integer.parseInt(request.getParameter("industryID"));
    	
    	Company company =new CompanyService().getCompanyByID(industryID);
    	
    	request.setAttribute("company", company);
    	
    	request.getRequestDispatcher("/views/companyReview/write.jsp")
		.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
//    	Company company = new Company();
    	int industryID = Integer.parseInt(request.getParameter("industryID"));    	
    	Company company =new CompanyService().getCompanyByID(industryID);
    	request.setAttribute("company", company);
    	
    	System.out.println(request.getParameter("comWrite"));
    }

}
