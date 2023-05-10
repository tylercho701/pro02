<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_pist" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>Product Registration</title>
<link rel="stylesheet" href="${path_pist }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
	<div class="container-fluid">
		<h2 class="title">새 상품 등록</h2>
		<form action="${path_pist }/InsertProductPro.do" method="post" enctype="multipart/form-data">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="pcode">상품코드</label></th>
						<td><input type="text" name="pcode" id="pcode" required autofocus></td>
					</tr>
					<tr>
						<th><label for="pname">상품명</label></th>
						<td>
							<input type="hidden" name="author" id="author" value="${sid }">
							<input type="text" name="pname" id="pname" placeholder="상품명을 입력하세요." required>
						</td>
					</tr>
					<tr>
						<th><label for="pmeas">상품규격</label></th>
						<td><input type="text" name="pmeas" id="pmeas" placeholder="000*000*000(mm)" required></td>
					</tr>
					<tr>
						<th><label for="price">상품가격</label></th>
						<td><input type="text" name="price" id="price" required></td>
					</tr>
					<tr>
						<th><label for="pcom">상품설명</label></th>
						<td><input type="text" name="pcom" id="pcom"></td>
					</tr>
					<tr>
						<th><label for="amount">상품수량</label></th>
						<td><input type="text" name="amount" id="amount" required></td>
					</tr>
					<tr>
						<th><label for="pic1">메인이미지</label></th>
						<td><input type="text" name="pic1" id="pic1" placeholder="/images/oooo.jpg" required></td>
					</tr>
					<tr>
						<th><label for="pic2">서브이미지1</label></th>
						<td><input type="text" name="pic1" id="pic1" placeholder="/images/oooo.jpg" required></td>
					</tr>
					<tr>
						<th><label for="pic3">서브이미지2</label></th>
						<td><input type="text" name="pic3" id="pic3" placeholder="/images/oooo.jpg" required></td>
					</tr>
					<tr>
						<th><label for="category">카테고리</label></th>
						<td><input type="text" name="category" id="category" placeholder="catecode" required></td>
					</tr>
					<tr>
						<td colspan="10">
							<input type="submit" class="btn btn-primary" value="상품등록">
							<input type="reset" class="btn btn-danger" value="취소">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
		<%@ include file="../ft.jsp" %>
	</div>
</body>
</html>