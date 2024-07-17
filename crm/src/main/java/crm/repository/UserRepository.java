package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MySqlConnection;
import crm.model.User;

public class UserRepository {
	
	public List<User> getUserByUsernameAndPassword(String username, String password) {
		List<User> users = new ArrayList<>();
		
		Connection conn = MySqlConnection.getConnection();
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setAge(rs.getInt("age"));
				user.setUsername(rs.getString("username"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return users;
	}
}
