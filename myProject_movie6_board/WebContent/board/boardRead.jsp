<%@page import="mvc.db.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>boardRead.jsp");
	BoardVO board = (BoardVO) request.getAttribute("board");
	int artiNum = board.getArtiNum();
	String artiDate = board.getArtiDate();
	String artiTitle = board.getArtiTitle();
	String content = board.getContent();
	String writer = board.getWriter();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board read</title>
</head>
<body>
	<h1>board read</h1>
	artiNum	<br>
	artiDate	<br>
	artiTitle	<br>
	content	<br>
	writer	<br>
</body>
</html>