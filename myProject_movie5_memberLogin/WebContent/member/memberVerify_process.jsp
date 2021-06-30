<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>memberVerify_process.jsp");
	boolean compareResult = false;
	if(request.getParameter("compareResult") != null){
		compareResult = Boolean.parseBoolean(request.getParameter("compareResult"));
	};
	
	
	if(!compareResult){
		response.sendRedirect("./memberVerify.jsp");
	} else{
		response.sendRedirect("./memberEdit_form.jsp");
	}
	//일치하면 폼
	//불일치하면 다시 로그인 페이지
%>


