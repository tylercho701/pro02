package com.daiso.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Product;
import com.daiso.model.ProductDAO;

@WebServlet("/ProductList.do")
public class GetProductListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> proList = new ArrayList<Product>();
		HashMap<String, String> cateMap = new HashMap<String, String>();
		if(cate==null){
			proList = dao.getProductList();
			cate = "0101";
			cateMap.put("catename", "전체");
		} else {
			proList = dao.getCateProductList(cate);
			cateMap = dao.getCategory(cate);
		}
		
		request.setAttribute("proList", proList);
		request.setAttribute("cateMap", cateMap);
		
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/product/proList.jsp");
		view.forward(request, response);	
	}
}