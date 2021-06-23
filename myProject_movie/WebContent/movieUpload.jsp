<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>movieUpload.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie upload</title>
</head>
<body>
	<h2>movie upload</h2>
	<form action="movieUpload_process.jsp" method="post" enctype="multipart/form-data">
		<div>
			<label>movieCode*</label>
			<input name="movieCode" type="text">
		</div>	
		<div>
			<label>title</label>
			<input name="title" type="text">
		</div>
		<div>		
			<label>director</label>
			<input name="director" type="text">
		</div>
		<div>
			<label>actors</label>
			<input name="actors" type="text">
		</div>
		<div>
			<label>genre</label>
			<input name="genre" type="text">
		</div>
		<div>		
			<label>content</label>
			<input name="content" type="text">
		</div>
		<div>		
			<label>runningTime*</label>
			<input name="runningTime" type="text">
		</div>
		<div>
			<label>rating</label>
			<input name="rating" type="text">
		</div>
		<div>		
			<label>score*</label>
			<input name="score" type="text">
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