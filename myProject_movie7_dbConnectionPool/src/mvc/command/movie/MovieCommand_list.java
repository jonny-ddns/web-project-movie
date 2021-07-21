package mvc.command.movie;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MovieDao;
import mvc.db.dto.MovieDto;

public class MovieCommand_list implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_list()");
			MovieDao mdao = MovieDao.getInstance();
			List<MovieDto> movieList = mdao.movieList();
			request.setAttribute("movieList", movieList);
			System.out.println("MovieCommand_list() end");
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
