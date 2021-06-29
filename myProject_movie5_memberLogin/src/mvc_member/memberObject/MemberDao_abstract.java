package mvc_member.memberObject;

public abstract class MemberDao_abstract {
	public abstract void memberInsert(MemberVO member);
	
	public abstract MemberVO memberSearchByID(String id);
	
	public abstract void memberEdit(MemberVO member, String id);
		
	public abstract void memberDelete(String id);	
}
