package com.algo.mvc.mypage.controller;

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
import com.algo.mvc.mypage.model.service.InquiryService;
import com.algo.mvc.mypage.model.vo.Inquiry;

@WebServlet(name = "myPageInquiryLog", urlPatterns = { "/myPage/inquiryLog" })
public class MyPageInquiryLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageInquiryLogServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	HttpSession session = request.getSession();
//    	Users loginMember = (Users)session.getAttribute("loginMember");
//    	if(loginMember != null) {
//    		request.getRequestDispatcher("/views/myPage/inquiryLog.jsp")
//    		.forward(request, response);
//    	} else {
//    		request.setAttribute("msg", "로그인 후 작성해 주세요.");
//    		request.setAttribute("location", "/views/account/login.jsp");
//    		request.getRequestDispatcher("/views/common/msg.jsp")
//    		.forward(request, response);	
//    	}
    	
    	int page = 0;
    	int listCount = 0;
    	PageInfo pageInfo = null;
    	List<Inquiry> list = null;
    	
    	try {    		
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
			page = 1;
		}
    	
    	listCount = new InquiryService().getInquiryCount();
    	pageInfo = new PageInfo(page, 5, listCount, 10);    	
    	list = new InquiryService().getinquiryList(pageInfo);
    	
    	request.setAttribute("pageInfo", pageInfo);
    	request.setAttribute("list", list);
    	
    	int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
    	
    	Inquiry inquiry = new InquiryService().getInquiryByNo(inquiryNo);
    	
    	System.out.println(inquiry);
    	
    	request.setAttribute("inquiry", inquiryNo);
    	
    	
		request.getRequestDispatcher("/views/myPage/inquiryLog.jsp")
		.forward(request, response);
    	
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
