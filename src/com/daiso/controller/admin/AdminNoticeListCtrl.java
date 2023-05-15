package com.daiso.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Notice;
import com.daiso.model.NoticeDAO;

@WebServlet("/AdminNoticeList.do")
public class AdminNoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		NoticeDAO ndao = new NoticeDAO();
		ArrayList<Notice> notiList = new ArrayList<Notice>();
		notiList = ndao.noticeListAll();
		request.setAttribute("notiList", notiList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/notiList.jsp");
		view.forward(request, response);
	}
}