package mvc.command.board;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.db.dao.BoardDao;
import mvc.db.vo.BoardVO;

public class BoardCommand_write implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_write()");
			request.setCharacterEncoding("UTF-8");			
			
			/*-----------------------------------------------------------------
				upload image file from <form> by using "MultipartRequest"
			-----------------------------------------------------------------*/
			String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie6_board/WebContent/boardThumbImage";
			int fileLimit = 1000*1024*1024;
			MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
			Enumeration<?> files	= multi.getFileNames();
			String fName			= (String) files.nextElement();
			String boardImage		= multi.getFilesystemName(fName);
			BoardVO board 			= new BoardVO();
						
			board.setArtiTitle(multi.getParameter("title"))
				 .setWriter(multi.getParameter("writer"))
				 .setOpenPublic(multi.getParameter("openPublic"))
				 .setImage(boardImage)
				 .setContent(multi.getParameter("content"))
				 .setIsActive("y");
		
			BoardDao dao = BoardDao.getInstance();
			dao.boardWrite(board);
			
			System.out.println("BoardCommand_write() end");			
		} catch (NullPointerException npe) {
			System.out.println("BoardCommand_write - NullPointerException");
			npe.getMessage();
		} catch (Exception e) {
			System.out.println("BoardCommand_write - Exception");
			e.printStackTrace();
		}		
	}
}
