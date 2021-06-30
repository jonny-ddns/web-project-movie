package mvc_member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc_member.memberObject.MemberDao;

public class MemberCommand_memberDelete implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_memberDelete()");	
		String id = request.getParameter("id");
		MemberDao mdao = MemberDao.getInstance();
		mdao.memberDelete(id);
		System.out.println("MemberCommand_memberDelete() end");
	}
}
