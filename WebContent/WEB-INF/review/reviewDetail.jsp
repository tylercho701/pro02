<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_rd" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Review Detail</title>
<link rel="stylesheet" href="${path_rd }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<section class="container-fluid">
		<h2 class="title">구매 후기 상세</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>후기번호</th>
					<td>
						${review.rnum }
						<input type="hidden" value="${review.id }" id="id" name="id">	
					</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td>${review.pname }</td>
				</tr>
				<tr>
					<th>작성자 ID</th>
					<td>${review.id }</td>
				</tr>
				<tr>
					<th>리뷰내용</th>
					<td>
						<textarea>${review.rcom }</textarea>
					</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<fmt:parseDate value="${review.writtendate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				<tr>
					<th>후기점수</th>
					<td>${review.rpoint }</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${review.id == sid }">
							<a href="${path_rd }/UpdateReview.do?rnum=${review.rnum}" class="btn btn-info">게시글 수정</a>
							<a href="${path_rd }/DeleteReview.do?rnum=${review.rnum}" class="btn btn-danger">게시글 삭제</a>
						</c:if>
						<c:if test="${sid == 'admin' }">
							<a href="${path_rd }/UpdateReview.do?rnum=${review.rnum}" class="btn btn-info">게시글 수정</a>
							<a href="${path_rd }/DeleteReview.do?rnum=${review.rnum}" class="btn btn-danger">게시글 삭제</a>
						</c:if>
						<a href="javascript:history.go(-1)" class="btn btn-warning">뒤로가기</a>						
					</td>
				</tr>
			</tbody>
		</table>
	</section>	
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>