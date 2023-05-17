<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Category Detail</title>
<link rel="stylesheet" href="${path1 }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<h2>카테고리 상세</h2>
			<form id="modifcatenm" action="updateCateName.do" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th>카테고리 번호</th>
							<td>
								<input type="hidden" id="catecode" name="catecode" value="${cateOne.catecode }">
								<input type="hidden" id="categroup" name="categroup" value="${cateOne.categroup }">
								<input type="text" value="${cateOne.catecode }" readonly>
							</td>
						</tr>
						<tr>
							<th>카테고리 그룹명</th>
							<td>
								<input type="text" value="${cateOne.categroup }" readonly>
							</td>
						</tr>
						<tr>
							<th>카테고리 명</th>
							<td>
								<input type="text" id="catename" name="catename" value="${cateOne.catename }" required>
							</td>
						</tr>
						<tr>
							<td><input type="submit" class="btn btn-primary" value="카테고리명 수정"></td>
						</tr>
					</tbody>
				</table>
			</form>
			<table class="table">
				<thead>
					<tr><th>상품번호</th><th>상품명</th><th>상품설명</th></tr>
				</thead>
				<tbody>
					<c:forEach var="pl" items="${pList }">
						<tr>
							<td>${pl.pcode }</td><td><a href="${path1 }/ProductDetail.do?pcode=${pl.pcode }">${pl.pname }</a></td><td>${pl.pcom }</td>
						</tr>
					</c:forEach> 
				</tbody>
			</table>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>