<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	if(session.getAttribute("memberLogin") != null){
%>
	<div>
		<span style="margin-right: 20px;"><a href="./member/memberView.bo">전체회원현황</a></span>
	</div>

	<div style="text-align: right;">
		<span style="margin-right: 20px;"><a href="./member/signout.jsp">로그아웃</a></span>
		<span style="margin-right: 20px;"><a href="./member/memberVerify.jsp">회원정보 수정</a></span>
	</div>
<%
	} else{
%>
<div style="text-align: right;">
	<span style="margin-right: 20px;"><a href="./member/signin.jsp">로그인</a></span>
	<span style="margin-right: 20px;"><a href="./member/signup.jsp">회원가입</a></span>
</div>
<%
	}
		
%>
