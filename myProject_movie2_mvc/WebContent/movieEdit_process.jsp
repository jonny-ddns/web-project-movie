<%@page import="mvc.db.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	System.out.println(">>movieEdit_process.jsp");
	int movieCodeBefore = Integer.parseInt(request.getParameter("movieCodeBefore"));

	System.out.println(">>movieCodeBefore : "+ request.getParameter("movieCodeBefore"));	

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
	request.setAttribute("movie", movie);
		
	if(movieCodeBefore != 99999999){
		request.setAttribute("movieCodeBefore", movieCodeBefore);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.do");
		dispatcher.forward(request, response);
	} else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("upload.do");
		dispatcher.forward(request, response);
	}	
%>