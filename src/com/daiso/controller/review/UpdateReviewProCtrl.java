package com.daiso.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Review;
import com.daiso.model.ReviewDAO;
import com.daiso.model.SalesDAO;

@WebServlet("/UpdateReviewPro.do")
public class UpdateReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Review rev = new Review();
		ReviewDAO rdao = new ReviewDAO();

		rev.setRnum(request.getParameter("rnum"));
		rev.setRcom(request.getParameter("rcom"));
		rev.setRpoint(Integer.parseInt(request.getParameter("rpoint")));
		
		int cnt = rdao.updateReview(rev);
		
		if(cnt>0){ //리뷰 수정 성공
			String msg = "구매 후기가 수정되었습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("ReviewDetail.do?rnum="+rev.getRnum());
		} else { //수정이 성공하면 글 목록으로 이동
			response.sendRedirect("UpdateReview.do?onum="+request.getParameter("onum"));
		}
	}
}