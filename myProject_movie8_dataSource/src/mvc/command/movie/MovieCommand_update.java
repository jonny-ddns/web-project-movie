package mvc.command.movie;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import mvc.db.dao.MovieDao;
import mvc.db.dto.MovieDto;

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
			String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie7_dbConnectionPool/WebContent/resources/images/movie";
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
			MovieDto movie = new MovieDto();
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
		} catch (NullPointerException npe) {
			System.out.println("NullPointerException");
			npe.getMessage();
		} catch (IOException ioe) {
			System.out.println("IOException");
			ioe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException");
			cnfe.getMessage();
		} catch (SQLException sqle) {
			System.out.println("SQLException");
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
