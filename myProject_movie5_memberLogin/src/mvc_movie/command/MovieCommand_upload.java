package mvc_movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_movie.movieObject.MovieDao;
import mvc_movie.movieObject.MovieVO;

public class MovieCommand_upload implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_upload()");
			request.setCharacterEncoding("UTF-8");

			MovieDao mdao = MovieDao.getInstance();			
			MovieVO movie = (MovieVO) request.getAttribute("movie");
			
			int movieCode = movie.getMovieCode();
			request.setAttribute("movieCode", movieCode);
			
			mdao.movieInsert(movie);
			System.out.println(">>MovieCommand_upload() end");
		} catch (NullPointerException npe) {
			System.out.println("MovieCommand_upload - NullPointerException");
			npe.printStackTrace();
		} catch (Exception e) {
			System.out.println("MovieCommand_upload - Exception");
			e.printStackTrace();
		}		
	}
}
