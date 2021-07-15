<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="mvc.db.dto.DtoBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>boardList.jsp");
	String contextPath = request.getContextPath();	
	
	//날짜 표시하기
	List<DtoBoard> boardList = null;
	if(request.getAttribute("boardList") != null){
		boardList = (List<DtoBoard>) request.getAttribute("boardList");
	}
	int artiNum = 0;
	String artiDate = "";
	String artiTitle = "";
	String writer = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
<style type="text/css">
	
	h1{
		text-align: center;
	}
	
	.div_writeArticle{
		text-align: center;
		margin-left: 550px;
		margin-bottom: 20px;
	}
	.label_writeArticle{
		background-color: beige;
		font-size: 20px;
		color: red;
	}
	
	#tblBoard{
		border-collapse: collapse;
		margin: auto;
	}
	
	.thClass{
		border: 1px solid black;
	}
	
	.tdClass{
		border: 1px solid black;
	}
	
	#thArtiNum{
		width: 50px;
		text-align: center;
	}
	#thArtiTitle{
		width: 500px;
		text-align: center;
	}	
	#thWriter{
		width: 100px;
		text-align: center;
	}
	#thArtiDate{
		width: 180px;
		text-align: center;
	}
	
	#tdArtiNum{
		width: 50px;
		text-align: center;
	}
	#tdArtiTitle{
		width: 500px;
		text-align: left;
	}	
	#tdWriter{
		width: 100px;
		text-align: center;
	}
	#tdArtiDate{
		width: 180px;
		text-align: center;
	}

</style>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<h1>board list</h1>
	<div class="div_writeArticle">
		<label class="label_writeArticle">
			<a href="<%=contextPath%>/board/boardForm_write.jsp">글쓰기</a>
		</label>
	</div>	
	<div class="div_boardTable">
		<table id="tblBoard">
			<tr>
				<th class="thClass" id="thArtiNum">글번호</th>
				<th class="thClass" id="thArtiTitle">제목</th>
				<th class="thClass" id="thWriter">작성자</th>
				<th class="thClass" id="thArtiDate">작성날짜</th>
			</tr>
			<%
				for(DtoBoard board : boardList){
						artiNum = board.getArtiNum();
						artiTitle = board.getArtiTitle();
						writer = board.getWriter();
						artiDate = board.getArtiDate();
			%>		
				<tr>
					<td class="tdClass" id="tdArtiNum"><%= artiNum %></td>
					<td class="tdClass" id="tdArtiTitle"><a href=./read.co?artiNum=<%= artiNum %>><%= artiTitle %></a></td>
					<td class="tdClass" id="tdWriter"><%= writer %></td>
					<td class="tdClass" id="tdArtiDate"><%= artiDate %></td>				
				</tr>					
			<%	
				}
			%>
			</table>	
		</div>
</body>
</html>