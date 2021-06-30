package mvc_member.memberObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import db.DBconnection;

public class MemberDao extends MemberDao_abstract {

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
	
	@Override
	public List<MemberVO> getMemberAll() {
		System.out.println("MemberDao - getMemberAll()");
		
		String sql = null;
		MemberVO member = null;
		
		try {			
			sql = "SELECT * FROM members;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			System.out.println("getMemberAll 완료");
		} catch (NullPointerException npe) {
			System.out.println("getMemberAll - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("getMemberAll - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("getMemberAll - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) { rs.close(); };
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
		return memberList;
	}
	

	@Override
	public boolean memberVerify(String id, String pw) {
		System.out.println("MemberDao - memberVerify()");
		
		boolean isVefied = false;
		
		String sql = null;
		try {			
			sql = "SELECT * FROM members WHERE id=? AND password=?;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next() == true) {
				isVefied = true;
			}
		
			System.out.println("memberVerify 완료");
		} catch (NullPointerException npe) {
			System.out.println("memberVerify - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("memberVerify - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("memberVerify - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
		return isVefied;
	}
	
	
	@Override
	public void memberInsert(MemberVO member) {
		System.out.println("MemberDao - memberInsert()");
		
		String sql = null;
		try {			
			sql = "INSERT INTO members(id, password, name, email, birthyear, gender, interest, joinDate, isActive) "
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
			System.out.println("memberInsert 완료");
		} catch (NullPointerException npe) {
			System.out.println("memberInsert - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("memberInsert - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("memberInsert - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}	
	}	

	@Override
	public MemberVO memberSearchByID(String id) {
		System.out.println("MemberDao - memberSearchByID()");
		
		MemberVO member = null; 
		String sql = null;
		
		try {			
			sql = "SELECT * FROM members WHERE id='"+ id+ "';";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			System.out.println("memberSearchByID 완료");
		} catch (NullPointerException npe) {
			System.out.println("memberSearchByID - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("memberSearchByID - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("memberSearchByID - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
		return member;
	}
	
	
	@Override
	public boolean memberPwCompare(MemberVO member, String inputPw) {
		System.out.println("MemberDao - memberPwCompare()");
		boolean result = false;
		String sql = null;
		
		String id = member.getId();
		String pw = "";		
		
		try {			
			sql = "SELECT * FROM members WHERE id='"+ id+ "';";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pw = rs.getString("password");
			}
			if(inputPw.equals(pw)) {
				System.out.println("비밀번호 일치");
				result  = true;
			} else {
				System.out.println("비밀번호 불일치");
			}			
			System.out.println("memberPwCompare 완료");
		} catch (NullPointerException npe) {
			System.out.println("memberPwCompare - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("memberPwCompare - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("memberPwCompare - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
		return result;
	}
	
	@Override
	public void memberEdit(MemberVO member, String id) {
		System.out.println("MemberDao - memberEdit()");
			
		String sql = null;
		try {			
			sql = "UPDATE members SET name=?, password=?, birthyear=?, gender=?, interest=?, updateDate=now() WHERE id = ?;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setInt(3, member.getBirthyear());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getInterest());
			pstmt.setString(7, member.getId());		
			pstmt.executeUpdate();
			
			System.out.println("memberEdit 완료");
		} catch (NullPointerException npe) {
			System.out.println("memberEdit - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("memberEdit - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("memberEdit - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
	}
	
	@Override
	public void memberDelete(String id) {
		System.out.println("MemberDao - memberDelete()");		
		String sql = null;
		try {			
			sql = "UPDATE members SET isActive = 'n' WHERE id = ?;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);		
			pstmt.executeUpdate();
			
			System.out.println("memberDelete 완료");
		} catch (NullPointerException npe) {
			System.out.println("memberDelete - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("memberDelete - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("memberDelete - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}		
	}

}
