package com.algo.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.mvc.board.model.service.BoardService;

@WebServlet(name = "qnaBoardDelete", urlPatterns = { "/qnaBoard/delete" })
public class QnaBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnaBoardDeleteServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 로그인 체크 & 본인 게시글 여부 확인    	
    	int no = 0;
    	int result = 0;

    	no = Integer.parseInt(request.getParameter("no"));
    	result = new BoardService().deleteQ(no);

    	if (result > 0) {
			// 삭제 성공
    		request.setAttribute("msg", "게시글 삭제 성공");
    		request.setAttribute("location", "/qnaBoard/");
		} else {
			// 삭제 실패
			request.setAttribute("msg", "게시글 삭제 실패");
			request.setAttribute("location", "/qnaBoard/qnaPost?no=" + no);
		}

    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
