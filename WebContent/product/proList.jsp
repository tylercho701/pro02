<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path_plst" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>Index</title>
<link rel="stylesheet" href="${path_plst }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
			<h2 class="title">상품 목록</h2>
			<fmt:setLocale value="ko_kr" />
			<article class="row">
				<c:forEach var="pdt" items="${proList }" varStatus="status">
				<div class="col-sm-6 col-md-4 col-lg-3">
					<div class="thumbnail">
						<div class="thumb_box">
							<img src='${path_plst }/product/${pdt.pic1 }' alt="${pdt.pname }"/>
						</div>
						<div class="caption">
							<h4><strong>${pdt.pname }</strong></h4>
							<p class="comment"><strong>상품 설명</strong> :<br>${pdt.pcom }</p>
							<p><strong>수량</strong> : ${pdt.amount }</p>
							<p><strong>가격</strong> : <fmt:formatNumber value="${pdt.price }" type="currency" /></p>
							<p>
								<a href="${path_plst }/ProductDetail.do?pcode=${pdt.pcode}" class="btn btn-primary" role="button">상세 보기</a>
								<a href="${path_plst }/InsertBasket.do?pcode=${pdt.pcode}" class="btn btn-default" role="button">장바구니 담기</a>
							</p>
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
			<c:if test="${sid.equals('admin') }">
			<div class="btn-group" style="display:block; float:right;">
				<a href="${path_plst }/InsertProduct.do" class="btn btn-primary">상품 등록</a>
			</div><br>
			</c:if>
		</div>
		<%@ include file="../ft.jsp" %>
	</div>
</body>
</html>