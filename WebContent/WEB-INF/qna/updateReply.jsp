<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>답변 글 수정하기</title>
<link rel="stylesheet" href="${path1 }/form_common.css">
<style>
#fileSel1:checked ~ #file1 { display:none; }
#fileSel2:checked ~ #file1 { display:block; }
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>답변 글 수정</h2>
				<p>${msg }</p>
				<form action="${path1 }/UpdateReplyPro.do" method="post" enctype="multipart/form-data">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="title">답변 제목</label></th>
								<td>
									<input type="hidden" name="author" id="author" value="${sid }">
									<input type="hidden" name="qno" id="qno" value="${qn.qno }">
									<input type="text" name="title" id="title" value="${qn.title }" maxlength="98" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="content">답변 글 내용</label></th>
								<td>
									<textarea rows="10" cols="100" name="content" id="content" maxlength="990" title="1000자 내로 작성" class="form-control">${qn.content }</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="답변 수정" class="btn btn-primary">
									<a href="${path1 }/QnaList.do" class="btn btn-primary">글 목록</a>				
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