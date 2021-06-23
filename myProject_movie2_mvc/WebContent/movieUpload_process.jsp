<%@page import="mvc.db.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>movieUpload_process.jsp");

	MovieDto movie = new MovieDto();
	movie.setMovieCode(Integer.parseInt(request.getParameter("movieCode")))
		 .setTitle(request.getParameter("title"))
		 .setDirector(request.getParameter("director"))
		 .setActors(request.getParameter("actors"))
		 .setGenre(request.getParameter("genre"))
		 .setContent(request.getParameter("content"))
		 .setRunningTime(Integer.parseInt(request.getParameter("runningTime")))
		 .setRating(request.getParameter("rating"))
		 .setScore(Integer.parseInt(request.getParameter("score")));
	
	session.setAttribute("movie", movie);
	response.sendRedirect("./upload.do");
%>