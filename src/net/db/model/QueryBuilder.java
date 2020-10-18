package net.db.model;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

import net.db.model.DBConnection;

public class QueryBuilder {
	private static final Connection con = DBConnection.get();
	
	private static ResultSet result;
	private static int updateResult;
	
	public static ResultSet getData(String query) {
		try {
			Statement st = con.createStatement();
			result = st.executeQuery(query);
		} catch(Exception e) {
			System.out.println("Select query exception");
			System.out.println(e);
		} finally {
			return result;
		}
	}
	
	public static int createData(String query) {
		try {
			Statement st = con.createStatement();
			updateResult = st.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Create query exception");
			System.out.println(e);
		} finally {
			return updateResult;
		}
	}
	
	public static int updateData(String query) {
		try {
			Statement st = con.createStatement();
			updateResult = st.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Update query exception");
			System.out.println(e);
		} finally {
			return updateResult;
		}
	}
	
	public static int deleteData(String query) {
		try {
			Statement st = con.createStatement();
			updateResult = st.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Delete query exception");
			System.out.println(e);
		} finally {
			return updateResult;
		}
	}
}
