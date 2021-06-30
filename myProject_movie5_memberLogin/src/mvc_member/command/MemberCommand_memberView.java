package mvc_member.command;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc_member.memberObject.MemberDao;
import mvc_member.memberObject.MemberVO;

public class MemberCommand_memberView implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_memberView()");
		
		MemberDao mdao = MemberDao.getInstance();
		List<MemberVO> memberList = mdao.getMemberAll();
		request.setAttribute("memberList", memberList);		
		
		System.out.println("MemberCommand_memberView() end");
	}
}
