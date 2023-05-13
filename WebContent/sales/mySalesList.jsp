<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_mslst" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>Purchasing Page</title>
<link rel="stylesheet" href="${path_mslst }/form_common.css">
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<style>
.table { border-bottom:1px solid #333; }
.thumbnail { height:480px; }
.comment { width:auto; height:60px; overflow: hidden;  text-overflow: ellipsis; 
 display: -webkit-box;  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical; }
.thumb_box { width:145px; margin:24px auto; margin-bottom:10px; height:auto; overflow:hidden;
padding-top:5px; padding-bottom:5px; 
border:1px solid #e0e0f0; text-align:center; }
.thumb_box::after { content:""; display:block; clear:both; }
.thumb_box img { width:auto; height:193px; }  
.pro_title { overflow:hidden; white-space:nowrap; text-overflow:ellipsis; }
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>${user.uname }님의 상품 구매 목록</h2>
				<hr>
				<fmt:setLocale value="ko_kr" />
				<table class="table">
					<thead>
						<tr><th>연번</th><th>상품</th><th>구매가격</th><th>구매일</th><th>상태</th></tr>
					</thead>
					<tbody>
						<c:forEach var="sale" items="${sList }" varStatus="status">
						<tr>
							<td><span title="주문 번호 : ${sale.onum }" style="cursor:pointer; display:inline-block;">${status.count }</span></td>
							<td>
								<span title="제품 코드 : ${sale.pcode }" style="cursor:pointer; display:inline-block;">${sale.pname }</span>
							</td>
							<td>
								<span title="구매 수량 : ${sale.amount }" style="cursor:pointer; display:inline-block;">
									<fmt:formatNumber value="${sale.price }" pattern="#,##0 원"/>
								</span>
							</td>
							<td>
								<fmt:parseDate value="${sale.odate }" var="odate" pattern="yyyy-MM-dd HH:mm:ss" />
								<span style="display:inline-block;"><fmt:formatDate value="${odate }" pattern="yyyy년 MM월 dd일" /></span>
							</td>
							<td>
								<span style="display:inline-block; width:100px;" title="구매 완료된 제품은 반품이 불가능합니다.">${sale.dstatus }</span> &nbsp; &nbsp; &nbsp;
								<c:if test="${sale.dstatus=='배송전' }">
									<a href="${path_mslst }/CancelPay.do?onum=${sale.onum }" class="btn btn-danger">결제 취소</a>
								</c:if>
								<c:if test="${sale.dstatus=='배송중' || sale.dstatus=='배송완료'}">
									<a href="${path_mslst }/ReturnBuy.do?onum=${sale.onum }" class="btn btn-info">반품 요청</a>
									<a href="${path_mslst }/OkBuy.do?onum=${sale.onum }" class="btn btn-primary">구매 완료</a>
									&nbsp; &nbsp;
									<span style="display:inline-block; width:160px;" title="배송 코드 : ${sale.dcode }">배송사 : ${sale.dname }</span>
								</c:if>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty sList }">
						<tr>
							<td colspan="4">구매 내역이 존재하지 않습니다.</td>
						</tr>
						</c:if>	
					</tbody>
				</table>
				<div class="btn-group">
					<a href="javascript:history.go(-1)" class="btn btn-danger">뒤로 가기</a>
				</div>
			</div>
		</div>
		<%@ include file="../ft.jsp" %>
	</div>
</body>
</html>