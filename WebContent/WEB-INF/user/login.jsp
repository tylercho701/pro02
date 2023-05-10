<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_login" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>로그인 하기</title>
<link rel="stylesheet" href="${path_login }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2 class="title">로그인</h2>
		<p>${msg }</p>
		<form action="${path_login }/UserLoginPro.do" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="id">아이디</label></th>
						<td>
							<input type="text" name="id" id="id" maxlength="15" title="15자 내로 작성" placeholder="15자 내로 작성" class="form-control" required autofocus>
						</td>
					</tr>
					<tr>
						<th><label for="pw">비밀번호</label></th>
						<td>
							<input type="password" name="pw" id="pw" maxlength="15" title="15자 내로 작성" placeholder="15자 내로 작성" class="form-control" required>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인" class="btn btn-primary">
							<input type="reset" value="취소" class="btn btn-primary" >
							<a href="${path_login }/UserTerms.do" class="btn btn-primary">회원가입</a>				
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