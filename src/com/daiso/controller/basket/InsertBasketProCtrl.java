package com.daiso.controller.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Basket;
import com.daiso.model.BasketDAO;

@WebServlet("/InsertBasketPro.do")
public class InsertBasketProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Basket bas = new Basket();
		bas.setPcode(request.getParameter("pcode"));
		bas.setId(request.getParameter("id"));
		bas.setAmount(Integer.parseInt(request.getParameter("amount")));
		
		BasketDAO dao = new BasketDAO();
		int cnt = dao.insertBasket(bas);
		
		response.sendRedirect("MyBasket.do?id="+request.getParameter("id"));
	}
}