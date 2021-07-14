package mvc.command.movie;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MovieDao;

public class MovieCommand_delete implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_delete()");
			MovieDao mdao = MovieDao.getInstance();
			int movieCode = Integer.parseInt(request.getParameter("movieCode"));
			mdao.movieDelete(movieCode);		
			System.out.println("MovieCommand_delete() - end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
