package mvc.command;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.MovieDao;
import mvc.db.MovieDto;

public class MovieCommand_list implements MovieCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_list()");
			MovieDao mdao 	= MovieDao.getInstance();
			List<MovieDto> movieList = mdao.movieList();			
			request.setAttribute("movieList", movieList);
			System.out.println("MovieCommand_list() end");
		} catch (SQLException sqle) {			
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
