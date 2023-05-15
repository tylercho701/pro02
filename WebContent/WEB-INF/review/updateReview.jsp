<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_udtrvw" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Review_Insert</title>
<link rel="stylesheet" href="${path_udtrvw }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2 class="title">구매후기_수정</h2>
		<form action="${path_udtrvw }/UpdateReviewPro.do" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="title">상품명</label></th>
						<td>
							<input type="hidden" name="rnum" id="rnum" value="${review.rnum }">
							<input type="hidden" name="onum" id="onum" value="${review.onum }">
							<input type="text" name="pname" id="pname" value="${review.pname }" readonly>
						</td>
					</tr>
					<tr>
						<th><label for="rcom">구매 후기</label></th>
						<td><textarea cols="100" rows="5" id="rcom" name="rcom" required placeholder="500자 이내 작성 가능">${review.rcom }</textarea></td>
					</tr>
					<tr>
						<th>만족도</th>
						<td>
							<select name="rpoint">
								<option value="${review.rpoint }">--변동없음(${review.rpoint }점)--</option>
								<option value="5">매우 만족</option>
								<option value="4">만족</option>
								<option value="3">보통</option>
								<option value="2">불만족</option>
								<option value="1">매우 불만족</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="submit" class="btn btn-primary" value="후기 수정 완료">
							<a href="javascript:history.go(-1)" class="btn btn-warning">뒤로가기</a>
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