<%@page import="java.util.List"%>
<%@page import="mvc.db.dto.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>movieList.jsp");
	String contextPath = request.getContextPath();

	List<MovieDto> list = (List) request.getAttribute("movieList");
	
	int movieCode	= 0;
	String title	= "";
	String genre	= "";
	String director = "";
	String actors	= "";
	int runningTime = 0;
	String rating	= "";
	int score		= 0;
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{
		text-align: center;
	}
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
	<jsp:include page="/menu.jsp"></jsp:include>
	<h1>movie list</h1>		
	<h3 style="text-align: right; margin-right: 150px;"><a href="./movieForm_new.jsp">영화 신규등록하기</a></h3>
	<%
		for(MovieDto movie : list){
		movieCode	= movie.getMovieCode();
		title 		= movie.getTitle();
		genre 		= movie.getGenre();
		director 	= movie.getDirector();
		actors 		= movie.getActors();
		runningTime = movie.getRunningTime();
		rating 		= movie.getRating();
		score 		= movie.getScore();
	%>	

	<table>	
		<tr>
			<th class="tr1">TITLE</th>
			<td class="tr2"><a href="./spec.do?movieCode=<%= movieCode %>"><%= title %></a></td>
		</tr>
		<tr>
			<th class="tr1">MovieCode</th>
			<td class="tr2"><%= movieCode %></td>
		</tr>		
		<tr>
			<th class="tr1">GENRE</th>
			<td class="tr2"><%= genre %></td>
		</tr>
		<tr>
			<th class="tr1">DIRECTOR</th>
			<td class="tr2"><%= director %></td>
		</tr>
		<tr>
			<th class="tr1">ACTORS</th>
			<td class="tr2"><%= actors %></td>
		</tr>
		<tr>
			<th class="tr1">RunningTime</th>
			<td class="tr2"><%= runningTime %></td>
		</tr>
		<tr>
			<th class="tr1">RATING</th>
			<td class="tr2"><%= rating %></td>
		</tr>
		<tr>
			<th class="tr1">SCORE</th>
			<td class="tr2"><%= score %></td>
		</tr>
	<% 
		}	
	%>
	</table>	
</body>
</html>