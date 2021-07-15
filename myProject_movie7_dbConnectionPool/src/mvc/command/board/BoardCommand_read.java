package mvc.command.board;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.DaoBoard;
import mvc.db.dto.DtoBoard;

public class BoardCommand_read implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_read()");
			
			int artiNum = Integer.parseInt(request.getParameter("artiNum"));			
			DaoBoard dao = DaoBoard.getInstance();
			DtoBoard board = dao.boardSearchByArtiNum(artiNum);
			
			request.setAttribute("artiNum", artiNum);
			request.setAttribute("board", board);
			System.out.println("BoardCommand_read() end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (ClassNotFoundException cnfe) {
			cnfe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
