package mvc_member.memberObject;

import java.util.List;

public abstract class MemberDao_abstract {
	public abstract List<MemberVO> getMemberAll();
	
	public abstract boolean memberVerify(String id, String pw); 
	
	public abstract void memberInsert(MemberVO member);
	
	public abstract MemberVO memberSearchByID(String id);
	
	public abstract boolean memberPwCompare(MemberVO member, String inputPw);
	
	public abstract void memberEdit(MemberVO member, String id);
		
	public abstract void memberDelete(String id);	
}
