package mvc_movie.command;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_movie.movieObject.MovieDao;
import mvc_movie.movieObject.MovieVO;

public class MovieCommand_list implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_list()");
			MovieDao mdao 	= MovieDao.getInstance();
			List<MovieVO> movieList = mdao.movieList();			
			request.setAttribute("movieList", movieList);
			System.out.println("MovieCommand_list() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_list - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("MovieCommand_list - Exception");
			e.printStackTrace();
		}
	}
}
