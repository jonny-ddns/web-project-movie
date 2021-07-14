<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
	System.out.println(">>signout.jsp");
	session.removeAttribute("memberLogin");
	response.sendRedirect("../index.jsp");
%>