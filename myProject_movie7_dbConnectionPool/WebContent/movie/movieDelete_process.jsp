<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println("movieDelete_process.jsp");
	String movieCode = request.getParameter("movieCode");
	String viewPage = "";

	if(session.getAttribute("memberLogin") != null){
		viewPage = "./delete.do?movieCode="+movieCode;
	} else{
		viewPage = request.getContextPath()+ "/member/signin.jsp";
		//response.sendRedirect(request.getContextPath()+ "/member/signin.jsp");
	}

	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	//response.sendRedirect(viewPage);
	dispatcher.forward(request, response);			
%>
