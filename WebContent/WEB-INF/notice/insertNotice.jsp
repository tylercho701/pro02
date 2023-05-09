<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_insno" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Notice_Insert</title>
<link rel="stylesheet" href="${path_insno }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content" style="width:960px; padding-top:30px; margin:30px auto; border-top:3px solid #333; min-height:500px;">
			<div class="container-fluid">
				<h2 class="title">공지사항_등록</h2>
				<form action="${path_insno }/InsertNoticePro.do" method="post" enctype="multipart/form-data">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="title">제목</label></th>
								<td>
									<input type="hidden" name="author" id="author" value="${sid }">
									<input type="text" name="title" id="title" maxlength="100" placeholder="100자 이내 작성 가능" required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="content">내용</label></th>
								<td><textarea cols="100" rows="10" id="content" name="content" required placeholder="1000자 이내 작성 가능"></textarea></td>
							</tr>
							<tr>
								<th><label for="file1">첨부파일</label></th>
								<td><input type="file" id="file1" name="file1"></td>
							</tr>
							<tr>
								<td colspan="3">
									<input type="submit" class="btn btn-primary" value="글쓰기">
									<a href="${path_insno }/NoticeList.do" class="btn btn-primary">글 목록</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>