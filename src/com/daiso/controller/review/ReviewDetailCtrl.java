package com.daiso.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.model.ReviewDAO;
import com.daiso.vo.ReviewVO;

@WebServlet("/ReviewDetail.do")
public class ReviewDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");

		ReviewDAO rdao = new ReviewDAO();
		ReviewVO review = new ReviewVO();
		review = rdao.getReviewDtl(rnum);
		
		request.setAttribute("review", review);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/reviewDetail.jsp");
		view.forward(request, response);
	}
}