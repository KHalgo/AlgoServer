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

@WebServlet(name = "cscenterUpdate", urlPatterns = { "/cscenter/update" })
public class CscenterUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CscenterUpdateServlet() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = 0;
    	Cscenter cscenter = null;
    	String url = "/views/common/msg.jsp";
    	HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
			no = Integer.parseInt(request.getParameter("csNo"));
			cscenter = new CscenterService().CscenterByNo(no);
			
			if(cscenter != null && loginMember.getUserId().equals(cscenter.getCsWriterId())) {
				request.setAttribute("cscenter", cscenter);
				url = "/views/cscenter/update.jsp";
			} else {
				request.setAttribute("msg", "잘못된 접근입니다.");
				request.setAttribute("location", "/");
			}
			
		} else {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.setAttribute("location", "/views/account/login");
		}
    	
    	request.getRequestDispatcher(url).forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = 0;
    	Cscenter cscenter = null;
    	// 로그인한 멤버만 접근할 수 있게
    	HttpSession session = request.getSession();
    	Users loginMember = (Users) session.getAttribute("loginMember");
    	
    	if (loginMember != null) {
    		String path = getServletContext().getRealPath("/resources/upload/talkBoard");
    		int maxSize = 10485760;
    		String encoding = "UTF-8";
    		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new DefaultFileRenamePolicy());
    		
			no = Integer.parseInt(mr.getParameter("no"));
			cscenter = new CscenterService().CscenterByNo(no);
			
			if(cscenter != null && loginMember.getUserId().equals(cscenter.getCsWriterId())) {
				// 수정할 내용 set
				cscenter.setCsTitle(mr.getParameter("csTitle"));
				cscenter.setCsContent(mr.getParameter("csContent"));
				cscenter.setCsCategory(mr.getParameter("csCategory"));
				
				// save 메소드 호출되면 정수값 리턴
				int result = new CscenterService().save(cscenter);
				
				if (result > 0 ) {
					// 게시글 수정 성공
					request.setAttribute("msg", "게시글 수정 성공");
					request.setAttribute("location", "/cscenter/talkPost?no=" + cscenter.getCsNo());
				} else {
					// 게시글 수정 실패
					request.setAttribute("msg", "게시글 수정 실패");
					request.setAttribute("location", "/cscenter/update?no=" + cscenter.getCsNo());
				}
				
			} else {
				request.setAttribute("msg", "잘못된 접근입니다.");
				request.setAttribute("location", "/talkBoard/");
			}
			
		} else {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.setAttribute("location", "/views/account/login");
		}
    	
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
