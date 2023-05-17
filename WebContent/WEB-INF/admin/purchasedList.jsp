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
				<h2>판매 목록</h2>
				<div class="btn-group">
					<a href="${path1 }/NotSalesList.do" class="btn btn-default">판매 안된 상품</a>
				</div>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>판매상품</th><th>구매자</th><th>수량</th><th>금액</th></tr>
					</thead>
					<tbody>
						<c:set var="total1" value = "0" />
						<c:set var="total2" value = "0" />
						<c:forEach var="sale" items="${sList }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>
								<a href="${path1 }/ProductDetail.do?pcode=${sale.pcode }" title="${sale.pcode }">${sale.pname }</a>
							</td>
							<td><span title="${sale.id }">${sale.username }</span></td>
							<td>
								<span><fmt:formatNumber value="${sale.amount }" pattern="#,##0 개" /></span>
							</td>
							<td>
								구매금액 : <span><fmt:formatNumber value="${sale.price/1.4 }" pattern="#,##0 원" /></span><br>
								판매금액 : <span><fmt:formatNumber value="${sale.price }" pattern="#,##0 원" /></span>
								<c:set var="total1" value="${total1 + (sale.price/1.4)}"/>
								<c:set var="total2" value="${total2 + sale.price }"/>
							</td>
						</tr>
						</c:forEach>
						<tr>
							<th colspan="4">누 계</th>
							<td colspan="2">
								<span>구매금액 합계 : <fmt:formatNumber value="${total1 }" pattern="#,##0원" /></span><br>
								<span>판매금액 합계 : <fmt:formatNumber value="${total2 }" pattern="#,##0원" /></span><br>
								<span>이익금액 합계 : <fmt:formatNumber value="${total2-total1 }" pattern="#,##0원" /></span>
							</td>
						</tr>
						<c:if test="${empty sList }">
						<tr>
							<td colspan="6">판매 내역이 존재하지 않습니다.</td>
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