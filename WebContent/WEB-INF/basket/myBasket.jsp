<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_mbk" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>My Basket</title>
<link rel="stylesheet" href="${path_mbk }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<div class="container-fluid">
		<h2>${username }님의 장바구니 정보</h2>
		<table class="table">
			<thead>
				<tr><th>연번</th><th>상품명</th><th>가격</th><th>수량</th><th>&nbsp;</th></tr>
			</thead>
			<tbody>
				<c:forEach var="bas" items="${basList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>
						<span title="${bas.pcode }">${bas.pname }</span>
					</td>
					<td>${bas.price }</td>
					<td>${bas.amount }</td>
					<td>
						<a href="${path_mbk }/ByBasketAddSales.do?bnum=${bas.bnum }&pcode=${bas.pcode }&amount=${bas.amount }&id=${sid }" class="btn btn-primary">구매</a>
						<a href="${path_mbk }/DeleteBasket.do?bnum=${bas.bnum }" class="btn btn-danger">삭제</a>
						<a href="javascript:history.go(-1)" class="btn btn-danger">뒤로 가기</a>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty basList }">
				<tr>
					<td colspan="4">장바구니 정보가 존재하지 않습니다.</td>
				</tr>
				</c:if>	
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>