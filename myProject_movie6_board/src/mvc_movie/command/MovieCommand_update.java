package mvc_movie.command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc_movie.movieObject.MovieDao;
import mvc_movie.movieObject.MovieVO;

public class MovieCommand_update implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_update()");
			request.setCharacterEncoding("UTF-8");
			
			int movieCodeBefore = 0;
			String moviePosterBefore = "";
			
			//check parameter is null
			if(request.getParameter("movieCodeBefore") != null) {
				movieCodeBefore = Integer.parseInt(request.getParameter("movieCodeBefore"));	
			} else {
				System.out.println("[error] parameter movieCodeBefore is null");
			}
			
			if(request.getParameter("moviePosterBefore") != null) {
				moviePosterBefore = request.getParameter("moviePosterBefore");	
			} else {
				System.out.println("[error] parameter moviePosterBefore is null");
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
			
			//form으로 moviePoster를 업로드하지 않았으면 기존 포스터를 사용하기 
			if(moviePoster == null) {
				moviePoster = moviePosterBefore;
			}
						
			int movieCode = Integer.parseInt(multi.getParameter("movieCode"));
			
			//업데이트할 객체 생성하기
			MovieVO movie = new MovieVO();
			movie.setMovieCode(movieCode)
				 .setTitle(multi.getParameter("title"))
				 .setDirector(multi.getParameter("director"))
				 .setActors(multi.getParameter("actors"))
				 .setGenre(multi.getParameter("genre"))			
				 .setContent(multi.getParameter("content"))
				 .setRunningTime(Integer.parseInt(multi.getParameter("runningTime")))		
				 .setRating(multi.getParameter("rating"))
				 .setScore(Integer.parseInt(multi.getParameter("score")))
				 .setMoviePoster(moviePoster)
				 .setIsActive("y");
			request.setAttribute("movie", movie);			
			
			MovieDao mdao = MovieDao.getInstance();			
			mdao.movieUpdate(movie, movieCodeBefore);
			
			request.setAttribute("movieCode", movieCode);
			System.out.println(">>MovieCommand_update() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_update - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("MovieCommand_update - Exception");
			e.printStackTrace();
		}
	}
}
