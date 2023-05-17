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
<title>Category Insert</title>
<link rel="stylesheet" href="${path1 }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<h2>카테고리 등록</h2>
			<form id="insertcate" action="InsertCategoryPro.do" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th>카테고리 대분류</th>
							<td>
								<select id="cate1" name="cate1">
									<option value="01">보관/정리/수납</option>
									<option value="02">청소</option>
									<option value="03">거실/잡화</option>
									<option value="04">욕실</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>카테고리명</th>
							<td>
								<input type="text" id="cate2" name="cate2" required>
							</td>
						</tr>
						<tr>
							<td><input type="submit" class="btn btn-primary" value="카테고리 등록"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>