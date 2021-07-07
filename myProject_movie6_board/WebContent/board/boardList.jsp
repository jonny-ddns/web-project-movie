<%@page import="java.util.Date"%>
<%@page import="mvc_board.boardObject.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	System.out.println(">>boardList.jsp");
	List<BoardVO> boardList = null;
	if(request.getAttribute("boardList") != null){
		boardList = (List<BoardVO>) request.getAttribute("boardList");
	}
	int artiNum = 0;
	Date artiDate = null;
	String artiTitle = "";
	String writer = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
</head>
<body>
	<h1>board list</h1>
	<h2>게시판 end</h2>
	<% 
		for(BoardVO board : boardList){
			artiNum = board.getArtiNum();
			artiTitle = board.getArtiTitle();
			writer = board.getWriter();
			artiDate = board.getArtiDate();			
			%>
			<table>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
				</tr>
				<tr>
					<td>artiNum</td>
					<td>artiTitle</td>
					<td>writer</td>
					<td>artiDate</td>				
				</tr>
			</table>			
			<%	
		}
	%>
	<h2>게시판 end</h2>
</body>
</html>