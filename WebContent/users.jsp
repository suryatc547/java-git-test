<%@page import = "net.blogsource.controller.User" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<td>S.No</td>
				<td>Name</td>
				<td>Email</td>
				<td>Password</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<% try{ %>
	 		<% 
	 		int i = 1;
	 		ArrayList<User> us = (ArrayList<User>)request.getAttribute("user");
	 		for(User s:us){
	 		%>
	 		<tr>
				<td><%= i %></td>
				<td><%= s.getName() %></td>
				<td><%= s.getEmail() %></td>
				<td><%= s.getPassword() %></td>
				<td>
					<a href="<%= request.getContextPath() %>/users/edit/<%= s.getId() %>">Edit</a>
				</td>
			</tr>
	 		<% i++; } %>
			<% }catch(Exception e){ %>
			<% System.out.println(e); %>
			<% } %>
		</tbody>
	</table>
</body>
</html>