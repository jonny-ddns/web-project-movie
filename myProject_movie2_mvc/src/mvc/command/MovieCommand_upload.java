package mvc.command;

//import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.MovieDao;
//import mvc.db.MovieDto;
import mvc.db.MovieDto;

public class MovieCommand_upload implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_upload()");
			request.setCharacterEncoding("UTF-8");

			MovieDao mdao = MovieDao.getInstance();			
			MovieDto movie = (MovieDto) request.getAttribute("movie");
			
			mdao.movieInsert(movie);
		}  catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
