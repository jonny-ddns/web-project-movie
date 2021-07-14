package mvc.command.member;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.db.dao.MemberDao;
import mvc.db.vo.MemberVO;

public class MemberCommand_pwCompare implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_pwCompare()");
			
			HttpSession session = request.getSession();
			MemberVO member = (MemberVO) session.getAttribute("memberLogin");
			String inputPw = request.getParameter("pw");
			MemberDao mdao = MemberDao.getInstance();
			boolean compareResult = mdao.memberPwCompare(member, inputPw);
			request.setAttribute("compareResult", compareResult);
			
			System.out.println("MemberCommand_pwCompare() end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
