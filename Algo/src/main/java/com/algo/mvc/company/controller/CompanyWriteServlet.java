package com.algo.mvc.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.company.model.service.CompanyService;
import com.algo.mvc.company.model.vo.Company;
import com.algo.mvc.company.model.vo.CompanyComment;

@WebServlet(name = "companyWrite", urlPatterns = { "/companyReview/write" })
public class CompanyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CompanyWriteServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Users loginMember = (Users)session.getAttribute("loginMember");
    	
    	int industryID = Integer.parseInt(request.getParameter("industryID"));
    	Company company =new CompanyService().getCompanyByID(industryID);
    	
    	request.setAttribute("company", company);
    	
    	if(loginMember != null) {
    		request.getRequestDispatcher("/views/companyReview/write.jsp")
    		.forward(request, response);
    	} else {
    		request.setAttribute("msg", "로그인 후 작성해 주세요.");
    		request.setAttribute("location", "/views/account/login.jsp");
    		request.getRequestDispatcher("/views/common/msg.jsp")
    		.forward(request, response);	
    	}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Users loginMember = (Users)session.getAttribute("loginMember");
    	
    	int industryID = Integer.parseInt(request.getParameter("industryID"));    	
    	Company company = new CompanyService().getCompanyByID(industryID);
    	request.setAttribute("company", company);
    	
    	if(loginMember != null) {
    		CompanyComment comment = new CompanyComment();
    		
    		//작성자의 닉네임 가져오기
    		comment.setUserID(loginMember.getUserId());
    		comment.setIndustryID(industryID);
    		
    		//작성자의 평점 가져오기
    		comment.setBaseRate(Integer.parseInt(request.getParameter("inputStarRate1")));
    		comment.setDetailRate1(Integer.parseInt(request.getParameter("inputStarRate2")));
    		comment.setDetailRate2(Integer.parseInt(request.getParameter("inputStarRate3")));
    		comment.setDetailRate3(Integer.parseInt(request.getParameter("inputStarRate4")));
    		comment.setDetailRate4(Integer.parseInt(request.getParameter("inputStarRate5")));
    		
    		//작성자의 한줄평 가져오기
    		comment.setPostComment(request.getParameter("comWrite"));
    		
    		int result = new CompanyService().save(comment);
    		
    		if(result > 0) {
    			//게시물 등록 성공
    			request.setAttribute("msg", "게시물 등록 성공");
    			request.setAttribute("location", "/companyReview/list");
    		} else {
    			//게시물 등록 실패
    			request.setAttribute("msg", "게시물 등록 실패");
    			request.setAttribute("location", "/companyReview/list");
    		}
    	} else {
    		request.setAttribute("msg", "로그인 후 작성해 주세요.");
    		request.setAttribute("location", "/views/account/login.jsp");
    	}
    	request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);	

    }

}
