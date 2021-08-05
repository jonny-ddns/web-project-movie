package mvc.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceConnection {
	private static DataSourceConnection dsConnection	= null;
	private DataSource ds								= null;
	
	private DataSourceConnection(){
	}
	
	public static DataSourceConnection getInstance() throws NamingException {
		if(dsConnection == null) {
			dsConnection = new DataSourceConnection();
			dsConnection.getConnection();
		}		
		return dsConnection;
	}
	
	public DataSource getConnection() throws NamingException {
		System.out.println("--ds 연결시도");
		Context initialContext = new InitialContext();
		Context envContext = (Context) initialContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/datasourceConnectionTest");
		System.out.println("--ds 연결완료");
		return ds;
	}
}
