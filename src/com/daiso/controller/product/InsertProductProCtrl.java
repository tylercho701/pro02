package com.daiso.controller.product;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Product;
import com.daiso.model.ProductDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/InsertProductPro.do")
public class InsertProductProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/product/images";
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//1024 byte * 1024 byte = 1024kb * 10 = 10 mega byte
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		int n = 0;
		String[] fileName = new String[3];
		String[] oriFileName = new String[3];
		
		ProductDAO dao = new ProductDAO();
		Product pro = new Product();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());	
			
			Enumeration<?> files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement();
				fileName[n] = multi.getFilesystemName(file);
				//중복된 파일을 업로드할 경우 파일명이 바뀐다.
				oriFileName[n] = multi.getOriginalFileName(file);
				n++;
			}
			
			if (fileName[0] == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일1 업로드 실패~!");
			} else {
				pro.setPic3("./images/"+fileName[0]);
			}
			
			if (fileName[1] == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일2 업로드 실패~!");
			} else {
				pro.setPic2("./images/"+fileName[1]);
			}

			if (fileName[2] == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일3 업로드 실패~!");
			} else {
				pro.setPic1("./images/"+fileName[2]);
			}

			pro.setPcode(multi.getParameter("pcode"));
			pro.setPname(multi.getParameter("pname"));
			pro.setPmeas(multi.getParameter("pmeas"));
			pro.setPrice(Integer.parseInt(multi.getParameter("price")));
			pro.setPcom(multi.getParameter("pcom"));
			pro.setAmount(Integer.parseInt(multi.getParameter("amount")));
			pro.setCategory(multi.getParameter("cate"));

		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		int cnt = dao.insertProduct(pro);
		
		if(cnt==0){ //상품 등록 실패
			String msg = "상품을 등록하지 못했습니다.";
			request.setAttribute("msg", msg);
			
			//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
			RequestDispatcher view = request.getRequestDispatcher("InsertProduct.do");
			view.forward(request, response);
		} else { //상품등록 성공시 목록으로 가기
			response.sendRedirect("ProductList.do");
		}
	}
}