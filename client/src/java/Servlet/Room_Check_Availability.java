package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataBase.BookingDao;
import DataBase.HotelDAO;
import Program.Booking;
import Program.Hotel;
import Program.Room;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

@WebServlet("/Room_Check_Availability")
public class Room_Check_Availability extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Room_Check_Availability() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        Date checkIn = null;
        Date checkOut = null;
        int numberOfGuest = 0;

        try {
            checkIn = Date.valueOf(request.getParameter("checkIn"));
            checkOut = Date.valueOf(request.getParameter("checkOut"));
            numberOfGuest = Integer.parseInt(request.getParameter("numberOfGuest"));
        } catch (Exception e) {
            System.out.println(e);
        }
        //out.println("checkIn");
        
        BookingDao b1 = new BookingDao();
        ArrayList<Room> rooms = b1.checkAvailabilityByGuestAndDate(checkIn, checkOut, numberOfGuest);
        PrintWriter out = response.getWriter();
        out.println(rooms.size());
        if (rooms == null) {
            out.println("<div class=\"room_container clearfix\">");
            out.println("<h6> There are no rooms available for the selected dates</h6>");
            out.println("<p href=\"index.jsp\">Please select different dates</p>");
            out.println("</div>");
            out.close();
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<body>");
            for (int i = 0; i < rooms.size(); i++) {
                roomViewer(checkIn, checkOut, i, rooms, out, numberOfGuest);
            }
            out.println("</body>");
            out.close();
        }
    }

    

    private void roomViewer(Date checkIn, Date checkOut, int arrayLocation, ArrayList<Room> rooms, PrintWriter out, int numberOfGuest) throws ServletException,
            IOException {
        String rDescription = rooms.get(arrayLocation).getRoomDescription();
        String rDetails = rooms.get(arrayLocation).getRoomDetails();
        String[] detailsArray = rDetails.split("\\.");
        double price = rooms.get(arrayLocation).getPricePerNight();
        int roomNumber = rooms.get(arrayLocation).getRoomNumber();
        String img = rooms.get(arrayLocation).getImgURL();
        int hotel_id = rooms.get(arrayLocation).gethotelid();
        String catogry = rooms.get(arrayLocation).getRoomCategoryName();
        String[] options = catogry.split("\\.");
        HotelDAO b1 = new HotelDAO();
        Hotel hotel = b1.getHotel(hotel_id);
        String hotel_name = hotel.getHotelName();
        String hotel_location = hotel.gethotel_Location();
        BookingDao c1 = new BookingDao();
        String room_book_info = c1.getBooking_room_id(roomNumber);
        String[] bookArray = room_book_info.split("\\.");
       // out.println(room_book_info);
        String room_booking_id = bookArray[0];
        String room_checkin = bookArray[1];
        String room_checkout = bookArray[2];
        String room_nights_num = bookArray[3];
        String room_tax = bookArray[4];
        String room_total_price = bookArray[5];

        out.println("<div class=\"card mb-3\" style=\"max-width: 100%;\">");
        out.println("<div class=\"row no-gutters\">");
        out.println("<div class=\"col-md-4\">");
        out.println("<img src=" + img + " ckass=card-img alt=Hotel_Image >");
        out.println("</div>");
        out.println("<div class=\"col-md-8 \" style=\"max-width: 100%;\">");
        out.println("<div class=\"card-body d-flex flex-column\" style=\"min-height: 100%;\" >");
        //out.println("<h3 class=\"card-title\">" + options[arrayLocation] + "</h3>");
        out.println("<h3 class=\"card-title\">" + options[1] + "</h3>");
        
        out.println("<h4 class=\"card-title\">" + hotel_name + " Hotel</h4>");
        out.println("<h5 class=\"card-title\">" + options[0] + " Room </h5>");

        out.println("<h6 class=\"card-title\">Hotel Location " + hotel_location + "</h6>");

        out.println("<p class=\"card-text\">" + rDescription + "</p>");
        out.println("<div class=\"ml-4 \" ><ul><li>" + detailsArray[0] + "</li>");
        out.println("<li>" + detailsArray[1] + "</li></ul></div>");
        out.println("<h5>Price per Night $ " + price + "</h5>");
        out.println("<strong><p class=\"card-text\"> room will available from " + room_checkin +" to " +  room_checkout +"</p></strong>");

        out.println("<form name=\"select\" class=\"mt-auto\" action=\"SelectedRoom\" method=\"post\">");
        //out.println("<input name=\"hotelid\" type=\"hidden\" value=\"" + hotel_id + "\"/>");
        out.println("<input name=\"categ\" type=\"hidden\" value=\"" + options[arrayLocation] + "\"/>");
        out.println("<input name=\"img\" type=\"hidden\" value=\"" + img + "\"/>");
        out.println("<input name=\"price\" type=\"hidden\" value=\"" + price + "\"/>");
        out.println("<input name=\"hNum\" type=\"hidden\" value=\"" + hotel_id + "\"/>");
        out.println("<input name=\"hName\" type=\"hidden\" value=\"" + hotel_name + "\"/>");
        out.println("<input name=\"hlocation\" type=\"hidden\" value=\"" + hotel_location + "\"/>");
        out.println("<input name=\"rNum\" type=\"hidden\" value=\"" + roomNumber + "\"/>");
        out.println("<input name=\"cIn\" type=\"hidden\" value=\"" + checkIn + "\"/>");
        out.println("<input name=\"cOut\" type=\"hidden\" value=\"" + checkOut + "\"/>");
        out.println("<input name=\"numGuest\" type=\"hidden\" value=\"" + numberOfGuest + "\"/>");
        out.println("<input name=\"rDescription\" type=\"hidden\" value=\"" + rDescription + "\"/>");
        out.println("<input name=\"rDetails\" type=\"hidden\" value=\"" + rDetails + "\"/>");
        out.println("<button type=\"submit\" class=\"btn btn-outline-warning btn-md btn-block \">Book</button>");
        out.println("</form>");

        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.print("</div>");
    }
}
