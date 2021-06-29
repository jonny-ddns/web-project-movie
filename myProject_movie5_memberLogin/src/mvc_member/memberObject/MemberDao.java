package mvc_member.memberObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBconnection;

public class MemberDao extends MemberDao_abstract {

	private Connection conn					= null;
	private PreparedStatement pstmt 		= null;
	private ResultSet rs					= null;
	private static MemberDao memberDao		= null;
	
	@Override
	public void memberInsert(MemberVO member) {
		System.out.println("MemberDao - memberInsert()");
		
		String sql = null;
		try {			
			sql = "INSERT INTO members(id, name, password, birthyear, gender, interest, joinDate, updateDate, isActive) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setInt(4, member.getBirthyear());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getInterest());
			pstmt.setString(7, member.getJoinDate());
			pstmt.setString(8, member.getInterest());
			pstmt.setString(9, member.getIsActive());
		
			pstmt.executeUpdate();
			
			System.out.println("memberInsert ¿Ï·á");
		} catch(NullPointerException npe) {
			System.out.println("memberInsert - NullPointerException");
			npe.printStackTrace();
		} catch(SQLException sqle) {
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
		return null;
	}
	@Override
	public void memberEdit(MemberVO member, String id) {
		System.out.println("MemberDao - memberEdit()");
		
	}
	@Override
	public void memberDelete(String id) {
		System.out.println("MemberDao - memberDelete()");
		
	}
}
