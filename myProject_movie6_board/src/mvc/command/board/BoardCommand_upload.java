package mvc.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.dao.BoardDao;
import mvc.db.vo.BoardVO;

public class BoardCommand_upload implements BoardCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_upload()");
			
			//µð¹ö±ë
			String str1 = request.getParameter("title");
			String str2 = request.getParameter("content");
			String str3 = request.getParameter("topic");
			String str4 = request.getParameter("openPublic");
			
			System.out.println("parameter È®ÀÎ");
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3);
			System.out.println(str4);
			
			
			BoardVO board = new BoardVO();
			board.setArtiTitle(request.getParameter("title"))
				 .setContent(request.getParameter("content"))
				 .setOpenPublic(request.getParameter("openPublic"))
				 ;
			
			
			BoardDao dao = BoardDao.getInstance();
			dao.boardWrite(board);
			
			System.out.println("BoardCommand_list() end");			
		} catch (NullPointerException npe) {
			System.out.println("BoardCommand_upload - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("BoardCommand_upload - Exception");
			e.printStackTrace();
		}
		
	}
}
