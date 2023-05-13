<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_adul" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>User List</title>
<link rel="stylesheet" href="${path_adul }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2>회원 목록</h2>
		<table class="table">
			<thead>
				<tr><th>연번</th><th>회원 아이디</th><th>회원명</th><th>가입일</th><th>개별 작업</th></tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>
						<a href="${path_adul }/UserDetail.do?idx=${user.id }" title="${user.hpw }">${user.id }</a>
					</td>
					<td><span title="${user.uaddr }">${user.uname }</span></td>
					<td>
						<fmt:parseDate value="${user.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<span title="전화번호 : ${user.utel }, 이메일 : ${user.uemail }"><fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" /></span>
					</td>
					<td>
						<a href="${path_adul }/AdminDeleteUser.do?id=${user.id }" class="btn btn-danger">회원 삭제</a>
						<a href="${path_adul }/AdminUpdateUser.do?id=${user.id }" class="btn btn-primary">회원 정보 수정</a>
						<a href="${path_adul }/AdminResetUser.do?id=${user.id }" class="btn btn-warning" title="회원 전화번호 뒤 네자리로 초기화됩니다.">비밀번호 초기화</a>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty userList }">
				<tr>
					<td colspan="4">가입된 회원이 존재하지 않습니다.</td>
				</tr>
				</c:if>	
			</tbody>
		</table>
		<c:if test="${!empty sid }">
		<div class="btn-group">
			<a href="${path_adul }/AdminInsertUser.do" class="btn btn-primary">회원 등록</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>