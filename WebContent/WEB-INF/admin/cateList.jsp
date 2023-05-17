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
<title>Category List</title>
<link rel="stylesheet" href="${path1 }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<h2>카테고리 리스트</h2>
			<hr>
			<div class="btn-group">
				<a href="${path1 }/GetCategoryAll.do?" class="btn btn-default">전체</a>
				<a href="${path1 }/GetCategory.do?categroup=보관/정리/수납" class="btn btn-default">보관/정리/수납</a>
				<a href="${path1 }/GetCategory.do?categroup=청소" class="btn btn-default">청소</a>
				<a href="${path1 }/GetCategory.do?categroup=거실/잡화" class="btn btn-default">거실/잡화</a>
				<a href="${path1 }/GetCategory.do?categroup=욕실" class="btn btn-default">욕실 </a>
			</div>
			<hr>
			<table class="table">
				<thead>
					<tr><th>연번</th><th>카테고리번호</th><th>카테고리 그룹명</th><th>카테고리 이름</th></tr>
				</thead>
				<tbody>
					<c:forEach var="cate" items="${cateList }" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>
							<a href="${path1 }/GetCategoryDetailPlist.do?cate=${cate.cate }">${cate.cate }</a>
						</td>
						<td>${cate.categroup }</td>
						<td>${cate.catename }</td>
						<td><a href="DeleteCategory.do?catecode=${cate.cate }" class="btn btn-danger">카테고리 삭제</a></td>
					</tr>
					</c:forEach>
					<c:if test="${empty cateList }">
					<tr>
						<td colspan="4">카테고리 목록이 존재하지 않습니다.</td>
					</tr>
					</c:if>	
				</tbody>
			</table>
			<c:if test="${!empty sid }">
			<div class="btn-group">
				<a href="${path1 }/InsertCategory.do" class="btn btn-primary">카테고리 등록</a>
			</div>
			</c:if>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>