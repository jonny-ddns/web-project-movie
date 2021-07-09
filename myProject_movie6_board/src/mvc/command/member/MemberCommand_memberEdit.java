package mvc.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.db.dao.MemberDao;
import mvc.db.vo.MemberVO;

public class MemberCommand_memberEdit implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>MemberCommand_memberEdit()");		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO member = new MemberVO();
		
		String id = request.getParameter("id");
		
		String[] interestArr = request.getParameterValues("interest");
		String interest = "";
		for(String st : interestArr) {
			interest += st;
		}
		
		//µð¹ö±ë

		System.out.println("--------µð¹ö±ë");
		System.out.println("id: "+ request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("birthyear"));
		System.out.println(request.getParameter("gender"));		
		System.out.println("--------µð¹ö±ë");
		//µð¹ö±ë
		member.setPassword(request.getParameter("pw"))
			  .setName(request.getParameter("name"))
			  .setEmail(request.getParameter("email"))
			  .setBirthyear(Integer.parseInt(request.getParameter("birthyear")))
			  .setGender(request.getParameter("gender"))
			  .setInterest(interest);
		mdao.memberEdit(member, id);
		
		System.out.println("MemberCommand_memberEdit() end");
	}	
}
