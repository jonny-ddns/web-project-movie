package mvc.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.MovieDao;
import mvc.db.MovieDto;

public class MovieCommand_update implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_update()");
			request.setCharacterEncoding("UTF-8");
			
			MovieDao mdao = MovieDao.getInstance();
			
			int movieCodeBefore	= (int) request.getAttribute("movieCodeBefore");
			MovieDto movie		= (MovieDto) request.getAttribute("movie");
			
			mdao.movieEdit(movie, movieCodeBefore);			
			System.out.println(">>MovieCommand_update() end");
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
