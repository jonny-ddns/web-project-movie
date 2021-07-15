package mvc.command.member;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.db.dao.DaoMember;
import mvc.db.dto.DtoMember;

public class MemberCommand_pwCompare implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_pwCompare()");
			
			HttpSession session = request.getSession();
			DtoMember member = (DtoMember) session.getAttribute("memberLogin");
			String inputPw = request.getParameter("pw");
			DaoMember mdao = DaoMember.getInstance();
			boolean compareResult = mdao.memberPwCompare(member, inputPw);
			request.setAttribute("compareResult", compareResult);
			
			System.out.println("MemberCommand_pwCompare() end");
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
