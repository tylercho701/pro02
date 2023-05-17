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
.btn-group > a { font-size:12px; padding:3px 3px; width:70px; }
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>전체 재고 상품 목록</h2>
				<hr>
				<c:if test="${sid.equals('admin') }">
					<div class="btn-group">
						<a href="${path1 }/InsertProduct.do" class="btn btn-danger">상품 등록</a>
						<a href="${path1 }/SoldoutProductList.do" role="button" class="btn btn-primary">품절 상품</a>
					</div>
					<hr>
				</c:if>
				<fmt:setLocale value="ko_kr" />
				<article class="row">
					<c:forEach var="pro" items="${proList }" varStatus="status">
					<div class="col-sm-6 col-md-4 col-lg-3">
						<div class="thumbnail">
							<div class="thumb_box">
								<img src='${path1 }/product/${pro.pic1 }' alt="${pro.pname }"/>
							</div>
							<div class="caption">
								<a href="${path1 }/ProductDetail.do?pcode=${pro.pcode}">
									<h3 class="pro_title"><strong>${pro.pname }</strong></h3>
									<p class="comment"><strong>상품 설명</strong> :<br>${pro.pcom }</p>
									<p><strong>수량</strong> :
										<c:if test="${pro.amount<=0 }"><span>품절</span></c:if>
										<c:if test="${pro.amount>0 }">${pro.amount }</c:if>
									</p>
									<p><strong>가격</strong> : <fmt:formatNumber value="${pro.price*1.4 }" type="currency" /></p>
								</a>
								<div class="btn-group">
									<%-- <c:if test="${pro.amount>0 && !sid.equals('admin')}">
										<a href="${path1 }/InsertBasket.do?pcode=${pro.pcode}" class="btn btn-default" role="button">장바구니 담기</a>
									</c:if> --%>
									<c:if test="${sid.equals('admin') }">
										<a href="${path1 }/ReceiptProduct.do?pcode=${pro.pcode }" class="btn btn-primary" role="button">상품 입고</a>
										<a href="${path1 }/UpdateProduct.do?pcode=${pro.pcode }" class="btn btn-success" role="button">상품 수정</a>
										<a href="${path1 }/DeleteProduct.do?pcode=${pro.pcode }" class="btn btn-warning" role="button">상품 삭제</a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
				</article>
				<c:if test="${empty proList }">
				<div class="container">
					<h3>해당 상품이 존재하지 않습니다.</h3>
				</div>
				</c:if>	
			</div>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>