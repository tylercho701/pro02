package com.daiso.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daiso.dto.Notice;
import com.daiso.model.NoticeDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/InsertNoticePro.do")
public class InsertNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/data";
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//1024 byte * 1024 byte = 1024kb * 10 = 10 mega byte
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상에 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String title = "";
		String content = "";
		String author = "";
		String fileName = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1"); // 업로드하고, 업로드된 파일의 이름 얻기
			if (fileName == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일 업로드 실패~!");
			}  // 파일이 업로드 되었을때
			author = multi.getParameter("author");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		noti.setTitle(title);
		noti.setContent(content);
		noti.setFile1(fileName);
		noti.setAuthor(author);
		int cnt = ndao.insertNotice(noti);	
		if(cnt==0){ //글쓰기 실패
			String msg = "공지사항을 글이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			
			//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/insertNotice.jsp");
			view.forward(request, response);
		} else { //글쓰기 성공
			response.sendRedirect("NoticeList.do");
		}
	}
}