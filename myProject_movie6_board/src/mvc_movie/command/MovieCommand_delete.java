package mvc_movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_movie.movieObject.MovieDao;

public class MovieCommand_delete implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_delete()");
			MovieDao mdao 	= MovieDao.getInstance();
			int movieCode = Integer.parseInt(request.getParameter("movieCode")); 
			mdao.movieDelete(movieCode);
			System.out.println("MovieCommand_delete() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_delete - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("MovieCommand_delete - Exception");
			e.printStackTrace();
		}		
	}
}
