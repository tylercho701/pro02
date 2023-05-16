<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_rev_lst" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Review_list</title>
<link rel="stylesheet" href="${path_rev_lst }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2 class="title">구매 후기 리스트</h2>
		<table class="table">
			<thead>
				<tr><th>리뷰번호</th><th>상품명</th><th>리뷰내용</th><th>작성자</th><th>작성일</th><th>평점</th></tr>
			</thead>
			<tbody>
				<c:forEach var="rev" items="${reviewList }">
				<tr>
					<td>${rev.rnum }</td>
					<td><a href="${path_rev_lst }/ProductDetail.do?pcode=${rev.pcode }">${rev.pname }</a></td>
					<td><a href="${path_rev_lst }/ReviewDetail.do?rnum=${rev.rnum }">${rev.rcom }</a></td>
					<td>${rev.id }</td>
					<td>
						<fmt:parseDate var="resdate" value="${rev.writtendate }" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
					</td>
					<td>${rev.rpoint }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>