package com.daiso.controller.admin;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

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

@WebServlet("/AdminPurchasedList.do")
public class AdminPurchasedListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesDAO rdao = new SalesDAO();
		ArrayList<SalesVO> sList = rdao.getSalesList();
		ProductDAO pdao = new ProductDAO();
		for(SalesVO sale : sList){
			Product pro = pdao.getProduct(sale.getPcode()); 
			sale.setPname(pro.getPname());
		}
		//사용자 정보 로딩
		UserDAO udao = new UserDAO();
		
		for(SalesVO sale : sList){
			User1 user = new User1();
			try {
				user = udao.myInfo(sale.getId());
			} catch (InvalidKeyException | NoSuchPaddingException
					| NoSuchAlgorithmException | InvalidKeySpecException
					| InvalidAlgorithmParameterException | BadPaddingException
					| IllegalBlockSizeException e) {
				e.printStackTrace();
			}
			sale.setUsername(user.getUname());
		}
		request.setAttribute("sList", sList);
		//디스패치로 view를 생성하여 proList.jsp로 요청 받은 proList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/purchasedList.jsp");
		view.forward(request, response);
	}
}