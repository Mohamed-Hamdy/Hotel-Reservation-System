<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
    String hotelid_session = request.getSession().getAttribute("hotelid_session").toString();
    int id = Integer.parseInt(hotelid_session);
    String hotel_name = request.getParameter("hotel_name");
    Double hotel_rating = Double.valueOf(request.getParameter("hotel_rating"));
    int hotel_availability = Integer.parseInt(request.getParameter("hotel_availability"));
    Double expected_price = Double.valueOf(request.getParameter("expected_price"));
    String image_hotel = request.getParameter("image_hotel");
    String image_gallary = request.getParameter("image_gallary");
    String hotel_Location = request.getParameter("hotel_Location");
    String hotel_details = request.getParameter("hotel_details");
    Date check_in = Date.valueOf(request.getParameter("check_in"));
    Date check_out = Date.valueOf(request.getParameter("check_out"));
    int max_allowance = Integer.parseInt(request.getParameter("max_allowance"));

    try {
        Connection con = DatabaseConnection.getConnection();
        Statement statement = con.createStatement();
        int edit_hotel = statement.executeUpdate("Update hotel set hotel_name='" + hotel_name + "'," + "hotel_rating=" + hotel_rating + ","
                + "hotel_availability = " + hotel_availability + "," + "expected_price=" + expected_price + ","+"image= '" +image_hotel + "',"
                + "hotel_gallary= '" + image_gallary + "'," + "hotel_Location= '" + hotel_Location + "',"
                + "hotel_details= '" + hotel_details + "'," + "check_in='" + check_in + "'," + "check_out='" + check_out + "',"
                + "max_allowance=" + max_allowance + " where hotelid = " + id + "");

        if (edit_hotel > 0) {
            response.sendRedirect("hotels.jsp");
        } else {
            response.sendRedirect("edit_hotel_information.jsp");
        }
    } catch (Exception e) {
        out.print(e);
        e.printStackTrace();
    }
%>