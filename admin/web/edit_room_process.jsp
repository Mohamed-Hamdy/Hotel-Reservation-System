<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
    String roomid_session = request.getSession().getAttribute("roomid_session").toString();
    int id = Integer.parseInt(roomid_session);
    String room_category = request.getParameter("room_category");
    int is_available = Integer.parseInt(request.getParameter("is_available"));
    int max_allwoance = Integer.parseInt(request.getParameter("max_allwoance"));
    String str_price_per_night = request.getParameter("price_per_night");
    double price_per_night = Double.parseDouble(str_price_per_night);

    String image = request.getParameter("image");
    String room_description = request.getParameter("room_description");
    String room_details = request.getParameter("room_details");

    try {
        Connection con = DatabaseConnection.getConnection();
        Statement statement = con.createStatement();
        int edit_room = statement.executeUpdate("Update room set room_category='" + room_category + "'," + "is_available=" + is_available + ","
                + "max_allowance=" + max_allwoance + "," + "price_per_night='" + price_per_night + "'," + "image='" + image + "',"
                + "room_description='" + room_description + "'," + "room_details='" + room_details + "'"
                + " where room_id = " + id + "");

        if (edit_room > 0) {
            response.sendRedirect("edit_room_booking.jsp");
        } else {
            response.sendRedirect("edit_room.jsp");
        }
    } catch (Exception e) {
        out.print(e);
        e.printStackTrace();
    }
%>