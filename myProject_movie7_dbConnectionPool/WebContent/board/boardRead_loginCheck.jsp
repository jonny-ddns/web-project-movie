<%@page import="mvc.db.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println("boardRead_loginCheck.jsp");

	System.out.println("artiNum : "+ request.getParameter("artiNum"));

	int artiNum = Integer.parseInt(request.getParameter("artiNum"));
	System.out.println("artiNum : "+ artiNum);
	
	if(session.getAttribute("memberLogin") != null){
		MemberDto member = (MemberDto) session.getAttribute("memberLogin");
		String viewPage = null;
		if(member.getId().equals(request.getParameter("writer"))){
			System.out.println("111");
			viewPage = "edit.co?artiNum="+ artiNum;
		} else{
			//response.sendRedirect(request.getContextPath()+"/read.co?artiNum="+artiNum);
			System.out.println("222");
			viewPage = "read.co?artiNum="+ artiNum;
		}		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	} else{
		response.sendRedirect(request.getContextPath()+"/member/signin.jsp");
	}
%>