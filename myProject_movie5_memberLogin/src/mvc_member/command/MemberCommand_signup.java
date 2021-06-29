package mvc_member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_member.memberObject.MemberDao;
import mvc_member.memberObject.MemberVO;

public class MemberCommand_signup implements MemberCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_signup()");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO member = new MemberVO();

		member.setId(request.getParameter("id"))
			  .setPassword(request.getParameter("pw"))
			  .setName(request.getParameter("name"))
			  .setEmail(request.getParameter("email"))
			  .setBirthyear(Integer.parseInt(request.getParameter("birthyear")))
			  .setGender(request.getParameter("gender"))
			  .setInterest(request.getParameter("interest"))
			  .setIsActive("y");	
		mdao.memberInsert(member);
		
		System.out.println("MemberCommand_signup() end");
	}
}
