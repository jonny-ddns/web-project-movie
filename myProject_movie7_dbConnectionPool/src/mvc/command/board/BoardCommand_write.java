package mvc.command.board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import mvc.db.dao.DaoBoard;
import mvc.db.dto.DtoBoard;
import mvc.db.dto.DtoMember;

public class BoardCommand_write implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_write()");
			request.setCharacterEncoding("UTF-8");			
			
			HttpSession session = request.getSession();
			DtoMember member = (DtoMember) session.getAttribute("memberLogin");
			String id = member.getId();
			
			/*-----------------------------------------------------------------
				upload image file from <form> by using "MultipartRequest"
			-----------------------------------------------------------------*/
			String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie7_dbConnectionPool/WebContent/resources/images/board";
			int fileLimit = 1000*1024*1024;
			MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
		
			Enumeration<?> files	= multi.getFileNames();
			String fName			= (String) files.nextElement();
			String boardImage		= multi.getFilesystemName(fName);
			DtoBoard board 			= new DtoBoard();
			
			board.setArtiTitle(multi.getParameter("title"))
				 .setWriter(id)
				 .setOpenPublic(multi.getParameter("openPublic"))
				 .setImage(boardImage)
				 .setContent(multi.getParameter("content"))
				 .setIsActive("y");
			DaoBoard dao = DaoBoard.getInstance();
			dao.boardWrite(board);
			
			System.out.println("BoardCommand_write() end");
		}  catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
