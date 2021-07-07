package mvc_board.boardObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DBconnection;

public class BoardDao extends BoardDao_abstract {
	
	private Connection conn					= null;
	private PreparedStatement pstmt 		= null;
	private ResultSet rs					= null;
	private static BoardDao boardDao		= null;
	private static List<BoardVO> boardList			= null;
	
	private BoardDao(){
	}	
	
	public static BoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDao();
		}
		return boardDao;
	}
	
	public static List<BoardVO> getBoardList() {
		if(boardList == null) {
			boardList = new ArrayList<BoardVO>();
		}
		return boardList;
	}
	
	/*----------------------------------*/

	@Override
	public List<BoardVO> getBoardAll() {
		
		System.out.println("BoardDao - getBoardAll()");

		String sql		= null;
		BoardVO board	= null;
		
		try {
			boardList = getBoardList();
			sql = "SELECT * FROM board ORDER BY artiDate DESC;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				board = new BoardVO();
				
				board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
					  .setArtiTitle(rs.getString("artiTitle"))
					  .setWriter(rs.getString("writer"))
					  .setArtiDate(rs.getDate("artiDate"))
					  .setOpenPublic(rs.getString("openPublic"))
					  .setImage(rs.getString("image"))
					  .setContent(rs.getString("content"))
					  .setIsActive(rs.getString("isActive"));				
				boardList.add(board);
			}			
			System.out.println("getBoardAll 완료");
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

	@Override
	public boolean boardVerify(String id, String pw) {
		System.out.println("BoardDao - boardVerify()");
		boolean isVefied = false;
		return isVefied;
	}

	@Override
	public void boardInsert(BoardVO board) {
		System.out.println("BoardDao - boardInsert()");

		String sql = null;
		try {			
			sql = "INSERT INTO board(artiNum, artiTitle, writer, artiDate, openPublic, image, content, isActive) "
					+ "VALUES(?, ?, ?, now(), ?, ?, ?, ?);";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getArtiNum());
			pstmt.setString(2, board.getArtiTitle());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getOpenPublic());
			pstmt.setString(5, board.getImage());
			pstmt.setString(6, board.getContent());
			pstmt.setString(7, board.getIsActive());
		
			pstmt.executeUpdate();			
			System.out.println("boardInsert 완료");
		} catch (NullPointerException npe) {
			System.out.println("boardInsert - NullPointerException");
			npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("boardInsert - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("boardInsert - Exception");
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
					 .setArtiDate(rs.getDate("artiDate"))
					 .setOpenPublic(rs.getString("openPublic"))
					 .setImage(rs.getString("image"))
					 .setContent(rs.getString("content"))
					 .setIsActive(rs.getString("isActive"));
			}
			System.out.println("boardSearchByID 완료");
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

	@Override
	public void boardEdit(BoardVO board, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
