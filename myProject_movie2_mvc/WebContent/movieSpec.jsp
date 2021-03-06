<%@page import="mvc.db.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>movieSpec.jsp");
	MovieDto movie = (MovieDto)request.getAttribute("movie");	

	int movieCode	= movie.getMovieCode();
 	String title 	= movie.getTitle();
	String director	= movie.getDirector();
	String actors	= movie.getActors();
	String genre	= movie.getGenre();
	String content	= movie.getContent();
	int runningTime	= movie.getRunningTime();
	String rating	= movie.getRating();
	int score		= movie.getScore();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie spec</title>
<style type="text/css">
	h2{
		text-align: center;
	}
	table{
		margin : auto;
		width : 500px;
		border: 1px solid black;
		border-collapse : collapse;
	}
	.th1{
		background-color: gold;
	}
	.th2{
		background-color: LemonChiffon;
		border: 1px solid black;
	}
	
	.td1{
		width: 130px;
		border: 1px solid black;
		text-align: center;
		background-color: gold;
	}
	.td2{
		width: 900px;
		border: 1px solid black;
	}
	.img1{
		float: left; 
		padding-right: 10px;
		padding-bottom: 5px;		
	}
	.a1{
		text-align: center;
	}
	
</style>
</head>
<body>
	<h2>movie spec</h2>
	
	<table>
	
	<tr>
		<th class="th1">TITLE</th>
		<th class="th2"><%= title %></th>
	</tr>
	<tr>
		<td class="td1">Director</td>
		<td class="td2"><%= director %></td>
	</tr>
	<tr>
		<td class="td1">ACTORS</td>
		<td class="td2"><%= actors %></td>
	</tr>
	<tr>
		<td class="td1">GENRE</td>
		<td class="td2"><%= genre %></td>
	</tr>
	<tr>
		<td class="td1">RunningTime</td>
		<td class="td2"><%= runningTime %></td>
	</tr>
	<tr>
		<td class="td1">RATING</td>
		<td class="td2"><%= rating %></td>
	</tr>
	<tr>
		<td class="td1">SCORE</td>
		<td class="td2"><%= score %></td>
	</tr>
	</table>	
	
	<br>
	<div class="a1">	
		<span><a href="./edit.do?edit=2&movieCode=<%= movieCode %>">영화내용 수정하기</a></span>&emsp;&emsp;&emsp;
		<span><a href="./list.do">목록으로 이동하기</a></span>
	</div>
</body>
</html>