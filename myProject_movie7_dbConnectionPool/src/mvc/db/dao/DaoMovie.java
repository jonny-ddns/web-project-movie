package mvc.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.db.DBConnectionPool;
import mvc.db.dto.DtoMovie;

public class DaoMovie extends DAO {
	private static DaoMovie movieDao		= null;
	private static List<DtoMovie> movieList	= null;
	
	private DaoMovie() {
	}
	
	public static DaoMovie getInstance() {
		if(movieDao == null) {
			movieDao = new DaoMovie();
		}
		movieList = new ArrayList<DtoMovie>();
		return movieDao;
	}
	
	public List<DtoMovie> getMovieList(){
		return movieList;
	}
	
	/*--------------------------------------------------*/
	
	//모든 영화 리스트 형태로 가져오기
	public List<DtoMovie> movieList() throws SQLException, ClassNotFoundException {
		System.out.println("MovieDao - movieList()");
		String sql = "SELECT * FROM movies WHERE isActive = 'y' ORDER BY registerDate DESC, title ASC;";
		
		dbcp = DBConnectionPool.getInstance();
		conn = dbcp.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		movieList = getMovieList();

		while(rs.next()){
			DtoMovie movie = new DtoMovie();
			movie.setMovieCode(rs.getInt("movieCode"))
				 .setTitle(rs.getString("title"))
				 .setDirector(rs.getString("director"))
				 .setActors(rs.getString("actors"))
				 .setGenre(rs.getString("genre"))
				 .setContent(rs.getString("content"))
				 .setRunningTime(rs.getInt("runningTime"))
				 .setRating(rs.getString("rating"))
				 .setScore(rs.getInt("score"))
				 .setMoviePoster(rs.getString("moviePoster"));
			movieList.add(movie);
		}
		if(rs != null) { rs.close(); }
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }

		System.out.println("movieList - end");
		return movieList;
	}
	
	//DB에 영화 삽입하기
	public void movieUpload(DtoMovie movie) throws SQLException, ClassNotFoundException {
		System.out.println("MovieDao - movieInsert()");
		String sql = "INSERT INTO movies(movieCode, title, director, actors, genre, content, runningTime, rating, score, moviePoster, registerDate, isActive) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?);";
		
		dbcp = DBConnectionPool.getInstance();
		conn = dbcp.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, movie.getMovieCode());
		pstmt.setString(2, movie.getTitle());
		pstmt.setString(3, movie.getDirector());
		pstmt.setString(4, movie.getActors());
		pstmt.setString(5, movie.getGenre());
		pstmt.setString(6, movie.getContent());
		pstmt.setInt(7, movie.getRunningTime());
		pstmt.setString(8, movie.getRating());
		pstmt.setInt(9, movie.getScore());
		pstmt.setString(10, movie.getMoviePoster());
		pstmt.setString(11, movie.getIsActive());	
		pstmt.executeUpdate();

		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("movieInsert - end");
	}
	
	//movieCode 값으로 컬럼값을 조회하는 메소드
	public DtoMovie movieSearchByCode(int movieCode) throws SQLException, ClassNotFoundException {
		DtoMovie movie = null;
		System.out.println("MovieDao - movieSearchByCode()");
		String sql = "SELECT * FROM movies WHERE movieCode = "+ movieCode+";";
		
		dbcp = DBConnectionPool.getInstance();
		conn = dbcp.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		if(rs.next()){
			movie = new DtoMovie();
			movie.setMovieCode(rs.getInt("movieCode"))
				 .setTitle(rs.getString("title"))
				 .setDirector(rs.getString("director"))
				 .setActors(rs.getString("actors"))
				 .setGenre(rs.getString("genre"))
				 .setContent(rs.getString("content"))
				 .setRunningTime(rs.getInt("runningTime"))
				 .setRating(rs.getString("rating"))
				 .setScore(rs.getInt("score"))
				 .setMoviePoster(rs.getString("moviePoster"));
		}
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("movieSearchByCode - end");
		return movie;
	}
	
	//movie 내용 수정하는 메소드
	public void movieUpdate(DtoMovie movie, int movieCode) throws SQLException, ClassNotFoundException {
		System.out.println("MovieDao - movieEdit()");
		String sql = "UPDATE movies SET movieCode = ?, title = ?, director = ?, actors = ?, genre = ?, "
				+ "content = ?, runningTime = ?, rating = ?, score = ?, moviePoster = ?, registerDate=now() "
				+ "WHERE movieCode = ?;";
		
		dbcp = DBConnectionPool.getInstance();
		conn = dbcp.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, movie.getMovieCode());
		pstmt.setString(2, movie.getTitle());
		pstmt.setString(3, movie.getDirector());
		pstmt.setString(4, movie.getActors());
		pstmt.setString(5, movie.getGenre());
		pstmt.setString(6, movie.getContent());
		pstmt.setInt(7, movie.getRunningTime());
		pstmt.setString(8, movie.getRating());
		pstmt.setInt(9, movie.getScore());
		pstmt.setString(10, movie.getMoviePoster());
		pstmt.setInt(11, movieCode);		
		pstmt.executeUpdate();
		
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		System.out.println("movieEdit - end");
	}
	
	//movie 내용 삭제하는 메소드
	public void movieDelete(int movieCode) throws SQLException, ClassNotFoundException {
		System.out.println("MovieDao - movieDelete()");
		String sql = "UPDATE movies SET registerDate = now(), isActive = 'n' WHERE movieCode = "+ movieCode;
		
		dbcp = DBConnectionPool.getInstance();
		conn = dbcp.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		
		if(pstmt != null) { pstmt.close(); }
		if(conn != null) { conn.close(); }
		
		System.out.println("movieDelete - end");
	}
}