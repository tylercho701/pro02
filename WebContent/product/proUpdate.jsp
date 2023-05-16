<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_pudt" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>Product Registration</title>
<link rel="stylesheet" href="${path_pudt }/form_common.css">
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2 class="title">상품 정보 수정</h2>
				<form action="${path_pudt }/UpdateProductPro.do" method="post" enctype="multipart/form-data">
					<table class="table">
						<tbody>
							<tr>
								<th>
									<label for="category">카테고리(${catename }</label>
								</th>
								<td>
									
								</td>
							</tr>
							<tr>
								<th><label for="pcode">상품코드</label></th>
								<td><input type="text" name="pcode" id="pcode" value="${pro.pcode }" required autofocus></td>
							</tr>
							<tr>
								<th><label for="pname">상품명</label></th>
								<td>
									<input type="hidden" name="author" id="author" value="${sid }">
									<input type="text" name="pname" id="pname" value="${pro.pname }" required>
								</td>
							</tr>
							<tr>
								<th><label for="pmeas">상품규격</label></th>
								<td><input type="text" name="pmeas" id="pmeas" value="${pro.pmeas }" required></td>
							</tr>
							<tr>
								<th><label for="price">상품가격</label></th>
								<td><input type="text" name="price" id="price" value="${pro.price }"></td>
							</tr>
							<tr>
								<th><label for="pcom">상품설명</label></th>
								<td><input type="text" name="pcom" id="pcom" value="${pro.pcom }"></td>
							</tr>
							<tr>
								<th><label for="amount">상품수량</label></th>
								<td><input type="text" name="amount" id="amount" value="${pro.amount }"></td>
							</tr>
							<tr>
							<th><label for="pic1">상품 이미지 변경</label></th>
								<td>
									<label for="pic1">이미지 1</label>
									<p id="picAttac1"><img src='${path_pudt }/product/${pro.pic1 }' alt="${pro.pname }"/></p>
									<p></p>
									<input type="file" accept="images/*" name="pic1" id="pic1" class="form-control file"><br>
									<input type="hidden" name="ori_pic1" id="ori_pic1" value="${pro.pic1 }">
									<br>
									
									이미지 2 : 
									<p id="picAttac2"><img src='${path_pudt }/product/${pro.pic2 }' alt="${pro.pname }"/></p>
									<p></p>
									<input type="file" accept="images/*" name="pic2" id="pic2" class="form-control file">
									<input type="hidden" name="ori_pic2" id="ori_pic2" value="${pro.pic2 }">
									<br>
									
									이미지 3 : 
									<p id="picAttac3"><img src='${path_pudt }/product/${pro.pic3 }' alt="${pro.pname }"/></p>
									<p></p>
									<input type="file" accept="images/*" name="pic3" id="pic3" class="form-control file">
									<input type="hidden" name="ori_pic3" id="ori_pic3" value="${pro.pic3 }">
								</td>
							</tr>
							<tr>
								<td colspan="10">
									<input type="submit" class="btn btn-primary" value="상품등록">
									<a href="${path_pist }/AdminProductList.do" class="btn btn-info">상품목록</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<script>
				$(document).ready(function(){
					$("#pcom").click(function(){
						if($(this).text()=="500자 이내"){
							$(this).text("");
						}
					});
					$(".file").change(function(){
						var tar = $(this).index();
						if($(this).val()!=""){
							$(this).prev("p").html("<strong>이미지 첨부 성공</strong>");
						}
					});
					$("#cate1").change(function(){
						if($("#cate1").val()==""){
							alert("대분류 카테고리를 선택하시기 바랍니다.");
							$("#cate1").focus();
							return;
						}
						var params = { cate1:$("#cate1").val() }
						$.ajax({
							url:"${path_pist }/CategoryLoading.do",
							type:"post",
							dataType:"json",
							encType:'UTF-8',
							data:params,
							success:function(result){
								console.log(result);
								var ctList = result.ctList;
								var msg = result.msg;
								$("#cate").empty();
								$("#cate").append("<option value=''>선택안함</option>");
								for(var c in ctList){
									$("#cate").append("<option value='"+ctList[c]["cate"]+"'>"+ctList[c]["catename"]+"</option>");
								}
							}
						});				
					});
					
				});
				</script>
			</div>
		</div>
		<%@ include file="../ft.jsp" %>
	</div>
</body>
</html>