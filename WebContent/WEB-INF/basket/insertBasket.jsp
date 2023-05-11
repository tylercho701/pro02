<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_inbk" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Insert Basket</title>
<link rel="stylesheet" href="${path_inbk }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2>장바구니 담기</h2>
		<p>${msg }</p>
		<form action="${path_inbk }/InsertBasketPro.do" method="POST">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="pname">상품명</label></th>
						<td>
							<input type="hidden" name="id" id="id" value="${sid }">
							<input type="hidden" name="pcode" id="pcode" value="${pro.pcode }">
							<input type="text" name="pname" id="pname" value="${pro.pname }" title="40자 내로 작성" placeholder="40자 내로 작성" class="form-control" disabled>
						</td>
					</tr>
					<tr>
						<th><label for="price">가격</label></th>
						<td>
							<input type="number" name="price" id="price" value="${pro.price }" min="0" max="5000000" step="100" title="0~5000000" class="form-control" disabled>
						</td>
					</tr>
					<tr>
						<th><label for="amount">수량</label></th>
						<td>
							<input type="number" name="amount" id="amount" value="1" min="0" max="${pro.amount }" title="1~500" class="form-control">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="장바구니 담기" class="btn btn-danger">
							<a href="${path_inbk }/MyBasket.do?id=${sid }" class="btn btn-primary">장바구니 가기</a>				
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