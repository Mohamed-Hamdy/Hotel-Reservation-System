<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
	String username = request.getParameter("username");
	Connection con = DatabaseConnection.getConnection();
	Statement statement = con.createStatement();
	int deleteAccount = statement.executeUpdate("delete from admin where username='" + username + "'");
	if (deleteAccount > 0) {
		response.sendRedirect("Adminaccount.jsp");
	} else {
		response.sendRedirect("Adminaccount.jsp");
	}
%>