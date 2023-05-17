package com.daiso.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertCategory.do")
public class InsertCategoryCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "카테고리를 등록합니다.";
		request.setAttribute("msg", msg);
		
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/cateInsert.jsp");
		view.forward(request, response);
	}
}