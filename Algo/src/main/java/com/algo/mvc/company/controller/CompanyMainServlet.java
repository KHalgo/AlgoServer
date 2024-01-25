package com.algo.mvc.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.company.model.service.CompanyService;
import com.algo.mvc.company.model.vo.Company;
import com.algo.mvc.company.model.vo.CompanyComment;

@WebServlet(name = "companyMain", urlPatterns = { "/companyReview" })
public class CompanyMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompanyMainServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int page = 0;
		int listCount = 0;
    	PageInfo pageInfo = null;
    	List<Company> list = null;
    	List<Company> list2 = null;
    	Users loginMember = (Users)session.getAttribute("loginMember");
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
    		page = 1;
    	}
    	
    	if(loginMember != null) {
        	listCount = new CompanyService().getCompanyCount();
    		pageInfo = new PageInfo(page, 5, listCount, 5);
    		list = new CompanyService().getCompanyList(pageInfo);
    		list2 = new CompanyService().getLocalCompanyList(pageInfo, loginMember);
        	
    		request.setAttribute("pageInfo", pageInfo);
    		request.setAttribute("list", list);
    		request.setAttribute("list2", list2);
    		request.setAttribute("loginMember", loginMember);
    		
    		System.out.println(list2);
        	
        	request.getRequestDispatcher("/views/companyReview/index.jsp")
    		.forward(request, response);
    	} else {
        	listCount = new CompanyService().getCompanyCount();
    		pageInfo = new PageInfo(page, 5, listCount, 5);
    		list = new CompanyService().getCompanyList(pageInfo);
        	
    		request.setAttribute("pageInfo", pageInfo);
    		request.setAttribute("list", list);
    		
    		request.getRequestDispatcher("/views/companyReview/index.jsp")
    		.forward(request, response);
    	}
    	
    	

	}

}
