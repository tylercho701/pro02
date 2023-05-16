package com.daiso.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.model.ReviewDAO;
import com.daiso.vo.ReviewVO;

@WebServlet("/AdminReviewList.do")
public class AdminReviewListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ReviewDAO rdao = new ReviewDAO();
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = rdao.getReviewListAll();
		request.setAttribute("reviewList", reviewList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/reviewList.jsp");
		view.forward(request, response);
	}
}