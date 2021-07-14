<%@page import="mvc.db.vo.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>movieForm_edit.jsp");
	
	if(session.getAttribute("memberLogin") == null){
		response.sendRedirect(request.getContextPath()+ "/member/signin.jsp");
	}
	
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
	String moviePosterBefore = "";
	
	MovieVO movie = null;
	
	if(request.getAttribute("movie") != null){
		movie = (MovieVO) request.getAttribute("movie");	
	}
	if(request.getParameter("movieCode") != null){
		movieCodeBefore = Integer.parseInt(request.getParameter("movieCode"));
	}		
	if(movie == null || movieCodeBefore == 0){
		System.out.println("[error] parameter movie or movieCodeBefore is null");
	}
	
	movieCode 		= movieCodeBefore;
	title 			= movie.getTitle();
	director		= movie.getDirector();
	actors 			= movie.getActors();
	genre 			= movie.getGenre();
	content 		= movie.getContent();
	runningTime 	= movie.getRunningTime();
	rating 			= movie.getRating();
	score 			= movie.getScore();
	moviePosterBefore = movie.getMoviePoster();
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movieForm edit</title>
<style type="text/css">
	h2{
		text-align: center;
	}
	table{
		margin : auto;
		border: 1px solid black;
		border-collapse : collapse;	
	}
	.td1{
		width: 130px;
		border: 1px solid black;
		text-align: center;
		background-color: gold;
	}
	.td2{
		/* width: 120px; */
		border: 1px solid black;
	}
	.span1{
		padding-right: 10px;
		margin-left: 100px;
	}
	.span2{
		float: right;
	}
	.label02{
		font-size: 8px;
	}
	.div_asterisk{
		text-align: left;
		margin-bottom: 10px;
	}
	.div_formButton{
		margin-right: 10px;
	}
</style>
</head>
<body>
	<jsp:include page="/menu.jsp"></jsp:include>
	<h2>movieForm edit</h2>
	<form action="./update.do?movieCodeBefore=<%= movieCodeBefore %>&moviePosterBefore=<%= moviePosterBefore %>" method="post" enctype="multipart/form-data">
		<table>			
			<tr>
				<td class="td1"><label>MovieCode*</label></td>
				<td class="td2"><input name="movieCode" type="text" size="35px" value="<%= movieCode %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>TITLE</label></td>
				<td class="td2"><input name="title" type="text" size="35px" value="<%= title %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>DIRECTOR</label></td>
				<td class="td2"><input name="director" type="text" size="35px" value="<%= director %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>ACTORS</label></td>
				<td class="td2"><input name="actors" type="text" size="35px" value="<%= actors %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>GENRE</label></td>
				<td class="td2"><input name="genre" type="text" size="35px" value="<%= genre %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>RunningTime*</label></td>
				<td class="td2"><input name="runningTime" type="text" size="35px" value="<%= runningTime %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>RATING</label></td>
				<td class="td2"><input name="rating" type="text" size="35px" value="<%= rating %>"></td>
			</tr>
			
			<tr>
				<td class="td1"><label>SCORE*</label></td>
				<td class="td2"><input name="score" type="text" size="35px" value="<%= score %>"></td>
			</tr>
			<tr>
				<td class="td1"><label>MoviePoster*</label></td>
				<td class="td2"><input name="moviePoster" type="file"></td>
			</tr>
			<tr>
				<td class="td1"><label>CONTENT</label></td>
				<td class="td2">
					<textarea class="textArea1" name="content" rows="16" cols="32">
						<%= content  %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="div_asterisk">
						<label class="label02">*input only number</label>
					</div>
					<div class="div_formButton">
						<span class="span1">
							<input type="submit" value="Submit">
							<input type="reset" value="Re">
						</span>
						<span class="span2">
							<a href="./list.do?">Input Cancel</a>
						</span>
					</div>
				</td>	
			</tr>			
		</table>
	</form>	
</body>
</html>