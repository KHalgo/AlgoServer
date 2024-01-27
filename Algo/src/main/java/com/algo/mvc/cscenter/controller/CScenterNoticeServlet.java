package com.algo.mvc.cscenter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.common.util.PageInfo;
import com.algo.mvc.cscenter.model.service.CscenterService;
import com.algo.mvc.cscenter.model.vo.Cscenter;


@WebServlet(name = "cscenterNotice", urlPatterns = { "/cscenter/notice" })
public class CScenterNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CScenterNoticeServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int page = 0;
    	int listCount = 0;
    	PageInfo pageInfo = null;
    	List<Cscenter> list = null;
    	
    	try {    		
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
			page = 1;
		}
    	
    	listCount = new CscenterService().getCscenterCount();
    	pageInfo = new PageInfo(page, 5, listCount, 10);    	
    	list = new CscenterService().getBoardList(pageInfo);
    	
//		System.out.println("list + : " + list);
//		System.out.println("list.size() + : " + list.size());
    	
    	request.setAttribute("pageInfo", pageInfo);
    	request.setAttribute("list", list);
    	
    	request.getRequestDispatcher("/views/cscenter/notice.jsp")
    		   .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
