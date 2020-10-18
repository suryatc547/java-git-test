package net.blogsource.controller;

import java.sql.Connection;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Class;

import net.blogsource.controller.User;
import net.connection.model.ConnectionString;

public class Users {
	private static final void setClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (Exception e) {
			System.out.println("class initiated");
			System.out.println(e);
		}
	}
	
	private User[] u = new User[100];
	
	private ResultSet rss;
	
	public ResultSet getUsers() {
		try {
			setClass();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbase",ConnectionString.user,ConnectionString.password);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM users");
//			int i = 0;
//			while(res.next()) {
//				u[i] = new User(res.getString("name"),res.getString("email"),res.getString("password"));
//			}
			rss = res;
		} catch(Exception e) {
			System.out.println("get users exception");
			System.out.println(e);
		} finally {
			return rss;
		}
	}
}
