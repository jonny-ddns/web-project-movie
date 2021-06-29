package mvc_movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_movie.movieObject.MovieDao;
import mvc_movie.movieObject.MovieVO;

public class MovieCommand_update implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_update()");
			request.setCharacterEncoding("UTF-8");
			
			MovieDao mdao = MovieDao.getInstance();
			
			int movieCodeBefore	= (int) request.getAttribute("movieCodeBefore");
			MovieVO movie		= (MovieVO) request.getAttribute("movie");
			
			mdao.movieEdit(movie, movieCodeBefore);		
			request.setAttribute("movieCode", movieCodeBefore);
			System.out.println(">>MovieCommand_update() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_update - NullPointerException");
			npe.printStackTrace();
		} catch (Exception e) {
			System.out.println("MovieCommand_update - Exception");
			e.printStackTrace();
		}
	}
}
