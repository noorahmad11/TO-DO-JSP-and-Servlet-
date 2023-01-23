package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.todo.dto.User;

public class Userdaoimp {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo?characterEncoding=latin1","root","12345");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

	public static int create(User user) {
		int status = 0;

		try {

			Connection con = Userdaoimp.getConnection();

			String query = "insert into users(name,USERID,Passwords) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			status = ps.executeUpdate();
			con.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			return -1;
		}
		catch(Exception e) {
			return 0;
			
		}
		return status;
	}

	public static User Read(String username, String password) {
		try {
			Connection con = Userdaoimp.getConnection();
			String query = "select * from users where USERID=? and Passwords=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs= ps.executeQuery();
			rs.next();
			User u = new User(rs.getString(1),rs.getString(2), rs.getString(3));
			con.close();
			return u;
			
		}
		catch(Exception e) {
			System.out.println(e);
			return new User();
		}
		
		
	}

	public int delete(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Update(String Username) {
		// TODO Auto-generated method stub
		return 0;
	}

}
