package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MySqlConnection;
import crm.model.Role;

public class RoleRepository {

	public int add(String name, String desc) {
		Connection conn = MySqlConnection.getConnection();
		String sql = "INSERT INTO role(role_name, `desc`) VALUES(?, ?)";
		int isSuccess = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, desc);
			
			isSuccess = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}
	
	public List<Role> getAll() {
		List<Role> roles = new ArrayList<>();

		Connection conn = MySqlConnection.getConnection();
		String sql = "SELECT * FROM role";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("role_name"));
				role.setDesc(rs.getString("desc"));

				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return roles;
	}

	public int deleteRoleById(int id) {
		Connection conn = MySqlConnection.getConnection();
		String sql = "DELETE FROM role WHERE id = ?";
		int res = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}
