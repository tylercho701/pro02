<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_slad" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Survey Load</title>
<link rel="stylesheet" href="${path_slad }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
	<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2>판매/배송 처리</h2>
				<p>${msg }</p>
				<form action="${path_slad }/AdminSalesProgressPro.do" method="POST">
					<h3>판매/배송 처리</h3>
					<table class="table">
						<tbody>
							<tr>
								<th>상품명</th>
								<td>${sale.pname }
									<input type="hidden" id="onum" name="onum" value="${sale.onum }">
								</td>
							</tr>
							<tr>
								<th>주문자</th>
								<td>${sale.username }</td>
							</tr>
							<tr>
								<th>판매 가격</th>
								<td>${sale.price }
							</tr>
							<tr>
								<th><label for="dname">배송사</label></th>
								<td>
									<span>${sale.dname }</span><br>
									<select name="dname" id="dname" required>
										<option value="">선택안함</option>
										<option value="CJ대한통운">CJ대한통운</option>
										<option value="롯데택배">롯데택배</option>
										<option value="우체국택배">우체국택배</option>
										<option value="로젠택배">로젠택배</option>
										<option value="한진택배">한진택배</option>
										<option value="CU 편의점택배">CU 편의점택배</option>
										<option value="EMS 택배">EMS 택배</option>
										<option value="경동택배">경동택배</option>
									</select>
								</td>
							</tr>
							<tr>
								<th><label for="dcode">배송코드</label></th>
								<td><input type="text" name="dcode" value="${sale.dcode }" id="dcode" required></td>
							</tr>
							<tr>
								<th><label for="dstatus">배송상태</label></th>
								<td>
									<span>${sale.dstatus }</span><br>
									<select name="dstatus" id="dstatus" required>
										<option value="배송전">배송전</option>
										<option value="배송중">배송중</option>
										<option value="배송완료">배송완료</option>
										<option value="구매완료">구매완료</option>
										<option value="주문취소">주문취소</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="btn-group">
						<input type="submit" value="배송처리" class="btn btn-primary">
						<a href="${path_slad }/AdminCancel.do?onum=${sale.onum} " class="btn btn-danger">주문 취소 처리</a>
						<a href="javascript:history.go(-1)" class="btn btn-primary" class="btn btn-info">뒤로 가기</a>				
					</div>
				</form>
			</div>
			<%@ include file="../../ft.jsp" %>
		</div>
	</div>
</body>
</html>