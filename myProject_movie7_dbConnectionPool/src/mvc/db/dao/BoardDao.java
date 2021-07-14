package mvc.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mvc.db.DBconnection;
import mvc.db.vo.BoardVO;

public class BoardDao {	
	private Connection conn					= null;
	private PreparedStatement pstmt 		= null;
	private ResultSet rs					= null;
	private static BoardDao boardDao		= null;
	private static List<BoardVO> boardList	= null;
	
	private BoardDao(){
	}	
	
	public static BoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDao();
		}
		boardList = new ArrayList<BoardVO>();
		return boardDao;
	}
	
	public static List<BoardVO> getBoardList() {
		if(boardList == null) {
			boardList = new ArrayList<BoardVO>();
		}
		return boardList;
	}
	
	/*----------------------------------*/
	public List<BoardVO> getBoardAll() throws SQLException {
		System.out.println("BoardDao - getBoardAll()");
		String sql = "SELECT * FROM board WHERE isActive='y' ORDER BY artiNum DESC;";
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		boardList = getBoardList();
		BoardVO board;
		
		while(rs.next()){
			board = new BoardVO();
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

	public void boardWrite(BoardVO board) throws SQLException {
		System.out.println("BoardDao - boardWrite()");
		String sql = "INSERT INTO board(artiTitle, writer, artiDate, openPublic, image, content, isActive) "
				+ "VALUES(?, ?, now(), ?, ?, ?, 'y');";
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		
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
	
	public BoardVO boardSearchByArtiNum(int artiNum) throws SQLException {
		System.out.println("BoardDao - boardSearchByArtiNum()");
		String sql = "SELECT * FROM board WHERE artiNum='"+ artiNum+ "';";
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		BoardVO board = null;
		if(rs.next()) {
			board = new BoardVO();
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

	public BoardVO boardSearchByID(String id) throws SQLException {
		System.out.println("BoardDao - boardSearchByID()");
		String sql = "SELECT * FROM board WHERE id='"+ id+ "';";
		
		conn = DBconnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		BoardVO board = null;
		if(rs.next()) {
			board = new BoardVO();
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

	public void boardEdit(BoardVO board, String id) {
	}

	public void boardDelete(String id) {
	}
}
