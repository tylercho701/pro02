<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path_pdl" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>Product_detail</title>
<link rel="stylesheet" href="${path_pdl }/form_common.css">
<style>
.table { width:600px; margin:20px auto; }
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h3>상품 > <a href="${path_pdl }/ProductList.do?cate=${pro.category}">${cateMap.catename }</a> > ${pro.pname }</h3>
				<hr>
				<fmt:setLocale value="ko_kr" />
				<table class="table">
					<tbody>
						<tr>
							<td colspan="2">
								<img src='${path_pdl }/product/${pro.pic1 }' alt="${pro.pname }"/>
							</td>
						</tr>
						<tr>
							<th>상품명(상품코드)</th>
							<td>${pro.pname }(${pro.pcode })</td>
						</tr>
						<tr>
							<th>규격</th>
							<td>${pro.pmeas }</td>
						</tr>
						<tr>
							<th>설명</th>
							<td>${pro.pcom }</td>
						</tr>
						<tr>
							<th>가격</th>
							<td>${pro.price }</td>
						</tr>
						<tr>
							<th>남은 수량</th>
							<td>${pro.amount }</td>
						</tr>
						<tr>
							<td colspan="2" class="btn-btm">
								<div class="btn-group">
									<c:if test="${pro.amount>0 && !sid.equals('admin')}">
										<a href="${path_pdl }/InsertBasket.do?pcode=${pro.pcode}" class="btn btn-primary" role="button">장바구니</a>
										<a href="${path_pdl }/InsertSales.do?pcode=${pro.pcode}" class="btn btn-danger" role="button">구매</a>
										<a href="${path_pdl }/ProductList.do?cate=${pro.category}" class="btn btn-primary" role="button">목록</a>
									</c:if>
									<c:if test="${sid.equals('admin') }">
										<a href="${path_pdl }/ReceiptProduct.do?pcode=${pro.pcode }" class="btn btn-info" role="button">입고</a>
										<a href="${path_pdl }/UpdateProduct.do?pcode=${pro.pcode }" class="btn btn-warning" role="button">수정</a>
										<a href="${path_pdl }/DeleteProduct.do?pcode=${pro.pcode }" class="btn btn-danger" role="button">삭제</a>
										<a href="${path_pdl }/AdminProductList.do" class="btn btn-primary" role="button">목록</a>
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<img src='${path_pdl }/product/${pro.pic2 }' alt="${pro.pname }"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<img src='${path_pdl }/product/${pro.pic3 }' alt="${pro.pname }"/>
							</td>
						</tr>
					</tbody>
				</table>
				<c:if test="${!empty reviewLst }">
				<table class="table">
					<thead>
						<tr><th>리뷰번호</th><th>리뷰내용</th><th>리뷰작성일</th><th>후기점수</th></tr>
					</thead>
					<tbody>
					<c:forEach var="rv" items="${reviewLst }" >
						<tr>
						<td>${rv.rnum }</td>
						<td>
							<a href="${path_pdl }/ReviewDetail.do?rnum=${rv.rnum }" >${rv.rcom }</a>
						</td>
						<td>
							<fmt:parseDate value="${rv.writtendate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" />
						</td>
						<td>${rv.rpoint }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
				<c:if test="${sid.equals('admin') }">
				<div class="btn-group" style="display:block; float:right; ">
					<a href="${path_pdl }/InsertProduct.do" class="btn btn-primary">상품 등록</a>
				</div>
				</c:if>
			</div>
		</div>
		<%@ include file="../ft.jsp" %>
	</div>
</body>
</html>