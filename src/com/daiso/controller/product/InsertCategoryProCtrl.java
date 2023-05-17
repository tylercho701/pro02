package com.daiso.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Category;
import com.daiso.model.ProductDAO;

@WebServlet("/InsertCategoryPro.do")
public class InsertCategoryProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cate1 = request.getParameter("cate1");
		String cate2 = request.getParameter("cate2");
		String categroup = "";
		
		int cnt = 0;
		
		if(cate1.equals("01")){
			categroup = "보관/정리/수납";
		} else if (cate1.equals("02")){
			categroup = "청소";
		} else if (cate1.equals("03")){
			categroup = "거실/잡화";
		} else if (cate1.equals("04")){
			categroup = "욕실";
		}
		
		Category category = new Category();
		ProductDAO pdao = new ProductDAO();
		
		String catecode = pdao.getCatecodeGenerator(cate1);
		category.setCatecode(catecode);
		category.setCategroup(categroup);
		category.setCatename(cate2);
		
		cnt = pdao.insertCategory(category);
		
		if(cnt>0){
			System.out.println("신규 카테고리 등록 성공");
			response.sendRedirect("AdminCategoryList.do");
		} else {
			System.out.println("카테고리 등록 실패");
			response.sendRedirect("AdminCategoryList.do");
		}
	}
}