package com.algo.mvc.cscenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.mvc.account.model.vo.Users;
import com.algo.mvc.cscenter.model.service.CscenterService;
import com.algo.mvc.cscenter.model.vo.Cscenter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(name = "cscenterWritter", urlPatterns = { "/cscenter/writter" })
public class CScenterWritterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CScenterWritterServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
    		request.getRequestDispatcher("/views/cscenter/writter.jsp")
    			   .forward(request, response);
		} else {
			request.setAttribute("msg", "로그인 후 이용해 주세요.");
			request.setAttribute("location", "/views/account/login");
			request.getRequestDispatcher("/views/cscenter/writter.jsp")
			.forward(request, response);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	Cscenter cscenter = null;
    	
    	if (loginMember != null) {
    		String path = getServletContext().getRealPath("/resources/upload/talkBoard");
    		int maxSize = 10485760;
    		String encoding = "UTF-8";
    		
    		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    		
			cscenter = new Cscenter();
			
			// 게시글 작성자의 ID 값
			cscenter.setCsWriterId(loginMember.getUserId());
			
			// 폼 파라미터로 넘어온 값들
			cscenter.setCsTitle(mr.getParameter("csTitle"));
			cscenter.setCsCategory(mr.getParameter("csCategory"));
			cscenter.setCsContent(mr.getParameter("csContent"));
			
			int result = new CscenterService().save(cscenter); 
			
			if (result > 0) {
				// 게시글 등록 성공
				request.setAttribute("msg", "게시글 등록이 완료되었습니다.");
				request.setAttribute("location", "/cscenter/");
				} else {
				// 게시글 등록 실패
				request.setAttribute("msg", "게시글 등록에 실패하였습니다.");
				request.setAttribute("location", "/cscenter/writter");
				}
		
			} else {
				request.setAttribute("msg", "로그인 후 작성해 주세요.");
				request.setAttribute("location", "/views/account/login");
			}
		// 가장 마지막에 포워딩
		request.getRequestDispatcher("/views/common/msg.jsp")
	   			.forward(request, response);
	}
}

