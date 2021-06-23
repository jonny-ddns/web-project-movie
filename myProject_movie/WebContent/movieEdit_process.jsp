<%@page import="dto.MovieDto"%>
<%@page import="dao.MovieDao"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>movieEdit_process.jsp");

	String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie/WebContent/movieThumbImage";
	int fileLimit = 1000*1024*1024;
	
	MovieDao mDao = new MovieDao();
	MovieDto movie = new MovieDto();
	
	MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
	
	int movieCodeBefore = Integer.parseInt(multi.getParameter("movieCodeBefore"));

	//moviePoster 값 받아오기. 파일을 첨부하지 않았다면 이전파일 내용을 참고하도록 설정
	Enumeration<?> files = multi.getFileNames();
	String fName = (String) files.nextElement();
	String moviePoster = multi.getFilesystemName(fName);
	System.out.println("moviePoster1 : "+ moviePoster);
	if(moviePoster == null){
		moviePoster = multi.getParameter("moviePosterBefore");
	}
	
	System.out.println("moviePoster2 : "+ moviePoster);

	movie.setMovieCode(Integer.parseInt(multi.getParameter("movieCode")))
		 .setTitle(multi.getParameter("title"))
		 .setDirector(multi.getParameter("director"))
		 .setActors(multi.getParameter("actors"))
		 .setGenre(multi.getParameter("genre"))
		 .setContent(multi.getParameter("content"))
		 .setRunningTime(Integer.parseInt(multi.getParameter("runningTime")))
		 .setRating(multi.getParameter("rating"))
		 .setScore(Integer.parseInt(multi.getParameter("score")))
		 .setMoviePoster(moviePoster);
	
	mDao.movieEdit(movie, movieCodeBefore);	
	System.out.println("movieEdit 완료");
	
	response.sendRedirect("./movieList.jsp");
%>
