package mvc.command.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.dao.MovieDao;
import mvc.db.vo.MovieVO;

public class MovieCommand_edit implements MovieCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MovieCommand_edit()");
			MovieDao mdao = MovieDao.getInstance();
			int movieCode = 0;
			
			//parameter "movieCode" check
			if(request.getParameter("movieCode") != null){
				movieCode = Integer.parseInt(request.getParameter("movieCode"));
			} else {
				System.out.println("[error] movieCode is null");
			}
			MovieVO movie = mdao.movieSearchByCode(movieCode);
			
			request.setAttribute("movie", movie);
			request.setAttribute("movieCode", movieCode);
			
			System.out.println("MovieCommand_edit() end");
		} catch(NullPointerException npe) {
			System.out.println("MovieCommand_spec - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("MovieCommand_spec - Exception");
			e.printStackTrace();
		}
	}
}
