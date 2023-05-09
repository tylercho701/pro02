package com.daiso.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Main() { super(); }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tester = "조교행";
		
		// 홈 디렉토리
		ServletContext application = request.getServletContext();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		application.setAttribute("realPath", realPath);
		
		// 메인 페이지 포워딩
		request.setAttribute("tester", tester);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		view.forward(request, response);
	}
}