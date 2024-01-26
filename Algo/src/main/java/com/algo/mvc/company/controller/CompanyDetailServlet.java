package com.algo.mvc.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    	
    	//게시글 조회수
    	Cookie[] cookies = request.getCookies();
    	String companyHistory= "";
    	boolean hasRead = false;
    	//1.쿠키에 조회한 이력이 있는지 확인
    	if(cookies != null) {
    		for(Cookie cookie : cookies) {
    			if(cookie.getName().equals("companyHistory")) {
    				companyHistory = cookie.getValue();
    				
    				if(companyHistory.contains("|" + industryID + "|")) {
    					hasRead = true;
    					break;
    				}
    			}
    		}
    	}
    	//2. 읽지 않은 게시글이면 cookie에 기록
    	if(!hasRead) {
    		Cookie cookie = new Cookie("companyHistory", companyHistory + "|" + industryID + "|");
    		
    		cookie.setMaxAge(-1); //브라우저 종료시 삭제
    		response.addCookie(cookie);
    	}
    	
    	Company company =new CompanyService().getCompanyByIDRead(industryID, hasRead);
    	
    	request.setAttribute("company", company);
    	
    	int page = 0;
		int listCount = 0;
    	PageInfo pageInfo = null;
    	List<CompanyComment> list = null;
    	CompanyComment bestComment = null;
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
    		page = 1;
    	}
    	
    	listCount = new CompanyCommentService().getCompanyCommentCount(industryID);
		pageInfo = new PageInfo(page, 5, listCount, 3);
		list = new CompanyCommentService().getCompanyCommentList(pageInfo, industryID);
		bestComment = new CompanyCommentService().getCompanyBestComment(industryID);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
		request.setAttribute("bestComment", bestComment);
		
    	
		System.out.println(bestComment.getLike());
    	request.getRequestDispatcher("/views/companyReview/companyDetail.jsp")
		.forward(request, response);
	}
}
