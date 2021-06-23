<%@page import="dto.MovieDto"%>
<%@page import="dao.MovieDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println("movieList.jsp");
	MovieDao mDao = new MovieDao();
	List<MovieDto> movieList = mDao.movieList();
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h2{
		text-align: center;
	}
	table{
		margin : auto;
		width : 500px;
		border: 1px solid red;		
	}
	.tr1{
		width: 200px;
	}
	.tr2{
		width: 600px;
	}
	
</style>
<meta charset="UTF-8">
<title>movie list</title>
</head>
<body>
	<h2>Movie List</h2>
	<jsp:include page="./menu.jsp" />		
	<%
		for(int i=0; i<movieList.size(); i++){
			int movieCode = movieList.get(i).getMovieCode();
			String title = movieList.get(i).getTitle();
			String genre = movieList.get(i).getGenre();
			String director = movieList.get(i).getDirector();
			String actors = movieList.get(i).getActors();
			int runningTime = movieList.get(i).getRunningTime();
			String rating = movieList.get(i).getRating();
			int score = movieList.get(i).getScore();
	%>
		
	<table>	
		<tr>
			<th class="tr1">title</th>
			<td class="tr2"><a href="./movieSpec.jsp?movieCode=<%= movieCode %>" ><%= title %></a></td>
		</tr>
		<tr>
			<th class="tr1">genre</th>
			<td class="tr2"><%= genre %></td>
		</tr>
		<tr>
			<th class="tr1">director</th>
			<td class="tr2"><%= director %></td>
		</tr>
		<tr>
			<th class="tr1">actors</th>
			<td class="tr2"><%= actors %></td>
		</tr>
		<tr>
			<th class="tr1">runningTime</th>
			<td class="tr2"><%= runningTime %></td>
		</tr>
		<tr>
			<th class="tr1">rating</th>
			<td class="tr2"><%= rating %></td>
		</tr>
		<tr>
			<th class="tr1">score</th>
			<td class="tr2"><%= score %></td>
		</tr>
	<% 
		}
	%>
	</table>
</body>
</html>