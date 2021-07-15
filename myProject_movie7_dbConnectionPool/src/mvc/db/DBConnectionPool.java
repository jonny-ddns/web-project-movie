package mvc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionPool {
	String driver;
	String url;
	String user;
	String pass;	
	
	private static DBConnectionPool dbcp = null;
	
	//Connection 객체를 리스트 형태로 보관하는 컬렉션
	private List<Connection> connList = new ArrayList<Connection>();
	
	private DBConnectionPool() throws ClassNotFoundException {
		this("com.mysql.jdbc.Driver",
			 "jdbc:mysql://localhost:3306/myPro_movie",
			 "root",
			 "1q2w");
	}
	
	private DBConnectionPool(String driver, String url, String user, String pass) throws ClassNotFoundException {
		this.url	= url;
		this.user	= user;
		this.pass	= pass;
		Class.forName(driver);
	}	
	
	//싱글톤 생성
	public static DBConnectionPool getInstance() throws ClassNotFoundException{		
		if(dbcp == null) {
			dbcp = new DBConnectionPool();
		}
		return dbcp;		
	}
	
	//커넥션 요청을 받으면 Connection 객체 제공하기
	public Connection getConnection() throws SQLException {
		//리스트에 커넥션이 있으면 0번째 객체 꺼내주기
		//꺼내주기 전에 유효성 체크(일정 시간이 지나면 서버와의 연결이 끊어지기 때문)
		if(connList.size() > 0) {
			Connection conn = connList.get(0);
			if(conn.isValid(10)) {
				return conn;
			}
		}
		//리스트에 객체가 없으면 새로 연결 생성
		return DriverManager.getConnection(url, user, pass);
	}
	
	//사용후에는 커넥션 풀에 반환하기
	public void returnConnection(Connection conn) {
		connList.add(conn);
	}
	
	//커넥션풀 해제 - 리스트의 모든 커넥션 연결 해제하기
	public void closeAll() throws SQLException {
		for(Connection conn : connList) { conn.close(); }
	}
}
