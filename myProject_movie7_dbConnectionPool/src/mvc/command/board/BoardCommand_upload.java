package mvc.command.board;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.BoardDao;
import mvc.db.vo.BoardVO;

public class BoardCommand_upload implements BoardCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_upload()");

			BoardVO board = new BoardVO();
			board.setArtiTitle(request.getParameter("title"))
				 .setContent(request.getParameter("content"))
				 .setOpenPublic(request.getParameter("openPublic"));
			BoardDao dao = BoardDao.getInstance();
			dao.boardWrite(board);
			
			System.out.println("BoardCommand_list() end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch(SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
