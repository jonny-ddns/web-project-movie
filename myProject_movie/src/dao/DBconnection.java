package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnection {
	Connection conn				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				= null;
	
	//DB ????
	public static Connection getConnection() {
		Connection conn	= null;		
		String url		= null;
		String user		= null;
		String pass		= null;
		
		try {			
			url	= "jdbc:mysql://localhost:3306/myPro_movie";
			user = "root";
			pass = "1q2w";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB connected");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
	
	//DB ????
	public static Connection getConnection(String url, String user, String pass) {
		Connection conn	= null;
		
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB connected");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
}
