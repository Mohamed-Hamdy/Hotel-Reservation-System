<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	try {
		Connection con = DatabaseConnection.getConnection();
		Statement statement = con.createStatement();
                
		int edit_account = statement.executeUpdate("update admin set username='" + username+ "',"
                        + "password='" + password + "' where username='" +username + "'");
		if (edit_account > 0) {
			response.sendRedirect("Adminaccount.jsp");
		} else {
			response.sendRedirect("edit_account.jsp");
		}
	} catch (Exception e) {
            
                out.println(e);
		e.printStackTrace();
	}
%>