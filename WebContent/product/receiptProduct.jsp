<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_pist" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>Product Registration_STOCK</title>
<link rel="stylesheet" href="${path_pist }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2 class="title">재고 등록</h2>
				<form action="${path_pist }/ReceiptProductPro.do" method="post">
					<table class="table">
						<tbody>
							<tr>
							<td colspan="2">
								<img src="${path_pist }/product/${pro.pic1 }" alt="${pro.pname }"/>
							</td>
							</tr>
							<tr>
								<th>상품명(상품코드)</th>
								<td>
									${pro.pname }(${pro.pcode })
									<input type="hidden" name="pcode" id="pcode" value="${pro.pcode }">
								</td>
							</tr>
							<tr>
								<th>규격</th>
								<td>${pro.pmeas }</td>
							</tr>
							<tr>
								<th>상품설명</th>
								<td>${pro.pcom }</td>
							</tr>
							<tr>
								<th>현재가격</th>
								<td>${pro.price }</td>
							</tr>
							<tr>
								<th><label for="price">가격</label></th>
								<td><input type="text" name="price" id="price" value="${pro.price }"></td>
							</tr>
							<tr>
								<th>현재수량</th>
								<td>${pro.amount }</td>
							</tr>
							<tr>
								<th><label for="amount">입고수량</label></th>
								<td><input type="text" name="amount" id="amount"></td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" class="btn btn-info" value="입고등록">
									<a href="${path_pist }/ProductDetail.do?pcode=${pro.pcode }" class="btn btn-primary">뒤로가기</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="../ft.jsp" %>
	</div>
</body>
</html>