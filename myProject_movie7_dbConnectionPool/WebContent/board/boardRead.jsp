<%@page import="mvc.db.dto.MemberDto"%>
<%@page import="mvc.db.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>boardRead.jsp");

	MemberDto member = (MemberDto) session.getAttribute("memberLogin");
	boolean isWriter = false;
	if(member.getId().equals(request.getParameter("writer"))){
		isWriter = true;
	}

	BoardDto board = (BoardDto) request.getAttribute("board");
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
<style>
	h1{
		text-align: center;
	}
	.div_button{
		text-align: center;
		margin-bottom: 20px;
	}
	table{
		margin: auto;
		border: 1px solid black;
		padding: 20px;
		border-collapse: collapse;
		width: 60%;
	}
	.tr_header{
		border: 1px solid black;
	}
	#th_title{		
		width: 80px;
	}
	#th_artiTitle{
		width: 400px;
		text-align: left;
		padding-left: 10px;
	}
	.tr_body{
		border: 1px solid black;
	}
	#th_artiNum{
		text-align: center;
	}
	#th_writer{
	 	text-align: left;
	 	padding-left: 10px;	
	}
	#th_artiDate{
		text-align: right;
		padding-right: 10px;
		width: 180px
	}
	.tr_content{
		height: 200px;
	}
</style>
</head>
<body>
	<h1>board read</h1>
	<div class="div_button">
	<% 
		if(isWriter){ 
	%>	
			<a href="./edit.co?artiNum=<%= artiNum %>">수정</a>&emsp;
	<%
		} 
	%>
	</div>
	<table>
		<tr>
			<th class="tr_header" id="th_title">TITLE</th>
			<th class="tr_header" id="th_artiTitle" colspan="2"><%= artiTitle %></th>
		</tr>
		<tr>
			<td class="tr_body" id="th_artiNum">글번호 <%= artiNum %></td>
			<td class="tr_body" id="th_writer">ID : <%= writer %></td>		
			<td class="tr_body" id="th_artiDate"><%= artiDate %></td>
		</tr>
		<tr>
			<td class="tr_content" colspan="3"><%= content %></td>
		</tr>
	</table>	
</body>
</html>	