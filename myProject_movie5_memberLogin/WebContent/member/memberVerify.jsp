<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member edit</title>
</head>
<body>
	<h1>member edit</h1>
	
	<div><label>비밀번호 입력 확인</label></div>
	<div>
		<form action="compare.bo" method="post">
			<input type="password" name="pw">
			<input type="submit" value="확인">
		</form>
	</div>
</body>
</html>