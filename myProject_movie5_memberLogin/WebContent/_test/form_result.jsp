<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()){
		System.out.println(en.nextElement());
	}
	
	
	String by = request.getParameter("birthyear");
	String ge = request.getParameter("gender");
	String an = request.getParameter("animal");
	String pe = request.getParameter("pen");
	String inte = request.getParameter("interest");
	String[] intes = request.getParameterValues("interest");
	
	for(String st : intes){
		System.out.println("--" + st);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		text-align: center;
	}
</style>
</head>
<body>
	<h2><%= by %></h2>
	<h2><%= ge %></h2>
	<h2><%= an %></h2>
	<h2><%= pe %></h2>
	<h2><%= inte %></h2>
</body>
</html>