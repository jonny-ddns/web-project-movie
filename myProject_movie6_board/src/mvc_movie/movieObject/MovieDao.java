package mvc_movie.movieObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBconnection;

public class MovieDao extends MovieDao_abstract{
	private Connection conn					= null;
	private PreparedStatement pstmt 		= null;
	private ResultSet rs					= null;
	private static MovieDao movieDao		= null;
	private static List<MovieVO> movieList	= null;	
	
	private MovieDao() {
	}
	
	public static MovieDao getInstance() {
		if(movieDao == null) {
			movieDao = new MovieDao();
		}
		movieList = new ArrayList<MovieVO>();
		return movieDao;
	}
	
	public List<MovieVO> getMovieList(){
		return movieList;
	}
	
	/*--------------------------------------------------*/
	
	//모든 영화 리스트 형태로 가져오기
	@Override
	public List<MovieVO> movieList() {
		System.out.println("MovieDao - movieList()");
		
		movieList = getMovieList();
		String sql = null;
		
		try {			
			sql = "SELECT * FROM movies WHERE isActive = 'y' ORDER BY registerDate DESC title ASC;";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				MovieVO movie = new MovieVO();
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
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}		
		return movieList;
	}
	
	//DB에 영화 삽입하기
	@Override
	public void movieUpload(MovieVO movie) {
		System.out.println("MovieDao - movieInsert()");
		
		String sql = null;
		try {			
			sql = "INSERT INTO movies(movieCode, title, director, actors, genre, content, runningTime, rating, score, moviePoster, registerDate, isActive) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?);";
			
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
			pstmt.setString(11, movie.getIsActive());
		
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
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}	
	}	
	
	//movieCode 값으로 컬럼값을 조회하는 메소드
	@Override
	public MovieVO movieSearchByCode(int movieCode) {
		System.out.println("MovieDao - movieSearchByCode()");		
		MovieVO movie = null;		
		String sql = null;
		
		try {
			sql = "SELECT * FROM movies WHERE movieCode = "+ movieCode+";";
			
			conn = DBconnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				movie = new MovieVO();
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
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
		return movie;
	}
	
	//movie 내용 수정하는 메소드
	@Override
	public void movieUpdate(MovieVO movie, int movieCode) {
		System.out.println("MovieDao - movieEdit()");
		String sql = null;
		
		try {			
			sql = "UPDATE movies SET movieCode = ?, title = ?, director = ?, actors = ?, genre = ?, "
					+ "content = ?, runningTime = ?, rating = ?, score = ?, moviePoster = ?, registerDate=now() "
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
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
	}
	
	//movie 내용 삭제하는 메소드
	@Override	
	public void movieDelete(int movieCode) {
		System.out.println("MovieDao - movieDelete()");
		String sql = null;
		
		try {
//			sql = "DELETE FROM movies WHERE movieCode = "+ movieCode;
			sql = "UPDATE movies SET registerDate = now(), isActive = 'n' WHERE movieCode = "+ movieCode;
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
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (SQLException sqle) {
				sqle.getMessage();
			}
		}
	}
}