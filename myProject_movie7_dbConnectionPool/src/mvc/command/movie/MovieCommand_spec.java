package mvc.command.movie;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MovieDao;
import mvc.db.dto.MovieDto;

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
			MovieDto movie = mdao.movieSearchByCode(movieCode);
			request.setAttribute("movie", movie);
			System.out.println("MovieCommand_spec() end");
		} catch (NullPointerException npe) {
			System.out.println("NullPointerException");
			npe.getMessage();
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