<%@page import="dao.MovieDao"%>
<%@page import="dto.MovieDto"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	
	System.out.println("movieUpload_process.jsp");
	MovieDao mDao = new MovieDao();
	MovieDto movie = null;

	//영화 업로드 인자값 받기
	//String savePath = request.getServletContext().getRealPath();
	String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie/WebContent/movieThumbImage";
	int fileLimit = 1000*1024*1024;
	
	MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );

	int movieCode = Integer.parseInt(multi.getParameter("movieCode"));
	String title = multi.getParameter("title");
	String director = multi.getParameter("director");
	String actors = multi.getParameter("actors");
	String genre = multi.getParameter("genre");
	String content = multi.getParameter("content");
	int runningTime = Integer.parseInt(multi.getParameter("runningTime"));
	String rating = multi.getParameter("rating");
	int score = Integer.parseInt(multi.getParameter("score"));
	//String mPoster = multi.getParameter("mPoster");
	
	Enumeration<?> files = multi.getFileNames();
	String fileElement = (String) files.nextElement();
	String file_thumbNail = multi.getFilesystemName(fileElement);
	
	//movie 에 값 저장하기
	movie = new MovieDto();
	movie.setMovieCode(movieCode)
		 .setTitle(title)
		 .setDirector(director)
		 .setActors(actors)
		 .setGenre(genre)
		 .setContent(content)
		 .setRunningTime(runningTime)
		 .setRating(rating)
		 .setScore(score)
		 .setMoviePoster(file_thumbNail);

 	//DB 에 insert하는 메소드 호출해서 인자값 전달하기
 	mDao.movieInsert(movie); 	
 	System.out.println("movieUpload 완료");
 	
 	//화면전환하기
 	response.sendRedirect("./movieList.jsp");	
%>