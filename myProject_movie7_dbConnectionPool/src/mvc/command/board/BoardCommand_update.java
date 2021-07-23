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
import mvc.db.dao.BoardDao;
import mvc.db.dto.BoardDto;
import mvc.db.dto.MemberDto;

public class BoardCommand_update implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>BoardCommand_update()");
			request.setCharacterEncoding("UTF-8");
			
			System.out.println("1");
			HttpSession session = request.getSession();
			MemberDto member = (MemberDto) session.getAttribute("memberLogin");
			String id = member.getId();
			
			System.out.println("2");
			/*-----------------------------------------------------------------
				upload image file from <form> by using "MultipartRequest"
			-----------------------------------------------------------------*/
			String savePath = "D:/Programming/workspace/dynamicWebProject/myProject_movie7_dbConnectionPool/WebContent/resources/images/board";
			int fileLimit = 1000*1024*1024;
			MultipartRequest multi = new MultipartRequest( request, savePath, fileLimit, "UTF-8", new DefaultFileRenamePolicy() );
		
			System.out.println("3");
			Enumeration<?> files	= multi.getFileNames();
			String fName			= (String) files.nextElement();
			String boardImage		= multi.getFilesystemName(fName);
			BoardDto board 			= new BoardDto();
			
			
			System.out.println("4");
			//artiNum 가져오기
			int artiNum = Integer.parseInt(multi.getParameter("artiNum"));
			
			board.setArtiTitle(multi.getParameter("title"))
				 .setWriter(id)
				 .setOpenPublic(multi.getParameter("openPublic"))
				 .setImage(boardImage)
				 .setContent(multi.getParameter("content"))
				 .setIsActive("y");
			BoardDao dao = BoardDao.getInstance();
			dao.boardUpdate(board, artiNum);
			
			System.out.println("BoardCommand_update() end");
		} catch (NullPointerException npe) {
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
