<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>signin_result.jsp");
	boolean isVerified = (boolean) request.getAttribute("isVerified");
	String ment = "";
	if(isVerified){
		ment = "로그인 SUCCESS";
	} else{
		ment = "로그인 FAILURE";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signin result</title>
</head>
<body>
	<h1>signin result</h1>
	
	<h2><%= ment %></h2>
	<a href="../index.jsp">영화리스트로 이동</a>

</body>
</html>