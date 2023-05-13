package com.daiso.controller.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.model.SalesDAO;
import com.daiso.vo.SalesVO;

@WebServlet("/CancelPay.do")
public class CancelPayCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String onum = request.getParameter("onum");
		
		SalesDAO dao = new SalesDAO();
		SalesVO sale = dao.getSales(onum);
		String pcode = sale.getPcode();
		int amount = sale.getAmount();
		
		String id = sale.getId();
		
		int cnt = dao.cancelSales(onum, pcode, amount);
		
		if(cnt>=2){
			System.out.println("주문 취소 성공");
			response.sendRedirect("MySalesList.do?id="+id);
		} else {
			System.out.println("주문 취소 실패");
			response.sendRedirect("MySalesList.do?id="+id);
		}
	}
}