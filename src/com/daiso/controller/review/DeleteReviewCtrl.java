package com.daiso.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.model.ReviewDAO;

@WebServlet("/DeleteReview.do")
public class DeleteReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");
		ReviewDAO rdao = new ReviewDAO();
		
		int cnt = rdao.deleteReview(rnum);
		if(cnt>0){ //실패하면, 공지사항 글 상세보기로 다시 이동
			String msg = "구매 후기 1건을 삭제하였습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("AdminReviewList.do");
		} else { //삭제 처리가 성공하면, 공지사항 목록으로 이동
			String msg = "구매 후기 삭제에 실패하였습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("AdminReviewList.do");
		}
	}
}
