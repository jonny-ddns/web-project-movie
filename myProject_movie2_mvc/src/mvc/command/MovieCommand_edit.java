package mvc.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.MovieDao;
import mvc.db.MovieDto;

public class MovieCommand_edit implements MovieCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_edit()");
			request.setCharacterEncoding("UTF-8");		
			int edit = 0;
			
			if(request.getParameter("edit") != null) {
				edit = Integer.parseInt(request.getParameter("edit"));	
			}
			
			//new movie upload
			if(edit == 1) {
				System.out.println("edit = 1");
				request.setAttribute("edit", edit);
			}
			//movie update
			else if(edit == 2) {
				System.out.println("edit = 2");
				MovieDao mdao = null;
				MovieDto movie = null;
				int movieCodeBefore = 0;	
				
				if(request.getParameter("movieCode") != null) {
					System.out.println("movieCode is not null");
					movieCodeBefore	= Integer.parseInt(request.getParameter("movieCode"));
					mdao			= MovieDao.getInstance();				
					movie			= mdao.movieSearchByCode(movieCodeBefore);
					
					request.setAttribute("edit", edit);
					request.setAttribute("movie", movie);
					request.setAttribute("movieCodeBefore", movieCodeBefore);
				} else {
					System.out.println("parameter movieCode error");
				}
			} else {
				System.out.println("parameter edit error");
			}
			System.out.println(">>MovieCommand_edit() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_edit - NullPointerException");
			npe.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println("MovieCommand_edit - NumberFormatException");
			nfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("MovieCommand_edit - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("MovieCommand_edit - Exception");
			e.printStackTrace();
		}
	}
}
