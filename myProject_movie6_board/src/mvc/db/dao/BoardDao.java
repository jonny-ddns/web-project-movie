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
	public List<BoardVO> getBoardAll() {		
		System.out.println("BoardDao - getBoardAll()");

		String sql		= null;
		boardList = getBoardList();
		
		try {
			
			sql = "SELECT * FROM board WHERE isActive='y' ORDER BY artiNum DESC;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardVO board = new BoardVO();
				
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
			System.out.println("getBoardAll - end");
		} catch (NullPointerException npe) {
			System.out.println("getBoardAll - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("getBoardAll - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("getBoardAll - Exception");
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
		return boardList;
	}

	public boolean boardVerify(String id, String pw) {
		System.out.println("BoardDao - boardVerify()");
		boolean isVefied = false;
		return isVefied;
	}

	public void boardWrite(BoardVO board) {
		System.out.println("BoardDao - boardWrite()");

		String sql = null;
		try {			
			sql = "INSERT INTO board(artiTitle, writer, artiDate, openPublic, image, content, isActive) "
					+ "VALUES(?, ?, now(), ?, ?, ?, 'y');";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getArtiTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getOpenPublic());
			pstmt.setString(4, board.getImage());
			pstmt.setString(5, board.getContent());
		
			pstmt.executeUpdate();		
			System.out.println("boardWrite - end");
		} catch (NullPointerException npe) {
			System.out.println("boardWrite - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("boardWrite - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("boardWrite - Exception");
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
	
	public BoardVO boardSearchByArtiNum(int artiNum) {
		System.out.println("BoardDao - boardSearchByArtiNum()");

		BoardVO board = null;
		String sql = null;
		try {			
			sql = "SELECT * FROM board WHERE artiNum='"+ artiNum+ "';";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			System.out.println("boardSearchByArtiNum - end");
		} catch (NullPointerException npe) {
			System.out.println("boardSearchByArtiNum - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("boardSearchByArtiNum - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("boardSearchByArtiNum - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}		
		return board;
	}

	public BoardVO boardSearchByID(String id) {
		System.out.println("BoardDao - boardSearchByID()");

		BoardVO board = null;
		String sql = null;
		try {			
			sql = "SELECT * FROM board WHERE id='"+ id+ "';";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			System.out.println("boardSearchByID - end");
		} catch (NullPointerException npe) {
			System.out.println("boardSearchByID - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("boardSearchByID - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("boardSearchByID - Exception");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}		
		return board;
	}

	public void boardEdit(BoardVO board, String id) {
		// TODO Auto-generated method stub
		
	}

	public void boardDelete(String id) {
		// TODO Auto-generated method stub
		
	}
}
