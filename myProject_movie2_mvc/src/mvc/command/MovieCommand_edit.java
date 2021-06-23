package mvc.command;

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

			MovieDao mdao = null;
			MovieDto movie = null;
			int movieCode = 0;			
			
			//기존영화정보 수정이라면 DB에서 영화정보 가져오기
			if(request.getParameter("movieCode") != null) {
				movieCode	= Integer.parseInt(request.getParameter("movieCode"));
				mdao		= MovieDao.getInstance();				
				movie		= mdao.movieSearchByCode(movieCode);
				
				request.setAttribute("movie", movie);
				request.setAttribute("movieCodeBefore", movieCode);
			}					
			System.out.println(">>MovieCommand_edit() end");
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
