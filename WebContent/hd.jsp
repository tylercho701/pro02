<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_hd" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String sid = "";
	if(session != null) {
		sid = (String) session.getAttribute("sid");
	}
%>
<header class="hd">
	<div class=hd_wrap>
		<nav id="tnb" class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<ul class="nav nav-tabs">
					<c:if test="${empty sid }">
						<li role="presentation" class="active"><a href="${path_hd }/UserLogin.do">로그인</a></li>
						<li role="presentation"><a href="${path_hd }/UserTerms.do">회원가입</a></li>
					</c:if>
					<c:if test="${!empty sid }">
						<li role="presentation"><a href="${path_hd }/MyPage.do">마이페이지</a></li>
						<li role="presentation"><a href="${path_hd }/MyBasket.do">장바구니</a></li>
						<li role="presentation"><a href="${path_hd }/UserLogout.do">로그아웃</a></li>
					</c:if>
					<c:if test="${sid == 'admin' }">
						<li role="presentation"><a href="${path_hd }/Admin.do">관리자페이지</a></li>
						<li role="presentation"><a href="${path_hd }/UserLogout.do">로그아웃</a></li>
					</c:if>
					<li role="presentation"><a href="${path_hd }/NoticeList.do">공지사항</a></li>
				</ul>
			</div>
		</nav>
	</div>
</header>