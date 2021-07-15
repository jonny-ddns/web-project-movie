package mvc.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mvc.db.DBConnectionPool;
import mvc.db.dto.DtoBoard;

public class DaoBoard extends DAO {
	private static DaoBoard boardDao	= null;
	private static List<DtoBoard> boardList = null;
	
	private DaoBoard(){ }
	
	public static DaoBoard getInstance() {
		if(boardDao == null) {
			boardDao = new DaoBoard();
		}
		boardList = new ArrayList<DtoBoard>();
		return boardDao;
	}
	
	public List<DtoBoard> getBoardList(){
		return boardList;
	}
	
	/*----------------------------------*/
	public List<DtoBoard> getBoardAll() throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - getBoardAll()");
		String sql = "SELECT * FROM board WHERE isActive='y' ORDER BY artiNum DESC;";
	
		dbcp 	= DBConnectionPool.getInstance();
		conn 	= dbcp.getConnection();
		pstmt 	= conn.prepareStatement(sql);
		rs 		= pstmt.executeQuery();
		
		List<DtoBoard> boardList = getBoardList();
		DtoBoard board;
		
		while(rs.next()){
			board = new DtoBoard();
			board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
				 .setArtiTitle(rs.getString("artiTitle"))
				 .setWriter(rs.getString("writer"))
				 .setArtiDate(rs.getTimestamp("artiDate").toString())
				 .setOpenPublic(rs.getString("openPublic"))
				 .setImage(rs.getString("image"))
				 .setContent(rs.getString("content"))
				 .setIsActive(rs.getString("isActive"));
			boardList.add(board);
		}
		if(rs != null) { rs.close(); };
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
	
		System.out.println("getBoardAll - end");
		return boardList;
	}

	public boolean boardVerify(String id, String pw) {
		System.out.println("BoardDao - boardVerify()");
		boolean isVefied = false;
		return isVefied;
	}

	public void boardWrite(DtoBoard board) throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - boardWrite()");
		String sql = "INSERT INTO board(artiTitle, writer, artiDate, openPublic, image, content, isActive) "
				+ "VALUES(?, ?, now(), ?, ?, ?, 'y');";
		
		dbcp	= DBConnectionPool.getInstance();
		conn 	= dbcp.getConnection();
		pstmt 	= conn.prepareStatement(sql);
		
		pstmt.setString(1, board.getArtiTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getOpenPublic());
		pstmt.setString(4, board.getImage());
		pstmt.setString(5, board.getContent());	
		pstmt.executeUpdate();
	
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("boardWrite - end");
	}
	
	public DtoBoard boardSearchByArtiNum(int artiNum) throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - boardSearchByArtiNum()");
		String sql = "SELECT * FROM board WHERE artiNum='"+ artiNum+ "';";
		
		dbcp 	= DBConnectionPool.getInstance();
		conn 	= dbcp.getConnection();
		pstmt	= conn.prepareStatement(sql);
		rs 		= pstmt.executeQuery();
		
		DtoBoard board = null;
		if(rs.next()) {
			board = new DtoBoard();
			board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
				 .setArtiTitle(rs.getString("artiTitle"))
				 .setWriter(rs.getString("writer"))
				 .setArtiDate(rs.getString("artiDate").toString())
				 .setOpenPublic(rs.getString("openPublic"))
				 .setImage(rs.getString("image"))
				 .setContent(rs.getString("content"))
				 .setIsActive(rs.getString("isActive"));
		}
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("boardSearchByArtiNum - end");
		return board;
	}

	public DtoBoard boardSearchByID(String id) throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - boardSearchByID()");
		String sql = "SELECT * FROM board WHERE id='"+ id+ "';";
		
		dbcp 	= DBConnectionPool.getInstance();
		conn	= dbcp.getConnection();
		pstmt	= conn.prepareStatement(sql);
		rs		= pstmt.executeQuery();
		
		DtoBoard board = null;
		if(rs.next()) {
			board = new DtoBoard();
			board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
				 .setArtiTitle(rs.getString("artiTitle"))
				 .setWriter(rs.getString("writer"))
				 .setArtiDate(rs.getString("artiDate").toString())
				 .setOpenPublic(rs.getString("openPublic"))
				 .setImage(rs.getString("image"))
				 .setContent(rs.getString("content"))
				 .setIsActive(rs.getString("isActive"));
		}
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("boardSearchByID - end");
		return board;
	}

	public void boardEdit(DtoBoard board, String id) {
	}

	public void boardDelete(String id) {
	}
}
