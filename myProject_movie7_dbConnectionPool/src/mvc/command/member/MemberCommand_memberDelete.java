package mvc.command.member;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.DaoMember;

public class MemberCommand_memberDelete implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_memberDelete()");	
			String id = request.getParameter("id");
			DaoMember mdao = DaoMember.getInstance();
			mdao.memberDelete(id);
			System.out.println("MemberCommand_memberDelete() end");
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
