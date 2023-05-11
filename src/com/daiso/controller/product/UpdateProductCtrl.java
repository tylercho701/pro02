package com.daiso.controller.product;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Product;
import com.daiso.model.ProductDAO;

@WebServlet("/UpdateProduct.do")
public class UpdateProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		String msg = "관리자 권한으로 상품 정보를 수정합니다.";
		request.setAttribute("msg", msg);
		
		ProductDAO dao = new ProductDAO();
		Product pro = dao.getProduct(pcode); 
		
		//카테고리 코드를 저장하여 dao에서 처리한 후 해당 카테고리명을 로딩
		String cate = pro.getCategory();	 
		HashMap<String, String> cateMap = dao.getCategory(cate);
		
		request.setAttribute("pro", pro);	//한 개의 상품 정보
		request.setAttribute("cateMap", cateMap);	//카테고리 정보
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/product/proUpdate.jsp");
		view.forward(request, response);
	}
}