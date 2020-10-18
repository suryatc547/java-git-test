package net.blog.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import net.blog.controller.Getconnection;
import net.db.model.QueryBuilder;


public class Employee {
	private static final Getconnection getCon = new Getconnection();
	private static final Connection con = getCon.connection();
	public void register(String name,String email,String password) {
		try {
			int res = QueryBuilder.createData("INSERT INTO users(name,email,password) VALUES('"+name+"','"+email+"','"+password+"')");
			System.out.println("registered");
			System.out.println(res);
		} catch(Exception e) {
			System.out.println("Register exception");
			System.out.println(e);
		}
	}
}
