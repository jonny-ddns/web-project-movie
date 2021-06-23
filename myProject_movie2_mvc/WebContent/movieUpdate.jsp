<%@page import="mvc.db.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	System.out.println(">>movieUpdate.jsp"); %>
<%! 
	int movieCodeBefore	= 0;
	int movieCode		= 0;
	String title		= "";
	String director		= "";
	String actors		= "";
	String genre		= "";
	String content		= "";
	int runningTime		= 0;
	String rating		= "";
	int score			= 0;
%>
<% 
	if(request.getParameter("movieCodeBefore") != null){
		System.out.println("조건2 true");	
		movieCodeBefore = Integer.parseInt(request.getParameter("movieCodeBefore")); //값을 가져와야 함
	}
	
	//기존 영화 수정이라면
	if(movieCode != 0) {		
		MovieDto movie = (MovieDto) request.getAttribute("movie");

		movieCodeBefore	= Integer.parseInt(request.getParameter("movieCode"));	
		movieCode		= movieCodeBefore;
		String title	= movie.getTitle();
		String director = movie.getDirector();
		String actors	= movie.getActors();
		String genre 	= movie.getGenre();
		String content 	= movie.getContent();
		int runningTime = movie.getRunningTime();
		String rating 	= movie.getRating();
		int score 		= movie.getScore();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie edit</title>
</head>
<body>
	<h2>movie edit</h2>
	<form action="./movieUpdate_process.jsp?movieCodeBefore=<%= movieCodeBefore %>" method="post">
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
			<input type="submit" value="등록하기">
			<input type="reset" value="취소하기">
		</div>
	</form>
</body>
</html>