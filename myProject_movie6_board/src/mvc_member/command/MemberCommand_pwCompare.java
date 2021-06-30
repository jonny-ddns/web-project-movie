package mvc_member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc_member.memberObject.MemberDao;
import mvc_member.memberObject.MemberVO;

public class MemberCommand_pwCompare implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_pwCompare()");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("memberLogin");
		MemberDao mdao = MemberDao.getInstance();
		String inputPw = request.getParameter("pw");
		
		boolean compareResult = mdao.memberPwCompare(member, inputPw);
		request.setAttribute("compareResult", compareResult);
		
		System.out.println("MemberCommand_pwCompare() end");
	}
}
