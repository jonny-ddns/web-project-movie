package mvc.command.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.dao.DaoBoard;
import mvc.db.dto.DtoBoard;

public class BoardCommand_list implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		try {
			System.out.println(">>BoardCommand_list()");
			DaoBoard dao = DaoBoard.getInstance();
			List<DtoBoard> boardList = dao.getBoardAll();			
			request.setAttribute("boardList", boardList);
			System.out.println("BoardCommand_list() end");			
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
