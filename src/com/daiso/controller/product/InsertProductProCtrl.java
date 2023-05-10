package com.daiso.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Product;
import com.daiso.model.ProductDAO;

@WebServlet("/InsertProductPro.do")
public class InsertProductProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String pmeas = request.getParameter("pmeas");
		int price = Integer.parseInt(request.getParameter("price"));
		String pcom = request.getParameter("pcom");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String pic1 = request.getParameter("pic1");
		String pic2 = request.getParameter("pic2");
		String pic3 = request.getParameter("pic3");
		String category = request.getParameter("category");
		
		ProductDAO dao = new ProductDAO();
		Product pro = new Product();
		
		pro.setPcode(pcode);
		pro.setPname(pname);
		pro.setPmeas(pmeas);
		pro.setPrice(price);
		pro.setPcom(pcom);
		pro.setAmount(amount);
		pro.setPic1(pic1);
		pro.setPic2(pic2);
		pro.setPic3(pic3);
		pro.setCategory(category);
		
		int cnt = dao.insertProduct(pro);
		
		if(cnt>0){
			response.sendRedirect("ProductDetail.do?pcode="+pcode);
		} else{
			response.sendRedirect("InsertProduct.do");
		}
		
		
		
		
		
		
		
		
		
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/");
		view.forward(request, response);
	}
}