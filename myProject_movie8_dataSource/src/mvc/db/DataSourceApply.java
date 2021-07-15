package mvc.db;

import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceApply {
	
	private static String driverClassName;
	private static String url;
	private static String userName;
	private static String password;
	private static DataSourceApply dataSourceInstance = null;
	private BasicDataSource ds;
	
	public static DataSourceApply getInstance() {
		if(dataSourceInstance == null) {
			dataSourceInstance = new DataSourceApply();
		}
		return dataSourceInstance;
	}
	
	public static void setElement(String driverClassName, String url, String userName, String password) {
		DataSourceApply.driverClassName = driverClassName;
		DataSourceApply.url				= url;
		DataSourceApply.userName		= userName;
		DataSourceApply.password		= password;
	}

	private DataSourceApply() {		
		ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
	}
	
	public void dataSourceclose() throws SQLException {
		ds.close();
	}
}
