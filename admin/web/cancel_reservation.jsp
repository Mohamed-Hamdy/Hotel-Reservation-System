<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.email.durgesh.Email"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
    String idreservation = request.getParameter("idreservation");
    Connection con = DatabaseConnection.getConnection();
    Connection con1 = DatabaseConnection.getConnection();
    Statement statement = con.createStatement();
    Statement statement1 = con1.createStatement();

    String query = ("select user_email from reservation where idreservation='" + idreservation + "'");
    ResultSet rs = statement1.executeQuery(query);
    rs.next();
    String user_email = rs.getString("user_email");
    int res_cancel = 0;
    int deleteAccount = statement.executeUpdate("delete from reservation where idreservation='" + idreservation + "' and cancel_res = '" + res_cancel + "'");

    Email email = new Email("internetproject57@gmail.com", "qwe123@thelover");
    email.setFrom("internetproject57@gmail.com", "Hotel Reservation Admin");
    email.setSubject("Cancel Reservation");
    email.setContent("Cancellation is Done Thank you.", "text/html");
    email.addRecipient(user_email);
    email.send();

    if (deleteAccount > 0) {
        response.sendRedirect("reservation.jsp");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Sorry User Done not Make Cancel operation for this reservation Check Your reservation Table Please .');");
        out.println("location='reservation.jsp';");
        out.println("</script>");
    }
%>