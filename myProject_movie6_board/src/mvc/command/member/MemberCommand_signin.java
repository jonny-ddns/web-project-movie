package mvc.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.db.dao.MemberDao;
import mvc.db.vo.MemberVO;

public class MemberCommand_signin implements MemberCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_signin()");
		
		MemberDao mdao = MemberDao.getInstance();
		HttpSession session	= null;
		MemberVO member		= null;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean isVerified = mdao.memberVerify(id, pw);
		
		if(isVerified) {
			member = mdao.memberSearchByID(id);
			session = request.getSession();
			session.setAttribute("memberLogin", member);
		}
		
		request.setAttribute("isVerified", isVerified);
		System.out.println(">>MemberCommand_signin() end");
	}
}
