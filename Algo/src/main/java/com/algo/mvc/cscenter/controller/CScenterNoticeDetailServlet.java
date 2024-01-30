package com.algo.mvc.cscenter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.cscenter.model.service.CscenterService;
import com.algo.mvc.cscenter.model.vo.Cscenter;

@WebServlet(name = "cscenterNoticeDetail", urlPatterns = { "/cscenter/noticeDetail" })
public class CScenterNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CScenterNoticeDetailServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int no = Integer.parseInt(request.getParameter("no"));
    	
		Cookie[] cookies = request.getCookies();
		String cscenterHistory = "";
		boolean hasRead = false;
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("cscenterHistory")) {
					cscenterHistory = cookie.getValue();
					
					if(cscenterHistory.contains("|" + no + "|")) {
						hasRead = true;
						break;
					}
				}
			}
		}
		
		if(!hasRead) {
			Cookie cookie = new Cookie("cscenterHistory", cscenterHistory + "|" + no + "|");
			
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
		}
    	
    	Cscenter cscenter = new CscenterService().getCountByNo(no, hasRead);
    	
    	request.setAttribute("cscenter", cscenter);
    	
    	
    	
    	request.getRequestDispatcher("/views/cscenter/noticeDetail.jsp")
    		   .forward(request, response);
    }

}
