package net.blogsource.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import net.blogsource.controller.Users;
import net.blogsource.controller.User;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Users users = new Users();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("got it");
//		System.out.println(users.getUsers());
//		User[] u = users.getUsers();
		ResultSet rss = users.getUsers();
		ArrayList<User> us = new ArrayList<User>();
		while(rss.next()) {
//			System.out.println(rss.getString("name"));
			us.add(new User(rss.getInt("id"),rss.getString("name"),rss.getString("email"),rss.getString("password")));
		}
		request.setAttribute("user", us);
		RequestDispatcher rs = request.getRequestDispatcher("users.jsp");
		rs.forward(request, response);
		} catch(Exception e) {
			System.out.println("get user exception");
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
