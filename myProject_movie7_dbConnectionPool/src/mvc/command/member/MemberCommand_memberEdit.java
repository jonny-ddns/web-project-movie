package mvc.command.member;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MemberDao;
import mvc.db.vo.MemberVO;

public class MemberCommand_memberEdit implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_memberEdit()");
			String[] interestArr = request.getParameterValues("interest");
			String interest = "";
			for(String st : interestArr) {
				interest += st;
			}
			
			MemberVO member = new MemberVO();
			member.setPassword(request.getParameter("pw"))
				  .setName(request.getParameter("name"))
				  .setEmail(request.getParameter("email"))
				  .setBirthyear(Integer.parseInt(request.getParameter("birthyear")))
				  .setGender(request.getParameter("gender"))
				  .setInterest(interest);
			MemberDao mdao = MemberDao.getInstance();
			String id = request.getParameter("id");
			mdao.memberEdit(member, id);
			
			System.out.println("MemberCommand_memberEdit() end");
		} catch (NullPointerException npe) {
			npe.getMessage();
		} catch (SQLException sqle) {
			sqle.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
