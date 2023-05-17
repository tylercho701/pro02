package com.daiso.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Category;
import com.daiso.dto.Product;
import com.daiso.model.ProductDAO;

@WebServlet("/GetCategoryDetailPlist.do")
public class GetCategoryDetailPlistCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProductDAO dao = new ProductDAO();
		Category cateOne = dao.getCategoryOne(cate);
		request.setAttribute("cateOne", cateOne);
		
		ArrayList<Product> pList = dao.getProductListByCate(cate);
		request.setAttribute("pList", pList);
		
		System.out.println(cate);
		System.out.println(cateOne.getCatecode());
		System.out.println(cateOne.getCategroup());
		System.out.println(cateOne.getCatename());
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/cateDetail.jsp");
		view.forward(request, response);
	}
}
