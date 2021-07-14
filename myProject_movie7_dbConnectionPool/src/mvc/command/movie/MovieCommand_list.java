package mvc.command.movie;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MovieDao;
import mvc.db.vo.MovieVO;

public class MovieCommand_list implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_list()");
			MovieDao mdao = MovieDao.getInstance();
			List<MovieVO> movieList = mdao.movieList();
			request.setAttribute("movieList", movieList);
			System.out.println("MovieCommand_list() - end");
		} catch(NullPointerException npe) {
			npe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
}
