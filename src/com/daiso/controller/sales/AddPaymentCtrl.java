package com.daiso.controller.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Order1;
import com.daiso.dto.Payment;
import com.daiso.model.SalesDAO;

@WebServlet("/AddPayment.do")
public class AddPaymentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int amount = Integer.parseInt(request.getParameter("amount"));
		String id = request.getParameter("id");
		String pcode = request.getParameter("pcode");
		String bnum = request.getParameter("bnum");
		String category = request.getParameter("category");
		
		Payment pay = new Payment();
		Order1 order = new Order1();
		SalesDAO dao = new SalesDAO();
		
		order.setOnum(dao.getOcodeGenerator());
		order.setId(id);
		order.setPcode(pcode);
		order.setAmount(amount);
		order.setPrice(Integer.parseInt(request.getParameter("payamount")));
		order.setDtel(request.getParameter("tel"));
		order.setDaddr(request.getParameter("address1")+" "+request.getParameter("address2"));
		order.setDstatus("배송전");
		order.setDname("");
		order.setDcode("");

		pay.setPnum(dao.getPnumGenerator());
		pay.setId(request.getParameter("id"));
		pay.setOnum(order.getOnum());
		pay.setPtype(request.getParameter("ptype"));
		pay.setPtnum(request.getParameter("ptnum"));
		pay.setPprice(Integer.parseInt(request.getParameter("payamount")));
		
		int cnt = dao.addSales(order, pay, bnum);
		
		if(cnt>=3){
			System.out.println("트랜잭션 처리 성공");
			response.sendRedirect("MysalesList.do?id="+request.getParameter("id"));
		} else {
			System.out.println("트랜잭션 처리 실패" + cnt);
			response.sendRedirect("AddSales.do?bnum="+bnum+"&pcode="+pcode+"&amount="+amount+"&id="+id);
		}
	}
}