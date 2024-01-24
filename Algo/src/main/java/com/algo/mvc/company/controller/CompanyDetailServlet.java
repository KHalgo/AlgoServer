package com.algo.mvc.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.service.CompanyCommentService;
import com.algo.mvc.company.model.service.CompanyService;
import com.algo.mvc.company.model.vo.Company;
import com.algo.mvc.company.model.vo.CompanyComment;

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
    	
    	int page = 0;
		int listCount = 0;
    	PageInfo pageInfo = null;
    	List<CompanyComment> list = null;
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
    		page = 1;
    	}
    	
    	listCount = new CompanyCommentService().getCompanyCommentCount(industryID);
		pageInfo = new PageInfo(page, 5, listCount, 3);
		list = new CompanyCommentService().getCompanyCommentList(pageInfo, industryID);
    	
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
    	
		System.out.println(list);
    	request.getRequestDispatcher("/views/companyReview/companyDetail.jsp")
		.forward(request, response);
	}
}
