package net.blog.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Getconnection {
	public Connection con;
	public Connection connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbase","pma","Surya@2020");
		} catch(Exception e) {
			System.out.println("db connection error");
			System.out.println(e);
		} finally {
			return con;
		}
	}
}
