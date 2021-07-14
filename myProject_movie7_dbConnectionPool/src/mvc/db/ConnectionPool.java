package mvc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	String url;
	String username;
	String password;
	
	//Connection ��ü�� ����Ʈ ���·� �����ϴ� �÷���
	List<Connection> connList = new ArrayList<Connection>();
	
	public ConnectionPool(String driver, String url, String username, String password) throws ClassNotFoundException {
		this.url		= url;
		this.username	= username;
		this.password	= password;

		Class.forName(driver);
	}
	
	//Ŀ�ؼ� ��û�� ������ Connection ��ü �����ϱ�
	public Connection getConnection() throws SQLException {
		//����Ʈ�� Ŀ�ؼ��� ������ 0��° ��ü �����ֱ�
		//�����ֱ� ���� ��ȿ�� üũ(���� �ð��� ������ �������� ������ �������� ����)
		if(connList.size() > 0) {
			Connection conn = connList.get(0);
			if(conn.isValid(10)) {
				return conn;
			}
		}
		//����Ʈ�� ��ü�� ������ ���� ���� ����
		return DriverManager.getConnection(url, username, password);
	}
	
	//����Ŀ��� Ŀ�ؼ� Ǯ�� ��ȯ�ϱ�
	public void returnConnection(Connection conn) {
		connList.add(conn);
	}
	
	public void closeAll() {
		//����Ʈ�� ��� Ŀ�ؼ� ���� �����ϱ� 
		for(Connection conn : connList) {
			try {
				conn.close();
			} catch (SQLException sqle) {
				sqle.getMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
