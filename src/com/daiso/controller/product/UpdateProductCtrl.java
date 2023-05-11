package com.daiso.controller.product;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Product;
import com.daiso.model.ProductDAO;
import com.daiso.vo.CategoryVO;

@WebServlet("/UpdateProduct.do")
public class UpdateProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		String msg = "관리자 권한으로 상품 정보를 수정합니다.";
		request.setAttribute("msg", msg);
		
		ProductDAO dao = new ProductDAO();
		Product pro = new Product();
		
		pro = dao.updateProduct(pcode);
		
		String pic1 = pro.getPic1().substring(9); 
		String picpath1 = pro.getPic1().substring(0,8);
		String pic2 = pro.getPic2().substring(9); 
		String picpath2 = pro.getPic2().substring(0,8);
		String pic3 = pro.getPic3().substring(9); 
		String picpath3 = pro.getPic3().substring(0,8);
		
		pic1 = URLEncoder.encode(pic1, "UTF-8");	
		pic2 = URLEncoder.encode(pic2, "UTF-8");	
		pic3 = URLEncoder.encode(pic3, "UTF-8");
		
		String cate = pro.getCategory();
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/product/proUpdate.jsp");
		view.forward(request, response);
	}
}