<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="mvc.db.MovieDto"%>
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
	
	String moviePosterBefore = "";
	if(request.getParameter("moviePosterBefore") != null){
		moviePosterBefore = request.getParameter("moviePosterBefore");
	}
	
	
	/*-----------------------------------------------------------------
		upload image file from <form> by using "MultipartRequest"
	-----------------------------------------------------------------*/
	String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie4_image/WebContent/movieThumbImage";
	int fileLimit = 1000*1024*1024;
	MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
	
	Enumeration<?> files	= multi.getFileNames();
	String fName			= (String) files.nextElement();
	String moviePoster		= multi.getFilesystemName(fName);
	
	/*-----------------------------------------------------------------
						apply <form> content
	-----------------------------------------------------------------*/
	RequestDispatcher dispatcher;
	MovieDto movie = new MovieDto();
	
	movie.setMovieCode(Integer.parseInt(multi.getParameter("movieCode")))
		 .setTitle(multi.getParameter("title"))
		 .setDirector(multi.getParameter("director"))
		 .setActors(multi.getParameter("actors"))
		 .setGenre(multi.getParameter("genre"))			
		 .setContent(multi.getParameter("content"))
		 .setRunningTime(Integer.parseInt(multi.getParameter("runningTime")))		
		 .setRating(multi.getParameter("rating"))
		 .setScore(Integer.parseInt(multi.getParameter("score")));
	
	//인자값 moviePoster 변환코드. 기존 영화정보 수정인데, 파일을 첨부하지 않은 경우 기존 포스터를 참고함
	if(moviePoster == null){
		movie.setMoviePoster(moviePosterBefore);
	}
	request.setAttribute("movie", movie);	
	
	//edit의 인자값에 따른 분기	
	if(edit == 1){
		System.out.println("new movie upload");			
		dispatcher = request.getRequestDispatcher("upload.do");
		dispatcher.forward(request, response);
	} else if(edit == 2){
		System.out.println("existing movie update");
		int movieCodeBefore = Integer.parseInt(multi.getParameter("movieCodeBefore"));
		request.setAttribute("movieCodeBefore", movieCodeBefore);		
		dispatcher = request.getRequestDispatcher("update.do");
		dispatcher.forward(request, response);
	}
%>