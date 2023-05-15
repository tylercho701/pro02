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

@WebServlet("/InsertReviewPro.do")
public class InsertReviewProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Review rev = new Review();
		ReviewDAO rdao = new ReviewDAO();
		String rnum = rdao.getRnumGenerator();
		rev.setRnum(rnum);
		rev.setId(request.getParameter("id"));
		rev.setOnum(request.getParameter("onum"));
		rev.setRcom(request.getParameter("rcom"));
		rev.setRpoint(Integer.parseInt(request.getParameter("rpoint")));
		
		
		int cnt = rdao.insertReview(rev);

		
		SalesDAO sdao = new SalesDAO();
		cnt = cnt + sdao.okSales(rev.getOnum());
		
		if(cnt>1){ //리뷰 등록 성공
			String msg = "구매 후기가 등록되었습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("MySalesList.do?id="+rev.getId());
		} else { //수정이 성공하면 글 목록으로 이동
			response.sendRedirect("InsertReview.do?onum="+rev.getOnum());
		}
	}
}