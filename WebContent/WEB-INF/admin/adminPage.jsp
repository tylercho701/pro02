<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_ap" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>ADMIN</title>
<link rel="stylesheet" href="${path_ap }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<h2 class="title" title="${msg }">관리자 페이지</h2>
			<table class="table">
				<thead>
					<tr><th>회원관리</th><th>상품관리</th><th>판매관리</th><th>공지사항관리</th><th>문답관리</th></tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="${path_ap }/MemberList.do">회원관리</a></td>
						<td><a href="${path_ap }/AdminCategoryList.do">카테고리 관리</a></td>
						<td><a href="${path_ap }/AdminBasketList.do">장바구니 관리</a></td>
						<td><a href="${path_ap }/AdminNoticeList.do">공지사항 관리</a></td>
						<td><a href="${path_ap }/AdminReviewList.do">이용후기 관리</a></td>
					</tr>
					<tr>
						<td><a href=""></a></td>
						<td><a href="${path_ap }/AdminProductList.do">상품 관리</a></td>
						<td><a href="${path_ap }/AdminPayList.do">결제 관리</a></td>
						<td><a href="${path_ap }/AdminDataList.do">자료실 관리</a></td>
						<td><a href="${path_ap }/QnaList.do">질문 및 답변 관리</a></td>						
					</tr>
					<tr>
						<td><a href=""></a></td>
						<td><a href="${path_ap }/AdminInventoryList.do">재고 관리</a></td>
						<td><a href="${path_ap }/AdminSalesList.do">배송 관리</a></td>
						<td><a href=""></a></td>
						<td><a href="${path_ap }/FaqList.do">자주하는 질문 관리</a></td>
					</tr>
					<tr>
						<td><a href=""></a></td>
						<td><a href=""></a></td>
						<td><a href="${path_ap }/AdminPurchasedList.do">판매 관리</a></td>
						<td><a href=""></a></td>
						<td><a href=""></a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>