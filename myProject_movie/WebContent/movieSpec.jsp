<%@page import="dto.MovieDto"%>
<%@page import="dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>movieSpec.jsp");
	
	int movieCode = 0;
	if(request.getParameter("movieCode") != null){
		movieCode = Integer.parseInt(request.getParameter("movieCode"));	
	}
	
	MovieDao mDao = new MovieDao();
	MovieDto movie = mDao.movieSearchByCode(movieCode);	
	
	String title = movie.getTitle();
	String director = movie.getDirector();
	String actors = movie.getActors();
	String genre = movie.getGenre();
	String content = movie.getContent();
	int runningTime = movie.getRunningTime();
	String rating = movie.getRating();
	int score = movie.getScore();
	String moviePoster = movie.getMoviePoster();	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie spec</title>
</head>
<body>
	<h2>movie spec</h2>
	<p><%= title %></p>
	<p><%= director %></p>
	<p><%= actors %></p>
	<p><%= genre %></p>
	<p><%= content %></p>
	<p><%= runningTime %></p>
	<p><%= rating %></p>
	<p><%= score %></p>
	
	<img alt="이미지" src="./movieThumbImage/<%= moviePoster %>">
	<p><%= moviePoster %></p>
	<a href="./movieEdit.jsp?movieCode=<%= movieCode %>">영화내용 수정하기</a><br>
	<a href="./movieList.jsp">목록으로 이동하기</a>
</body>
</html>