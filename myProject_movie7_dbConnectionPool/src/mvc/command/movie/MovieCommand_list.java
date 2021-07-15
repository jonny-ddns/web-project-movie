package mvc.command.movie;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.DaoMovie;
import mvc.db.dto.DtoMovie;

public class MovieCommand_list implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_list()");
			DaoMovie mdao = DaoMovie.getInstance();
			List<DtoMovie> movieList = mdao.movieList();
			request.setAttribute("movieList", movieList);
			System.out.println("MovieCommand_list() - end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
