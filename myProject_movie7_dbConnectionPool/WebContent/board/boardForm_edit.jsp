<%@page import="mvc.db.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>boardForm_edit.jsp");
	BoardDto board = (BoardDto)request.getAttribute("board");
	int artiNum = board.getArtiNum();
	String artiTitle = board.getArtiTitle();
	String content = board.getContent();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board write</title>
<style type="text/css">
	h1{
		text-align: center;
		margin-bottom: 50px;
	}	
	.writeCancel{
		padding-left: 400px;
		text-align: center;
	}
	.tblWrite{
		margin: auto;
		border: 1px solid black;
		padding-top: 20px;
		padding-right: 20px;
		padding-bottom: 30px;
		padding-left: 20px;
	}
	.trTitle{
		height: 60px;
	}
	.tdTitle{
		text-align: center;
		width: 150px;
	}
	.tdTitle_input{
		text-align: right;
	}
	.tdSelect{
		text-align: center;	
	}
	.tdSubmit{
		width: 80px;
		text-align: center;
	}
	
</style>
</head>
<body>
	<h1>board edit</h1>	
	<div class="writeCancel">
		<h4><a href="./read.co?artiNum=<%= artiNum %>">수정취소</a></h4>
	</div>
	<form action="./update.co" method="post" enctype="multipart/form-data">
 		<input type="hidden" name="artiNum" value="<%= artiNum %>">
		<table class="tblWrite">
			<tr class="trTitle">
				<td class="tdTitle">TITLE</td>
				<td class="tdTitle_input" colspan="2"><input type="text" name="title" size="40" value="<%= artiTitle %>"></td>
			</tr>
			<tr>
				<td class="tdTextarea" colspan="3">
					<textarea name="content" rows="12" cols="60">
						<%= content %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" height="50px"><input type="file" name="attachment" ></td>
			</tr>
			<tr>
				<td class="tdSelect">
					주제
					<select name="topic">
						<option value="movie">영화</option>
						<option value="hobby">취미</option>
						<option value="life">일상</option>
					</select>
				</td>
				<td class="tdSelect">
					공개여부
					<select name="openPublic">
						<option value="y">공개</option>
						<option value="n">비공개</option>
					</select>
				</td>
				<td class="tdSubmit">
					<input type="submit" value="수정 완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>