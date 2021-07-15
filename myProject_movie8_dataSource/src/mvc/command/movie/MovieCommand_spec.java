package mvc.command.movie;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.DaoMovie;
import mvc.db.dto.DtoMovie;

public class MovieCommand_spec implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_spec()");
			DaoMovie mdao = DaoMovie.getInstance();
			int movieCode = 0;
			if(request.getParameter("movieCode") != null){
				movieCode = Integer.parseInt(request.getParameter("movieCode"));
			}
			DtoMovie movie = mdao.movieSearchByCode(movieCode);
			request.setAttribute("movie", movie);
			System.out.println("MovieCommand_spec() - end");
		} catch (NullPointerException npe) {
			System.out.println("MovieCommand_spec - NullPointerException");
			npe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch (SQLException sqle) {
			System.out.println("MovieCommand_spec - SQLException");
			sqle.getMessage();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}