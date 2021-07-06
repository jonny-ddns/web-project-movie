package mvc_movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_movie.movieObject.MovieDao;
import mvc_movie.movieObject.MovieVO;

public class MovieCommand_spec implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_spec()");
			MovieDao mdao = MovieDao.getInstance();
			int movieCode = 0;
			if(request.getParameter("movieCode") != null){
				movieCode = Integer.parseInt(request.getParameter("movieCode"));
			}
			MovieVO movie = mdao.movieSearchByCode(movieCode);
			request.setAttribute("movie", movie);
			System.out.println("MovieCommand_spec() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_spec - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("MovieCommand_spec - Exception");
			e.printStackTrace();
		}		
	}
}
