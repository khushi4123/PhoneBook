package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.User;

public class userdao {
	private static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:4306/phonebook","root",""); 

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return conn;
	}

	public int userRegister(User u) {
		Connection conn = getConn();
		int i = 0;
		String sql = "INSERT INTO users(user_name, user_email, user_password) VALUES (?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getUserEmail());
			ps.setString(3, u.getUserPassword());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public User loginUser(String email, String pass) {
	    User user = null;
	    Connection conn = getConn(); 
	    try {
	        
	        PreparedStatement sc = conn.prepareStatement("SELECT * FROM users WHERE user_email=? and user_password=?");
	        sc.setString(1, email);
	        sc.setString(2, pass);

	        ResultSet rs = sc.executeQuery();
	        if (rs.next()) {
	            user = new User();
	            user.setUserId(rs.getInt(1));
	            user.setUserName(rs.getString(2));
	            user.setUserEmail(rs.getString(3));
	            user.setUserPassword(rs.getString(4));
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return user;
	}



	
}