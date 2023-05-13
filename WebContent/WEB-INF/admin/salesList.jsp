<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_slst" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Sales List</title>
<link rel="stylesheet" href="${path_slst }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
	<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>판매목록</h2>
				<hr>
				<fmt:setLocale value="ko_kr" />
				<table class="table">
					<thead>
						<tr><th>연번</th><th>구매자</th><th>상품</th><th>구매가격</th><th>구매일</th><th>상태</th></tr>
					</thead>
					<tbody>
						<c:forEach var="sale" items="${sList }" varStatus="status">
						<tr>
							<td><span title="주문 번호 : ${sale.onum }" style="cursor:pointer; display:inline-block;">${status.count }</span></td>
							<td>
								<span title="구매자 아이디 : ${sale.id }" style="cursor:pointer; display:inline-block;">${sale.username }</span>
							</td>
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
								<span style="display:inline-block; width:100px;" title="판매 완료된 제품은 반품이 불가능합니다.">${sale.dstatus }</span> &nbsp; &nbsp; &nbsp;
								<c:if test="${sale.dstatus=='배송전' }">
									<a href="${path_slst }/AdminSalesProgress.do?onum=${sale.onum }" class="btn btn-primary">배송 처리</a>
									<a href="${path_slst }/AdminCancel.do?onum=${sale.onum }" class="btn btn-danger">주문 직권 취소</a>
								</c:if>
								<c:if test="${sale.dstatus=='배송중' || sale.dstatus=='배송완료'}">
									<span class="dname">배송 회사 : ${sale.dname },</span> &nbsp; &nbsp; 
									<span class="dname">배송 코드 : ${sale.dcode }</span>
								</c:if>
								<c:if test="${sale.dstatus=='반품요청' }">
									<a href="${path_slst }/AdminCancel.do?onum=${sale.onum }" class="btn btn-danger">반품 승인 완료</a>
								</c:if>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty sList }">
						<tr>
							<td colspan="4">판매 내역이 존재하지 않습니다.</td>
						</tr>
						</c:if>	
					</tbody>
				</table>
				<div class="btn-group">
					<a href="javascript:history.go(-1)" class="btn btn-info">뒤로 가기</a>
				</div>
			</div>
			<%@ include file="../../ft.jsp" %>
		</div>
	</div>
</body>
</html>