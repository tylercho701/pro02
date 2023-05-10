<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_mp" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>마이 페이지</title>
<link rel="stylesheet" href="${path_mp }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<section class="container-fluid">
		<h2 class="title">회원 정보</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>${user.id }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${user.pw }</td>
				</tr>
				<tr>
					<th>회원이름</th>
					<td>${user.uname }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${user.uemail }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${user.utel }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${user.uaddr }</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${user.regdate }</td>
				</tr>
				<tr>
					<th>회원 포인트</th>
					<td>${user.point }</td>
				</tr>
				<tr>
					<th>방문 횟수</th>
					<td>${user.visited }</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="${path_mp }/UpdateUser.do?id=${user.id}" class="btn btn-primary">회원 정보 수정</a>
						<a href="${path_mp }/DeleteUser.do?id=${user.id}" class="btn btn-primary">회원 탈퇴</a>
						<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로</a>						
					</td>
				</tr>
			</tbody>
		</table>
	</section>	
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>