package mvc.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.dao.BoardDao;
import mvc.db.vo.BoardVO;

public class BoardCommand_read implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_read()");
			
			int artiNum = Integer.parseInt(request.getParameter("artiNum"));			
			BoardDao dao = BoardDao.getInstance();
			BoardVO board = dao.boardSearchByArtiNum(artiNum);
			request.setAttribute("artiNum", artiNum);
			request.setAttribute("board", board);
			System.out.println("BoardCommand_read() end");			
		} catch (NullPointerException npe) {
			System.out.println("BoardCommand_read - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("BoardCommand_read - Exception");
			e.printStackTrace();
		}		
	}
}
