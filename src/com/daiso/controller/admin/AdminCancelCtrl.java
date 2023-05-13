package com.daiso.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.model.SalesDAO;
import com.daiso.vo.SalesVO;

@WebServlet("/AdminCancel.do")
public class AdminCancelCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String onum = request.getParameter("onum");
		
		SalesDAO dao = new SalesDAO();
		SalesVO sale = dao.getSales(onum);
		String pcode = sale.getPcode();
		int amount = sale.getAmount();
		
		int cnt = dao.cancelSales(onum, pcode, amount);
		
		if(cnt>=2){
			System.out.println("주문 취소 성공");
			response.sendRedirect("Survey.do");
		} else {
			System.out.println("주문 취소 실패");
			response.sendRedirect("SurveyLoad.do?onum="+onum);
		}
	}
}