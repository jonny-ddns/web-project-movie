package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection extends DBC{
	
	private DBconnection() {
	}
	
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
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static Connection getConnection(String url, String user, String pass) {
		Connection conn	= null;
		
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB connected");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
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
