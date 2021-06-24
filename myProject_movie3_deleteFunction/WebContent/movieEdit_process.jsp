<%@page import="mvc.db.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	System.out.println(">>movieEdit_process.jsp");	
	request.setCharacterEncoding("UTF-8");
	RequestDispatcher dispatcher;
	MovieDto movie = new MovieDto();
	
	int edit = 0;
	if(request.getParameter("edit") != null){
		edit = Integer.parseInt(request.getParameter("edit"));
	}
		
	if(edit == 0){
		System.out.println("parameter edit error");		
 	} 
	
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
	
	if(edit == 1){
		System.out.println("new movie upload");			
		dispatcher = request.getRequestDispatcher("upload.do");
		dispatcher.forward(request, response);
	} else if(edit == 2){
		System.out.println("existing movie update");
		int movieCodeBefore = Integer.parseInt(request.getParameter("movieCodeBefore"));
		request.setAttribute("movieCodeBefore", movieCodeBefore);		
		dispatcher = request.getRequestDispatcher("update.do");
		dispatcher.forward(request, response);
	}
%>