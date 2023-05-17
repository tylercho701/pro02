package com.daiso.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.model.ProductDAO;
import com.daiso.vo.CategoryVO;

@WebServlet("/DeleteCategory.do")
public class DeleteCategoryCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String catecode = request.getParameter("catecode");
		
		ProductDAO pdao = new ProductDAO();
		int cnt = pdao.deleteCategory(catecode);
		
		if(cnt>0){
			System.out.println("카테고리 삭제 완료");
			response.sendRedirect("AdminCategoryList.do");
		} else {
			System.out.println("카테고리 삭제 실패");
			response.sendRedirect("AdminCategoryList.do");
		}
	}
}