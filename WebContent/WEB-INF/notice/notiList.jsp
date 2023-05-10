<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_noti_lst" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Notice_list</title>
<link rel="stylesheet" href="${path_noti_lst }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2 class="title">공지사항</h2>
		<table class="table">
			<thead>
				<tr><th>연번</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
			</thead>
			<tbody>
				<c:forEach var="noti" items="${notiList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><a href="${path_noti_lst }/GetNotice.do?idx=${noti.idx }">${noti.title }</a></td>
					<td>${noti.author }</td>
					<td>
						<fmt:parseDate var="resdate" value="${noti.resdate }" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
					</td>
					<td>${noti.readcnt }</td>
				</tr>
				</c:forEach>
				<c:if test="${empty notiList }">
					<tr>
						<td colspan="5">공지사항이 존재하지 않습니다.</td>
					</tr>
				</c:if>	
			</tbody>
		</table>
		<div class="btn btn-group">
			<a href="${path_noti_lst }/InsertNotice.do" class="btn btn-primary">글 등록</a>
		</div>
	</div>
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>