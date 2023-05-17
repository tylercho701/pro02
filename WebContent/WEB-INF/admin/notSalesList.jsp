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
<title>Purchased List</title>
<link rel="stylesheet" href="${path1 }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>판매 안된 상품 목록</h2>
				<div class="btn-group">
					<a href="${path1 }/AdminPurchasedList.do" class="btn btn-default">전체 판매 목록</a>
				</div>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>상품명</th><th>남은 수량</th><th>입고 금액</th></tr>
					</thead>
					<tbody>
						<c:forEach var="pro" items="${nList }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>
								<a href="${path1 }/GetProductDetail.do?pcode=${pro.pcode }" title="${pro.pcode }">${pro.pname }</a>
							</td>
							<td>
								<span><fmt:formatNumber value="${pro.amount }" pattern="#,##0 개" /></span>
							</td>
							<td>
								구매 금액 : <span><fmt:formatNumber value="${pro.price }" pattern="#,##0 원" /></span><br>
								판매할 금액 : <span><fmt:formatNumber value="${pro.price*1.4 }" pattern="#,##0 원" /></span>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty nList }">
						<tr>
							<td colspan="5">상품 내역이 존재하지 않습니다.</td>
						</tr>
						</c:if>	
					</tbody>
				</table>
				<div class="btn-group">
					<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로 가기</a>
				</div>
			</div>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>