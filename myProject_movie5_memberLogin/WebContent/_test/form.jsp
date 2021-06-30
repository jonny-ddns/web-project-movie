<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#formTest{	
		margin-top: 100px;
		text-align: center;
	}
</style>
</head>
<body>
	<form id="formTest" action="./form_result.jsp" method="post">
		<div>
			<select name="birthyear">
				<option value="2021">2021</option>
				<option value="2020">2020</option>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>
				<option value="2015">2015</option>
				<option value="2014">2014</option>
				<option value="2013">2013</option>
				<option value="2012">2012</option>
				<option value="2011">2011</option>
			</select>
		</div>
		<div>
			<input type="radio" name="gender" value="m" checked="checked">남성
			<input type="radio" name="gender" value="f">여성
			<input type="radio" name="gender" value="x">기타
		</div>
		<div>
			<input type="radio" name="animal" value="lion">사자
			<input type="radio" name="animal" value="tiger" checked="checked">호랑이
			<input type="radio" name="animal" value="jaguer">재규어
		</div>
		<div>
			<input type="radio" name="pen" value="sharp">샤프
			<input type="radio" name="pen" value="ballpoint">볼펜
			<input type="radio" name="pen" value="ink" checked="checked">유성펜
		</div>
		<br>
		<div>
			<input type="checkbox" name="interest" value="action" >액션<br>
			<input type="checkbox" name="interest" value="crime">범죄<br>
			<input type="checkbox" name="interest" value="mistery">미스터리<br>
			<input type="checkbox" name="interest" value="SF">SF<br>
			<input type="checkbox" name="interest" value="comedy">코미디<br>
			<input type="checkbox" name="interest" value="thriller">스릴러<br>
			<input type="checkbox" name="interest" value="horror">공포<br>
			<input type="checkbox" name="interest" value="war">전쟁물<br>
			<input type="checkbox" name="interest" value="sports">스포츠<br>
			<input type="checkbox" name="interest" value="fantasy">판타지<br>
			<input type="checkbox" name="interest" value="teenager">청춘물<br>
			<input type="checkbox" name="interest" value="drama">드라마<br>
			<input type="checkbox" name="interest" value="romantic">로맨스<br>
			<input type="checkbox" name="interest" value="music">음악<br>
			<input type="checkbox" name="interest" value="documentary">다큐멘터리<br>
		</div>
		<br>
		<input type="submit">
	</form>
</body>
</html>