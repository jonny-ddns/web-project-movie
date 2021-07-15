package mvc.command.movie;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import mvc.db.dao.DaoMovie;
import mvc.db.dto.DtoMovie;

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
			String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie6_board/WebContent/resources/images/movie";
			int fileLimit = 1000*1024*1024;
			MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
			Enumeration<?> files	= multi.getFileNames();
			String fName			= (String) files.nextElement();
			String moviePoster		= multi.getFilesystemName(fName);
			
			//form���� moviePoster�� ���ε����� �ʾ����� ���� �����͸� ����ϱ� 
			if(moviePoster == null) {
				moviePoster = moviePosterBefore;
			}
			int movieCode = Integer.parseInt(multi.getParameter("movieCode"));
			
			//������Ʈ�� ��ü �����ϱ�
			DtoMovie movie = new DtoMovie();
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
			
			DaoMovie mdao = DaoMovie.getInstance();
			mdao.movieUpdate(movie, movieCodeBefore);
			
			request.setAttribute("movieCode", movieCode);
			System.out.println(">>MovieCommand_update() - end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (IOException ioe) {
			ioe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}