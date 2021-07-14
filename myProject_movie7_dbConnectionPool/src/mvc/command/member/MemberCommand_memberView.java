package mvc.command.member;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MemberDao;
import mvc.db.vo.MemberVO;

public class MemberCommand_memberView implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_memberView()");
			MemberDao mdao = MemberDao.getInstance();
			List<MemberVO> memberList = mdao.getMemberAll();
			request.setAttribute("memberList", memberList);	
			System.out.println("MemberCommand_memberView() end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
