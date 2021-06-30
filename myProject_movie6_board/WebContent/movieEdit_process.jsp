<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="mvc_movie.movieObject.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println(">>movieEdit_process.jsp");	
	
	request.setCharacterEncoding("UTF-8");
	
	//check if parameter edit is valid
	int edit = 0;
	if(request.getParameter("edit") != null){
		edit = Integer.parseInt(request.getParameter("edit"));
	}
	if(edit == 0){
		System.out.println("parameter edit error");		
 	}
	
	/*-----------------------------------------------------------------
		upload image file from <form> by using "MultipartRequest"
	-----------------------------------------------------------------*/
	String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie6_board/WebContent/movieThumbImage";
	int fileLimit = 1000*1024*1024;
	MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
	
	Enumeration<?> files	= multi.getFileNames();
	String fName			= (String) files.nextElement();
	String moviePoster		= multi.getFilesystemName(fName);	
	
	//기존 포스터 수정시 업로드된 파일이 없다면 기존파일 참고
	String moviePosterBefore = "";
	if(multi.getParameter("moviePosterBefore") != null){
		moviePosterBefore = multi.getParameter("moviePosterBefore");
	}	
	if(moviePoster == null){
		moviePoster = moviePosterBefore;
	}

	/*-----------------------------------------------------------------
				apply <form> content
	-----------------------------------------------------------------*/
	RequestDispatcher dispatcher;
	MovieVO movie = new MovieVO();
		
	movie.setMovieCode(Integer.parseInt(multi.getParameter("movieCode")))
		 .setTitle(multi.getParameter("title"))
		 .setDirector(multi.getParameter("director"))
		 .setActors(multi.getParameter("actors"))
		 .setGenre(multi.getParameter("genre"))			
		 .setContent(multi.getParameter("content"))
		 .setRunningTime(Integer.parseInt(multi.getParameter("runningTime")))		
		 .setRating(multi.getParameter("rating"))
		 .setScore(Integer.parseInt(multi.getParameter("score")))
		 .setMoviePoster(moviePoster)
		 .setIsActive("y") ;
	
	request.setAttribute("movie", movie);
	
	//edit의 인자값에 따른 분기	
	if(edit == 1){
		System.out.println("new movie upload");			
		dispatcher = request.getRequestDispatcher("upload.do");
		dispatcher.forward(request, response);
	}
	else if(edit == 2){
		System.out.println("existing movie update");
		int movieCodeBefore = Integer.parseInt(multi.getParameter("movieCodeBefore"));
		request.setAttribute("movieCodeBefore", movieCodeBefore);		
		dispatcher = request.getRequestDispatcher("update.do");
		dispatcher.forward(request, response);
	}
%>