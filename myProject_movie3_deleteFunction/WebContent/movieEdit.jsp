<%@page import="mvc.db.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	
	System.out.println(">>movieEdit.jsp");
	int edit			= 0;
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
	
	//edit value check
	if(request.getAttribute("edit") != null){
		edit = (int) request.getAttribute("edit");	
	}
	
	if(edit == 0){
		System.out.println("--parameter edit error");
	} else if(edit == 1){		
		System.out.println("new movie upload");
	} else if(edit == 2){
		System.out.println("existing movie update");
		
		MovieDto movie = null;
		
		if(request.getAttribute("movie") != null){
			movie 			= (MovieDto) request.getAttribute("movie");	
		}
		if(request.getAttribute("movieCodeBefore") != null){
			movieCodeBefore = (int) request.getAttribute("movieCodeBefore");
		}		
		if(movie == null || movieCodeBefore == 0){
			System.out.println("--parameter movie or movieCodeBefore error");
		}

		//get movie element
		movieCode 		= movieCodeBefore;
		title 			= movie.getTitle();
		director		= movie.getDirector();
		actors 			= movie.getActors();
		genre 			= movie.getGenre();
		content 		= movie.getContent();
		runningTime 	= movie.getRunningTime();
		rating 			= movie.getRating();
		score 			= movie.getScore();
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
	<form action="./movieEdit_process.jsp?edit=<%= edit %>" method="post">
		<div>
			<input name="movieCodeBefore" type="hidden" value="<%= movieCodeBefore %>">
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
			<input type="submit" value="등록하기">
			<input type="reset" value="취소하기">
		</div>
	</form>
</body>
</html>