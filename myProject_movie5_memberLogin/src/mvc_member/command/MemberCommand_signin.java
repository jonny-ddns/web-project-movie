package mvc_member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_member.memberObject.MemberDao;

public class MemberCommand_signin implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_signin()");
		
		MemberDao mdao = MemberDao.getInstance();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean isVerified = mdao.memberVerify(id, pw);
		request.setAttribute("isVerified", isVerified);
		
		System.out.println(">>MemberCommand_signin() end");
	}
}
