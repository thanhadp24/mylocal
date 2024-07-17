package crm.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crm","root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
