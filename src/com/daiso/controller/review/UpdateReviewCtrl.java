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

@WebServlet("/UpdateReview.do")
public class UpdateReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");
		String msg = "구매 후기를 수정합니다.";
		
		ReviewVO review = new ReviewVO();
		ReviewDAO rdao = new ReviewDAO();
		
		review = rdao.getReviewDtl(rnum);
		
		request.setAttribute("msg", msg);
		request.setAttribute("review", review);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/updateReview.jsp");
		view.forward(request, response);
	}
}