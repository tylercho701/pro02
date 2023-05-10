<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_gntc" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Notice_Detail</title>
<link rel="stylesheet" href="${path_gntc }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2 class="title">공지사항_상세</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>글번호</th>
					<td>${noti.idx }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${noti.title }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${noti.content }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${noti.author }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<fmt:parseDate var="resdate" value="${noti.resdate }" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
					</td>
				</tr>
				<c:if test="${!empty noti.file1 }">
					<th>첨부파일</th>
					<td>
						<c:set var="lh" value="${fn:length(noti.file1) }" />
						<c:set var="download" value="${fn:substring(noti.file1,5,lh) }" />
						<a href="${path_gntc }/${filepath1 }/${file1 }" download>${download }</a>
					</td>
				</c:if>
				<tr>
					<th>조회수</th>
					<td>${noti.readcnt }</td>
				</tr>
			</tbody>
		</table>
		<div class="btn btn-group">
			<a href="${path_gntc }/NoticeList.do" class="btn btn-primary">글 목록</a>
			<a href="${path_gntc }/InsertNotice.do" class="btn btn-primary">글 등록</a>
			<%-- 로그인한 사람의 이름이나 작성자이거나 관리자와 같은 경우 편집 및 삭제 가능 --%>
			<a href="${path_gntc }/UpdateNotice.do?idx=${noti.idx }" class="btn btn-primary">글 변경</a>
			<a href="${path_gntc }/DelNotice.do?idx=${noti.idx }" class="btn btn-primary">글 삭제</a>
		</div>
	</div>
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>