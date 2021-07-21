package mvc.command.movie;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.DaoMovie;
import mvc.db.dto.DtoMovie;

public class MovieCommand_edit implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_edit()");
			DaoMovie mdao = DaoMovie.getInstance();
			int movieCode = 0;
			
			//parameter "movieCode" check
			if(request.getParameter("movieCode") != null){
				movieCode = Integer.parseInt(request.getParameter("movieCode"));
			} else {
				System.out.println("[error] movieCode is null");
			}
			DtoMovie movie = mdao.movieSearchByCode(movieCode);
			
			request.setAttribute("movie", movie);
			request.setAttribute("movieCode", movieCode);
			
			System.out.println("MovieCommand_edit() end");
		} catch (NullPointerException npe) {
			System.out.println("NullPointerException");
			npe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException");
			cnfe.getMessage();
		} catch(SQLException sqle) {
			System.out.println("SQLException");
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
