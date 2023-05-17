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
<title>Payment List</title>
<link rel="stylesheet" href="${path1 }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>전체 결제 목록</h2>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>결제상품</th><th>구매자</th><th>수량</th><th>금액</th><th>결제 내용</th></tr>
					</thead>
					<tbody>
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
								<span><fmt:formatNumber value="${sale.price }" pattern="#,##0 원" /></span>
							</td>
							<td>
								결제 번호 : <span>${sale.pnum }</span><br>
								결제 종류 : <span>${sale.ptype }</span><br>
								결제 카드/계좌 번호 : <span>${sale.ptnum }</span>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty sList }">
						<tr>
							<td colspan="6">결제 내역이 존재하지 않습니다.</td>
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