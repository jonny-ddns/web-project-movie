<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>movieForm_result.jsp");
	String movieCode = request.getParameter("movieCode");
	response.sendRedirect("./spec.do?movieCode="+movieCode);
%>