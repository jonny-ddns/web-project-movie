package mvc.command.member;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.DaoMember;
import mvc.db.dto.DtoMember;

public class MemberCommand_memberView implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_memberView()");
			DaoMember mdao = DaoMember.getInstance();
			List<DtoMember> memberList = mdao.getMemberAll();
			request.setAttribute("memberList", memberList);	
			System.out.println("MemberCommand_memberView() end");
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
