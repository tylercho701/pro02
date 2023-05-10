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
<header id="hd">
	<nav id="tnb_1" class="navbar navbar-default" style="margin-bottom:0; padding-top:7px; padding-left:5px;">
		<ul class="nav nav-tabs">
			<li><a class="navbar-brand" href="${path_hd }">DAISO</a></li>
			<c:if test="${empty sid }">
				<li role="presentation"><a href="${path_hd }/UserLogin.do">로그인</a></li>
				<li role="presentation"><a href="${path_hd }/UserTerms.do">회원가입</a></li>
			</c:if>
			<c:if test="${!empty sid }">
				<li role="presentation"><a href="${path_hd }/MyPage.do">${sid }님의 마이페이지</a></li>
				<li role="presentation"><a href="${path_hd }/MyBasket.do">장바구니</a></li>
				<li role="presentation"><a href="${path_hd }/UserLogout.do">로그아웃</a></li>
			</c:if>
			<c:if test="${sid == 'admin' }">
				<li role="presentation"><a href="${path_hd }/Admin.do">관리자페이지</a></li>
				<li role="presentation"><a href="${path_hd }/UserLogout.do">로그아웃</a></li>
			</c:if>
			<li role="presentation"><a href="${path_hd }/NoticeList.do">공지사항</a></li>
		</ul>
	</nav>
	<nav id="tnb_2" class="navbar navbar-default" style="margin-bottom:0; padding-top:7px; padding-left:5px;">
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				보관/정리/수납
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="ProductList.do?cate=0101">리빙박스(플라스틱)</a></li>
				<li><a href="ProductList.do?cate=0102">정리함</a></li>
				<li><a href="ProductList.do?cate=0103">옷걸이/행거</a></li>
				<li><a href="ProductList.do?cate=0104">공구함/약통</a></li>
				<li><a href="ProductList.do?cate=0105">서랍장/서류함</a></li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				청소
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="ProductList.do?cate=0201">휴지통</a></li>
				<li><a href="ProductList.do?cate=0202">걸레/솔</a></li>
				<li><a href="ProductList.do?cate=0203">매직블럭</a></li>
				<li><a href="ProductList.do?cate=0204">롤크리너</a></li>
				<li><a href="ProductList.do?cate=0205">빗자루/쓰레받이</a></li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				거실/잡화
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="ProductList.do?cate=0301">거실화/슬리퍼</a></li>
				<li><a href="ProductList.do?cate=0302">발매트</a></li>
				<li><a href="ProductList.do?cate=0303">휴지/물티슈</a></li>
				<li><a href="ProductList.do?cate=0304">우산/우비</a></li>
				<li><a href="ProductList.do?cate=0305">돗자리/생활매트</a></li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				욕실
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="ProductList.do?cate=0401">비누받침/양치컵</a></li>
				<li><a href="ProductList.do?cate=0402">발매트</a></li>
				<li><a href="ProductList.do?cate=0403">변기세척</a></li>
				<li><a href="ProductList.do?cate=0404">샤워용품</a></li>
				<li><a href="ProductList.do?cate=0405">칫솔/치실</a></li>
			</ul>
		</div>
	</nav>
</header>

