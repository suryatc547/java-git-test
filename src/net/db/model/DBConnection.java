package net.db.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import net.connection.model.ConnectionString;

public class DBConnection {
	private static Connection con;
	public static Connection get() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbase",ConnectionString.user,ConnectionString.password);
		} catch(Exception e) {
			System.out.println("Common connection error net.db.model");
			System.out.println(e);
		} finally {
			return con;
		}
	}
}
