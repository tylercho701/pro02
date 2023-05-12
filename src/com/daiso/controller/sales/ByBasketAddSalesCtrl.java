package com.daiso.controller.sales;

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
import com.daiso.model.UserDAO;

@WebServlet("/ByBasketAddSales.do")
public class ByBasketAddSalesCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		String id = request.getParameter("id");
		
		String bnum = "";
		int amount = 1;
		String bcode = request.getParameter("bnum");
		String pcs = request.getParameter("amount");
		
		ProductDAO dao = new ProductDAO();	 
		UserDAO udao = new UserDAO();
		
		if(bcode!=null && pcs!=null){
			bnum = bcode;
			amount = Integer.parseInt(pcs);
			request.setAttribute("bnum", bnum);
		}

		String msg = "제품을 구매합니다.";
		Product pro = dao.getProduct(pcode);
		User1 user = new User1();
		
		try {
			user = udao.myInfo(id);
		} catch (InvalidKeyException | NoSuchPaddingException
				| NoSuchAlgorithmException | InvalidKeySpecException
				| InvalidAlgorithmParameterException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("user", user);	//구매자 정보
		request.setAttribute("pro", pro);	//한 개의 상품 정보
		request.setAttribute("amount", amount);
		request.setAttribute("id", id);
		request.setAttribute("msg", msg);
		
		//디스패치로 view를 생성하여 addSales.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/sales/addSales.jsp");
		view.forward(request, response);
	}
}