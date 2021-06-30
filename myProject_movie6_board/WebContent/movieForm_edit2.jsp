<%@page import="mvc_movie.movieObject.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>movieForm_edit2.jsp");
	MovieVO movie = (MovieVO) request.getAttribute("movie");
	
	int movieCode = movie.getMovieCode();
	String title = movie.getTitle();
	int runningTime = movie.getRunningTime();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie edit</title>
</head>
<body>
	<h2>movie edit</h2>
	<h3><%= movieCode %></h3>
	<h3><%= title %></h3>
	<h3><%= runningTime %></h3>
</body>
</html>