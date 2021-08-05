package mvc.command.member;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.db.dao.MemberDao;
import mvc.db.dto.MemberDto;

public class MemberCommand_signup implements MemberCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(">>MemberCommand_signup()");
			String[] interestArr = request.getParameterValues("interest");
			String interest = "";
			for(String st : interestArr) {
				interest += (", "+ st);
			}
			
			MemberDto member = new MemberDto();
			member.setId(request.getParameter("id"))
				  .setPassword(request.getParameter("pw"))
				  .setName(request.getParameter("name"))
				  .setEmail(request.getParameter("email"))
				  .setBirthyear(Integer.parseInt(request.getParameter("birthyear")))
				  .setGender(request.getParameter("gender"))
				  .setInterest(interest)
				  .setIsActive("y");
			MemberDao mdao = MemberDao.getInstance();
			mdao.memberInsert(member);
			
			System.out.println("MemberCommand_signup() end");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
