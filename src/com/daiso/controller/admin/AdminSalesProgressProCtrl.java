package com.daiso.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Order1;
import com.daiso.model.SalesDAO;

@WebServlet("/AdminSalesProgressPro.do")
public class AdminSalesProgressProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String onum = request.getParameter("onum");
		Order1 order = new Order1();
		order.setOnum(onum);
		order.setDname(request.getParameter("dname"));
		order.setDcode(request.getParameter("dcode"));
		order.setDstatus(request.getParameter("dstatus"));
		
		SalesDAO dao = new SalesDAO();
		int cnt = dao.salesProgressUpdate(order);
		if(cnt>0){
			response.sendRedirect("AdminSalesList.do");
		} else {
			response.sendRedirect("AdminSalesProgress.do?onum="+onum);
		}
	}
}
