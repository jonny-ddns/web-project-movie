package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.MovieDto;

public class MovieDao {
	Connection conn				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				= null;
	List<MovieDto> movieList	= null;
	
	//��� ��ȭ ����Ʈ ���·� ��������
	public List<MovieDto> movieList() throws SQLException{
		System.out.println("movieList()");
		
		movieList = new ArrayList<MovieDto>();		
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
			System.out.println("movieList �Ϸ�");
		} catch (Exception e) {
			System.out.println("movieList error");
			e.printStackTrace();
		} finally {
			if(rs != null) { rs.close(); }
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}		
		return movieList;
	}
	
	//DB�� ��ȭ �����ϱ�
	public void movieInsert(MovieDto movie) throws SQLException {
		System.out.println("movieInsert()");
		
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
			
			System.out.println("movieInsert �Ϸ�");
		} catch (Exception e) {
			System.out.println("movieInsert error");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}	
	}	
	
	//movieCode ������ �÷����� ��ȸ�ϴ� �޼ҵ�
	public MovieDto movieSearchByCode(int movieCode) throws SQLException {
		System.out.println("movieSearchByCode()");		
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
			System.out.println("movieSearchByCode �Ϸ�");
		} catch (Exception e) {
			System.out.println("movieSearchByCode error");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}
		return movie;
	}
	
	//movie ���� �����ϴ� �޼ҵ�
	public void movieEdit(MovieDto movie, int movieCode) throws SQLException {
		System.out.println("movieEdit()");
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
			System.out.println("movieEdit �Ϸ�");
		} catch (Exception e) {
			System.out.println("movieEdit error");
			e.printStackTrace();
		} finally {
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}
	}
}