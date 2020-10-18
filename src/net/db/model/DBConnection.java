package net.db.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con;
	public static Connection get() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbase","pma","Surya@2020");
		} catch(Exception e) {
			System.out.println("Common connection error net.db.model");
			System.out.println(e);
		} finally {
			return con;
		}
	}
}
