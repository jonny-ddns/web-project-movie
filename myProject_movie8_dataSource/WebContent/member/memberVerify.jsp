<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% System.out.println("memberVerify.jsp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member verify</title>
<style type="text/css">
	h1{text-align: center;}
	.input_pw{text-align:center; padding:3px;}
</style>
</head>
<body>
	<h1>member verify</h1>
	
	<div class="input_pw"><label>비밀번호를 다시 입력하세요</label></div>
	<div class="input_pw">
		<form action="compare.bo" method="post">
			<input type="password" name="pw">
			<input type="submit" value="확인">
		</form>
	</div>
</body>
</html>