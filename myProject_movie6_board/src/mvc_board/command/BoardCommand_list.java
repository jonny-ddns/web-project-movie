package mvc_board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc_board.boardObject.BoardDao;
import mvc_board.boardObject.BoardVO;

public class BoardCommand_list implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		try {
			System.out.println(">>BoardCommand_list()");
			BoardDao dao = BoardDao.getInstance();
			List<BoardVO> boardList = dao.getBoardAll();			
			request.setAttribute("boardList", boardList);
			System.out.println("BoardCommand_list() end");			
		} catch (NullPointerException npe) {
			System.out.println("BoardCommand_list - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("BoardCommand_list - Exception");
			e.printStackTrace();
		}
	}
}
