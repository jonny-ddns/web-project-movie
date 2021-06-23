<%@page import="dto.MovieDto"%>
<%@page import="dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>movieEdit.jsp");

	int movieCode = 0;
	if(request.getParameter("movieCode") != null){
		movieCode = Integer.parseInt(request.getParameter("movieCode"));	
	}
	
	//request.setAttribute("movieCodeBefore", movieCode);
	
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
<title>Insert title here</title>
</head>
<body>

	<h2>movie edit</h2>
	<form action="movieEdit_process.jsp" method="post" enctype="multipart/form-data">
		<div>
			<input name="movieCodeBefore" type="hidden" value="<%= movieCode %>">
		</div>
		<div>
			<input name="moviePosterBefore" type="hidden" value="<%= moviePoster %>">
		</div>		
		<div>
			<label>movieCode*</label>
			<input name="movieCode" type="text" value="<%= movieCode %>">
		</div>	
		<div>
			<label>title</label>
			<input name="title" type="text" value="<%= title %>">
		</div>
		<div>		
			<label>director</label>
			<input name="director" type="text" value="<%= director %>">
		</div>
		<div>
			<label>actors</label>
			<input name="actors" type="text" value="<%= actors %>">
		</div>
		<div>
			<label>genre</label>
			<input name="genre" type="text" value="<%= genre %>">
		</div>
		<div>		
			<label>content</label>
			<input name="content" type="text" value="<%= content %>">
		</div>
		<div>		
			<label>runningTime*</label>
			<input name="runningTime" type="text" value="<%= runningTime %>">
		</div>
		<div>
			<label>rating</label>
			<input name="rating" type="text" value="<%= rating %>">
		</div>
		<div>		
			<label>score*</label>
			<input name="score" type="text" value="<%= score %>">
		</div>
		<div>		
			<label>moviePoster</label>
			<input name="moviePoster" type="file">
		</div>
		<div>
			<input type="submit" value="등록하기">
			<input type="reset" value="취소하기">
		</div>
	</form>


</body>
</html>