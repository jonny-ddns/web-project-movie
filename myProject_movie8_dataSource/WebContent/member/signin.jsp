<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in</title>
<style type="text/css">
	h1{
		text-align: center;
	}

	#form_signin{
		text-align: center;
	}
	#signinCancel{
		/* text-align: center; */	
	}
</style>
</head>
<body>
	<h1>sign in</h1>
	<form id="form_signin" action="signin.bo" method="post">
		<p>ID : <input type="text" name="id"></p>
		<p>PW : <input type="password" name="pw"></p>
		<p>
			<input type="submit" value="sign in">&emsp;
		</p>
		<p>
			<a id="signinCancel" href="../index.jsp">아이디 및 비밀번호 찾기</a>
			<a id="signinCancel" href="../index.jsp">로그인 취소</a>
		</p>
	</form>
</body>
</html>