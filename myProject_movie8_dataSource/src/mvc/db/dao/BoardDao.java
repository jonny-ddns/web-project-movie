package mvc.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import mvc.db.DataSourceConnection;
import mvc.db.dto.BoardDto;

public class BoardDao extends DAO {
	private static BoardDao boardDao		= null;
	private static List<BoardDto> boardList = null;
		
	private BoardDao() throws NamingException{ 
		DataSourceConnection dsc = DataSourceConnection.getInstance();
		ds = dsc.getConnection();
	}
	
	public static BoardDao getInstance() throws NamingException{
		if(boardDao == null) {
			boardDao = new BoardDao();
		}
		boardList = new ArrayList<BoardDto>();
		return boardDao;
	}
	
	public List<BoardDto> getBoardList(){
		return boardList;
	}
	
	/*------------------------------------------------------------------------*/
	public List<BoardDto> getBoardAll() throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - getBoardAll()");
		String sql = "SELECT * FROM board WHERE isActive='y' ORDER BY artiNum DESC;";
	
		conn 	= ds.getConnection();
		pstmt 	= conn.prepareStatement(sql);
		rs 		= pstmt.executeQuery();
		
		List<BoardDto> boardList = getBoardList();
		BoardDto board;
		
		while(rs.next()){
			board = new BoardDto();
			board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
				 .setArtiTitle(rs.getString("artiTitle"))
				 .setWriter(rs.getString("writer"))
				 .setWriteDate(rs.getTimestamp("writeDate").toString())
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

	public void boardWrite(BoardDto board) throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - boardWrite()");
		String sql = "INSERT INTO board(artiTitle, writer, writeDate, openPublic, image, content, isActive) "
				+ "VALUES(?, ?, now(), ?, ?, ?, 'y');";
		
		conn 	= ds.getConnection();
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
	
	public BoardDto boardSearchByArtiNum(int artiNum) throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - boardSearchByArtiNum()");
		String sql = "SELECT * FROM board WHERE artiNum=?;";	
		
		conn	= ds.getConnection();
		pstmt	= conn.prepareStatement(sql);
		pstmt.setInt(1, artiNum);
		rs		= pstmt.executeQuery();
				
		BoardDto board = null;
		if(rs.next()) {
			board = new BoardDto();
			board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
				 .setArtiTitle(rs.getString("artiTitle"))
				 .setWriter(rs.getString("writer"))
				 .setWriteDate(rs.getString("writeDate").toString())
				 .setOpenPublic(rs.getString("openPublic"))
				 .setImage(rs.getString("image"))
				 .setContent(rs.getString("content"))
				 .setIsActive(rs.getString("isActive"));
		}
		if(rs != null) { rs.close(); }
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("boardSearchByArtiNum - end");
		return board;
	}

	public BoardDto boardSearchByID(String id) throws SQLException, ClassNotFoundException {
		System.out.println("BoardDao - boardSearchByID()");
		String sql = "SELECT * FROM board WHERE id='"+ id+ "';";
		
		conn	= ds.getConnection();
		pstmt	= conn.prepareStatement(sql);
		rs		= pstmt.executeQuery();
		
		BoardDto board = null;
		if(rs.next()) {
			board = new BoardDto();
			board.setArtiNum(Integer.parseInt(rs.getString("artiNum")))
				 .setArtiTitle(rs.getString("artiTitle"))
				 .setWriter(rs.getString("writer"))
				 .setWriteDate(rs.getString("writeDate").toString())
				 .setOpenPublic(rs.getString("openPublic"))
				 .setImage(rs.getString("image"))
				 .setContent(rs.getString("content"))
				 .setIsActive(rs.getString("isActive"));
		}
		if(rs != null) { rs.close(); }
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("boardSearchByID - end");
		return board;
	}	
	
	public void boardUpdate(BoardDto board, int artiNum) throws SQLException, ClassNotFoundException{
		System.out.println("BoardDao - boardUpdate()");
		String sql = "UPDATE board SET artiTitle=?, content=?, modifyDate=now() WHERE artiNum=?;";
		
		conn	= ds.getConnection();
		pstmt	= conn.prepareStatement(sql);
		pstmt.setString(1, board.getArtiTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, artiNum);
		pstmt.executeUpdate();
		
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("boardUpdate - end");
	}

	public void boardDelete(int artiNum) throws SQLException, ClassNotFoundException{
		System.out.println("BoardDao - boardUpdate()");
		String sql = "UPDATE board SET isActive='n' WHERE artiNum=?";
		
		conn	= ds.getConnection();
		pstmt	= conn.prepareStatement(sql);
		pstmt.executeUpdate();

		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("boardUpdate() - end");
	}
}