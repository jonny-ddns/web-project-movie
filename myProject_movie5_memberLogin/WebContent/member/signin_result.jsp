<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>signin_result.jsp");
	boolean isVerified = (boolean) request.getAttribute("isVerified");
	String ment = "SIGN IN FAILURE";
	
	if(session.getAttribute("memberLogin") != null){
		System.out.println("session yes");
		response.sendRedirect("../index.jsp");
	} else {
		System.out.println("session no");
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
	<a href="./signin.jsp">다시 로그인하기</a>
</body>
</html>