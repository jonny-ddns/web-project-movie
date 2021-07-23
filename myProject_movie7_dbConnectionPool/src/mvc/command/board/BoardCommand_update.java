package mvc.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.dao.BoardDao;

public class BoardCommand_update implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>BoardCommand_update");
		
		BoardDao dao = BoardDao.getInstance();
//		dao.
		
		System.out.println("BoardCommand_update end");
	}
}
