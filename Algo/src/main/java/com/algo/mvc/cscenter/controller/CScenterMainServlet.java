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


@WebServlet(name = "cscenterMain", urlPatterns = { "/cscenter/" })
public class CScenterMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CScenterMainServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int page = 0;
    	
    	int listCountN = 0;
    	int listCountQ = 0;
    	
    	PageInfo pageInfoN = null;
    	PageInfo pageInfoQ = null;
    	
    	List<Cscenter> listN = null;
    	List<Cscenter> listQ = null;
    	
    	String categoryQ = "QNA";
    	String categoryN = "NOTICE";
    	try {    		
    		page = Integer.parseInt(request.getParameter("page"));
    	} catch (NumberFormatException e) {
			page = 1;
		}
    	
    	listCountN = new CscenterService().getCscenterCount(categoryN);
    	listCountQ = new CscenterService().getCscenterCount(categoryQ);
    	
    	pageInfoN = new PageInfo(page, 5, listCountN, 10);
    	pageInfoQ = new PageInfo(page, 5, listCountQ, 10);
    	
    	listN = new CscenterService().getCscenterList(pageInfoN, categoryN);
    	listQ = new CscenterService().getCscenterList(pageInfoQ, categoryQ);
		
    	request.setAttribute("pageInfoN", pageInfoN);
    	request.setAttribute("pageInfoQ", pageInfoQ);
    	
    	request.setAttribute("listN", listN);
    	request.setAttribute("listQ", listQ);
    	
    	request.getRequestDispatcher("/views/cscenter/index.jsp")
    		   .forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
