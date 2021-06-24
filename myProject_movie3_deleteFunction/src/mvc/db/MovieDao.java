package mvc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
	private Connection conn					= null;
	private PreparedStatement pstmt 		= null;
	private ResultSet rs					= null;
	private static MovieDao movieDao		= null;
	private static List<MovieDto> movieList	= null;	
	
	private MovieDao() {
	}
	
	public static MovieDao getInstance() {
		if(movieDao == null) {
			movieDao = new MovieDao();
		}
		movieList = new ArrayList<MovieDto>();
		return movieDao;
	}
	
	public List<MovieDto> getMovieList(){
		return movieList;
	}
	
	/*--------------------------------------------------*/
	//모든 영화 리스트 형태로 가져오기
	public List<MovieDto> movieList() throws SQLException {
		System.out.println("MovieDao - movieList()");
		
		movieList = getMovieList();
		String sql = null;
		
		try {			
			sql = "SELECT * FROM movies";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				MovieDto movie = new MovieDto();
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
			System.out.println("movieList 완료");
		} catch(NullPointerException npe) {
			System.out.println("movieList - NullPointerException");
			npe.printStackTrace();
		} catch(SQLException sqle) {
			System.out.println("movieList - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("movieList - Exception");
			e.printStackTrace();
		} finally {
			if(rs != null) { rs.close(); }
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}		
		return movieList;
	}
	
	//DB에 영화 삽입하기
	public void movieInsert(MovieDto movie) throws SQLException {
		System.out.println("MovieDao - movieInsert()");
		
		String sql = null;
		try {			
			sql = "INSERT INTO movies(movieCode, title, director, actors, genre, content, runningTime, rating, score, moviePoster) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			conn = DBconnection.getConnection();
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
			
			pstmt.executeUpdate();
			
			System.out.println("movieInsert 완료");
		} catch(NullPointerException npe) {
			System.out.println("movieInsert - NullPointerException");
			npe.printStackTrace();
		} catch(SQLException sqle) {
			System.out.println("movieInsert - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("movieInsert - Exception");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}	
	}	
	
	//movieCode 값으로 컬럼값을 조회하는 메소드
	public MovieDto movieSearchByCode(int movieCode) throws SQLException {
		System.out.println("MovieDao - movieSearchByCode()");		
		MovieDto movie = null;		
		String sql = null;
		
		try {
			sql = "SELECT * FROM movies WHERE movieCode = "+ movieCode+";";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				movie = new MovieDto();
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
			System.out.println("movieSearchByCode 완료");
		} catch(NullPointerException npe) {
			System.out.println("movieSearchByCode - NullPointerException");
			npe.printStackTrace();
		} catch(SQLException sqle) {
			System.out.println("movieSearchByCode - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("movieSearchByCode - Exception");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}
		return movie;
	}
	
	//movie 내용 수정하는 메소드
	public void movieEdit(MovieDto movie, int movieCode) throws SQLException {
		System.out.println("MovieDao - movieEdit()");
		String sql = null;
		
		try {			
			sql = "UPDATE movies SET movieCode = ?, title = ?, director = ?, actors = ?, genre = ?, "
					+ "content = ?, runningTime = ?, rating = ?, score = ?, moviePoster = ? "
					+ "WHERE movieCode = ?;";			
			conn = DBconnection.getConnection();
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
			System.out.println("movieEdit 완료");
		} catch (NullPointerException npe) {
			System.out.println("movieEdit error - NullPointerException");
			 npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("movieEdit error - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("movieEdit error - Exception");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}
	}
	
	public void movieDelete(int movieCode) throws SQLException {
		System.out.println("MovieDao - movieDelete()");
		String sql = null;
		
		try {
			sql = "DELETE FROM movies WHERE movieCode = "+ movieCode;
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("movieDelete 완료");
		} catch (NullPointerException npe) {
			System.out.println("movieDelete error - NullPointerException");
			 npe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("movieDelete error - SQLException");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("movieDelete error - Exception");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}
	}
}