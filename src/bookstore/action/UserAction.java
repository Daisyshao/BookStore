package bookstore.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookstore.model.*;

public class UserAction {
	
	public void saveUser(User user){     //注册新用户
		Connection conn = MysqlJDBC.getConnection();
		String sql = "insert into user(username,pswd,email) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MysqlJDBC.closeConnection(conn);
		}
	}
	
	public User login(String username, String password){   //已注册的用户登录
		User user = null;
		Connection conn = MysqlJDBC.getConnection();
		String sql = "select * from user where username = ? and pswd = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
//				System.out.println("yes");
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MysqlJDBC.closeConnection(conn);
		}
		return user;
	}

	public boolean userIsExist(String username){ // 判断该username的用户是否存在
		Connection conn = MysqlJDBC.getConnection();
		String sql = "select * from user where username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			MysqlJDBC.closeConnection(conn);
		}
		return false; 
	}
}
