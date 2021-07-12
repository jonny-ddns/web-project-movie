<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>board_temp.jsp");
	//response.sendRedirect("board/list.co");
	response.sendRedirect(request.getContextPath()+ "/board/list.co");
%>