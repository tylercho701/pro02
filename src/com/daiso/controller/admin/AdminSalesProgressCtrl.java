package com.daiso.controller.admin;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Product;
import com.daiso.dto.User1;
import com.daiso.model.ProductDAO;
import com.daiso.model.SalesDAO;
import com.daiso.model.UserDAO;
import com.daiso.vo.SalesVO;

@WebServlet("/AdminSalesProgress.do")
public class AdminSalesProgressCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String onum = request.getParameter("onum");
		
		SalesDAO sdao = new SalesDAO();
		ProductDAO pdao = new ProductDAO();
		UserDAO udao = new UserDAO();
		
		//특정 주문정보의 전체 판매+결제 내용 로딩 
		SalesVO sale = sdao.getSales(onum);
		
		//상품명 로딩
		Product pro = pdao.getProduct(sale.getPcode()); 
		sale.setPname(pro.getPname());
		
		//사용자 이름 로딩
		User1 user = new User1();
		try {
			user = udao.myInfo(sale.getId());
			sale.setUsername(user.getUname());
		} catch (InvalidKeyException | NoSuchPaddingException
				| NoSuchAlgorithmException | InvalidKeySpecException
				| InvalidAlgorithmParameterException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("sale", sale);	//구매 정보
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/salesProgress.jsp");
		view.forward(request, response);
	}
}