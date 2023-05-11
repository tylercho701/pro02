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

@WebServlet("/DeleteProduct.do")
public class DeleteProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> proList = dao.getProductList();
		HashMap<String, String> cateMap = new HashMap<String, String>();
		
		cateMap.put("catename", "전체");
		request.setAttribute("proList", proList);
		request.setAttribute("cateMap", cateMap);
		
		String pcode = request.getParameter("pcode");
		
		int cnt = dao.deleteProduct(pcode);
		
		if(cnt==0){
			String msg = "상품 삭제 처리 실패";
			request.setAttribute("msg", msg);
			response.sendRedirect("AdminProductList.do");
		} else {
			String msg = "상품 삭제 완료";
			request.setAttribute("msg", msg);
			response.sendRedirect("AdminProductList.do");
		}
	}
}