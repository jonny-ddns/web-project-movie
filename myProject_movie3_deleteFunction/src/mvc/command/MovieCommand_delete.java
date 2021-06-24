package mvc.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.MovieDao;

public class MovieCommand_delete implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_delete()");
			MovieDao mdao 	= MovieDao.getInstance();
			int movieCode = Integer.parseInt(request.getParameter("movieCode")); 
			mdao.movieDelete(movieCode);
			System.out.println("MovieCommand_delete() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_delete - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("MovieCommand_delete - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("MovieCommand_delete - Exception");
			e.printStackTrace();
		}		
	}
}
