<%@page import="java.util.Date"%>
<%@page import="mvc.db.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>memberView.jsp");

	List<MemberVO> memberList = null;
	if(request.getAttribute("memberList") != null){
		memberList = (List<MemberVO>) request.getAttribute("memberList");
	}
	
	String id;
	String password;
	String name;
	String email;
	int birthyear;
	String gender;
	String interest;
	Date joinDate;
	Date updateDate;
	String isActive;	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member view</title>
<style type="text/css">
	h1{
		text-align: center;
	}
	table{
		margin: auto;
		border: 1px solid black;
		border-collapse : collapse;
	}
	.tr1{
		background-color: gold;
		
	}
	.th{
		border: 1px solid black;
	}
	.td{
		border: 1px solid black;
	}
	.div_index{
		margin-top: 20px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>MEMBER VIEW</h1>
	<table>
		<tr class="tr1">
			<th class="th">id</th>
			<th class="th">password</th> 
			<th class="th">name</th> 
			<th class="th">email</th> 
			<th class="th">birthyear</th> 
			<th class="th">gender</th> 
			<th class="th">interest</th> 
			<th class="th">joinDate</th> 
			<th class="th">updateDate</th> 
			<th class="th">isActive</th>	
		</tr>
	<% 
		for(MemberVO member : memberList){
			id = member.getId();
			password = member.getPassword();
			name = member.getName();
			email = member.getEmail();
			birthyear = member.getBirthyear();
			gender = member.getGender();
			interest = member.getInterest();
			joinDate = member.getJoinDate();
			updateDate = member.getUpdateDate();
			isActive = member.getIsActive();
		
	%>
		<tr>
			<td class="td"><%= id %></td>
			<td class="td"><%= password %></td>
			<td class="td"><%= name %></td>
			<td class="td"><%= email %></td>
			<td class="td"><%= birthyear %></td>
			<td class="td"><%= gender %></td>
			<td class="td"><%= interest %></td>
			<td class="td"><%= joinDate %></td>
			<td class="td"><%= updateDate %></td>
			<td class="td"><%= isActive %></td>
		</tr>		
	<%
	}
	%>
	</table>
	<div class="div_index"><a href="../index.jsp">index페이지</a></div>
</body>
</html>