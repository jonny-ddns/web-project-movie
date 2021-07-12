<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String contextPath = request.getContextPath();
%>

	<a href="<%= contextPath %>/board/list.co">게시판으로 이동</a>
<% 
	//로그인 했다면
	if(session.getAttribute("memberLogin") != null){
%>
		<div>
			<span style="margin-right: 20px;"><a href="<%= contextPath %>/member/memberView.bo">전체회원현황</a></span>
		</div>	
		<div style="text-align: right;">
			<span style="margin-right: 20px;"><a href="<%= contextPath %>/member/signout.jsp">로그아웃</a></span>
			<span style="margin-right: 20px;"><a href="<%= contextPath %>/member/memberVerify.jsp">회원정보 수정</a></span>
		</div>
<%
	//로그인  하지 않았다면
	} else{
%>
		<div style="text-align: right;">
			<span style="margin-right: 20px;"><a href="<%= contextPath %>/member/signin.jsp">로그인</a></span>
			<span style="margin-right: 20px;"><a href="<%= contextPath %>/member/signup.jsp">회원가입</a></span>
		</div>
<%
	}
		
%>
