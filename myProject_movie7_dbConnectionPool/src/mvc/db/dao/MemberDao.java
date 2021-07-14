package mvc.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mvc.db.DBconnection;
import mvc.db.vo.MemberVO;

public class MemberDao {

	private Connection conn					= null;
	private PreparedStatement pstmt 		= null;
	private ResultSet rs					= null;
	private static MemberDao memberDao		= null;
	private List<MemberVO> memberList 		= null;
	
	private MemberDao() {
	}
	
	public static MemberDao getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDao();
		}
		return memberDao;
	}
	
	public List<MemberVO> getMemberAll() throws SQLException {
		System.out.println("MemberDao - getMemberAll()");
		String sql = "SELECT * FROM members ORDER BY joinDate DESC;";
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		memberList = new ArrayList<>();
		MemberVO member = null;
		
		while(rs.next()){
			member = new MemberVO();
			member.setId(rs.getString("id"))
				  .setPassword(rs.getString("password"))
				  .setName(rs.getString("name"))
				  .setEmail(rs.getString("email"))
				  .setBirthyear(rs.getInt("birthyear"))
				  .setGender(rs.getString("gender"))
				  .setInterest(rs.getString("interest"))
				  .setJoinDate(rs.getDate("joinDate"))
				  .setUpdateDate(rs.getDate("updateDate"))
				  .setIsActive(rs.getString("isActive"));
			memberList.add(member);
		}
		if(rs != null) { rs.close(); };
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("getMemberAll - end");
		return memberList;
	}
	
	public boolean memberVerify(String id, String pw) throws SQLException {
		System.out.println("MemberDao - memberVerify()");
		String sql = "SELECT * FROM members WHERE id=? AND password=?;";		
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		rs = pstmt.executeQuery();
		
		boolean isVefied = false;
		if(rs.next() == true) {
			isVefied = true;
		}
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("memberVerify - end");
		return isVefied;
	}
	
	public void memberInsert(MemberVO member) throws SQLException {
		System.out.println("MemberDao - memberInsert()");
		String sql = "INSERT INTO members(id, password, name, email, birthyear, gender, interest, joinDate, isActive) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, now(), ?);";
			
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getEmail());
		pstmt.setInt(5, member.getBirthyear());
		pstmt.setString(6, member.getGender());
		pstmt.setString(7, member.getInterest());
		pstmt.setString(8, member.getIsActive());	
		pstmt.executeUpdate();
	
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("memberInsert - end");
	}

	public MemberVO memberSearchByID(String id) throws SQLException {
		System.out.println("MemberDao - memberSearchByID()");
		String sql = "SELECT * FROM members WHERE id='"+ id+ "';";

		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		MemberVO member = null;
		if(rs.next()) {
			member = new MemberVO();
			member.setId(rs.getString("id"))
				  .setPassword(rs.getString("password"))
				  .setName(rs.getString("name"))
				  .setEmail(rs.getString("email"))
				  .setBirthyear(rs.getInt("birthyear"))
				  .setGender(rs.getString("gender"))
				  .setInterest(rs.getString("interest"))
				  .setJoinDate(rs.getDate("joinDate"))
				  .setUpdateDate(rs.getDate("updateDate"))
				  .setIsActive(rs.getString("isActive"));	
		}
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("memberSearchByID - end");
		return member;
	}
	
	public boolean memberPwCompare(MemberVO member, String inputPw) throws SQLException {
		System.out.println("MemberDao - memberPwCompare()");
		String sql = "SELECT * FROM members WHERE id = ?;";
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		rs = pstmt.executeQuery();
		
		//비밀번호 일치여부 확인
		String pw = "";
		if(rs.next()) {
			pw = rs.getString("password");
		}
		boolean result = false;
		if(inputPw.equals(pw)) {
			result  = true;
		} else {
			System.out.println("비밀번호 불일치");
		}
		if(rs != null) { rs.close(); }
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("memberPwCompare - end");
		return result;
	}
	
	public void memberEdit(MemberVO member, String id) throws SQLException {
		System.out.println("MemberDao - memberEdit()");			
		String sql = "UPDATE members SET password=?, name=?, email=?, birthyear=?, gender=?, interest=?, updateDate=now() WHERE id = ?;";
			
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, member.getPassword());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getEmail());
		pstmt.setInt(4, member.getBirthyear());
		pstmt.setString(5, member.getGender());
		pstmt.setString(6, member.getInterest());
		pstmt.setString(7, id);		
		pstmt.executeUpdate();
		
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("memberEdit - end");
	}
	
	public void memberDelete(String id) throws SQLException {
		System.out.println("MemberDao - memberDelete()");
		String sql = "UPDATE members SET isActive = 'n' WHERE id = ?;";
			
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("memberDelete - end");
	}
}