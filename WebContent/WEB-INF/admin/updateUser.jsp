<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path_aduu" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>Update User Info</title>
<link rel="stylesheet" href="${path_aduu }/form_common.css">
<style>
</style>
</head>
<body>
<div class="container">
<%@ include file="../../hd.jsp" %>
<div class="content">
	<section class="container-fluid">
		<h2 class="title">회원가입</h2>
		<form name="frm1" id="frm1" action="${path_aduu }/AdminUpdateUserPro.do" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<div class="form-row">
								<input type="text" name="id" id="id" placeholder="영문소문자 및 숫자를 혼용하여 15글자 이내로 아이디 입력" class="form-control" maxlength="15" style="width:80%;display:inline-block;" value="${user.id }" readonly />
							</div>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>
							<span>${user.pw }</span>
							<input type="password" name="ppw" id="ppw" placeholder="비밀번호 입력" class="form-control" maxlength="15" value="${user.pw }" required />
							<input type="hidden" name="pw" id="pw" value="${user.pw }" />
							<p>비밀번호는 최소 8자리에서 최대 16자리까지 숫자, 영문, 특수문자 각 1개 이상 포함되어야 함</p>
						</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="ppw2" id="ppw2" placeholder="비밀번호  확인 입력" class="form-control" value="${user.pw }" maxlength="15" /></td>
						
					</tr>
					<tr>
						<th>회원이름</th>
						<td><input type="text" name="name" id="name" placeholder="이름 입력" class="form-control" value="${user.uname }" required /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" name="email" id="email" placeholder="이메일 입력" class="form-control" value="${user.uemail }" required></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="tel" name="tel" id="tel" maxlength="11" placeholder="전화번호 숫자만 입력 00000000000" class="form-control" value="${user.utel }" required></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<span style="display:block;">${user.uaddr }</span>
							<input type="hidden" name="addr" id="addr" value="${user.uaddr }" />
							<input type="text" name="address1" id="address1" placeholder="기본 주소 입력" class="form-control" /><br>
							<input type="text" name="address2" id="address2" placeholder="상세 주소 입력" class="form-control" /><br>
							<input type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" placeholder="우편번호" class="form-control">
							<button id="post_btn" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="회원정보수정" class="btn btn-primary"/>
							<input type="reset" value="취소" class="btn btn-primary"/>
							<a href="${path_aduu }/MemberList.do" class="btn btn-primary">회원 목록</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
		function modifyCheck(f){
			if(f.ppw.value!=f.ppw2.value){
				alert("비밀번호와 비밀번호 확인이 다릅니다.");
				f.ppw.focus();
				return;
			}
		}
		function findAddr(){
			new daum.Postcode({
				oncomplete: function(data) {
					console.log(data);
					var roadAddr = data.roadAddress;
					var jibunAddr = data.jibunAddress;
					document.getElementById("postcode").value = data.zonecode;
					if(roadAddr !== '') {
						document.getElementById("address1").value = roadAddr;				
					} else if(jibunAddr !== ''){
						document.getElementById("address1").value = jibunAddr;
					}
					document.getElementById("address2").focus();
				}
			}).open();		
		}
		</script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	</section>
</div>
<%@ include file="../../ft.jsp" %>
</div>
</body>
</html>