package DataBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Program.Booking;
import Program.Room;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AA
 */
@WebServlet(urlPatterns = {"/BookingDao"})
public class BookingDao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingDao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingDao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Booking getBooking(int id) {
        Booking newBooking = new Booking();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hrsystem";
            String user = "root";
            String password = "root";
            Connection con = null;

            con = DriverManager.getConnection(url, user, password);

            // get values from DataBase
            String query = "SELECT  b.id, b.check_in, b.check_out, b.nights, b.ppn, b.tax, b.total,"
                    + " u.first_name, u.last_name, u.email, u.phone, r.room_id "
                    + "FROM booking AS b JOIN user AS u "
                    + "ON b.user_id = u.id"
                    + " JOIN room AS r "
                    + "ON b.room_room_id = r.room_id"
                    + " WHERE b.id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            rs.next();

            int bookingId = rs.getInt("id");
            Date checkInDate = rs.getDate("check_in");
            Date checkOutDate = rs.getDate("check_out");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int room_number = rs.getInt("room_number");
            int nights = rs.getInt("nights");
            double ppn = rs.getDouble("ppn");
            double tax = rs.getDouble("tax");
            double total = rs.getDouble("total");

            // Set values on retrieved booking.
            newBooking.setBookingId(bookingId);

            newBooking.setCheckIn(checkInDate);
            newBooking.setCheckOut(checkOutDate);
            newBooking.getUser().setFirstName(firstName);
            newBooking.getUser().setLastName(lastName);
            newBooking.getUser().setEmail(email);
            newBooking.getUser().setPhone(phone);
            newBooking.getRoom().setRoomNumber(room_number);
            newBooking.setNights(nights);
            newBooking.setPPN(ppn);
            newBooking.setTax(tax);
            newBooking.setTotal(total);

            pst.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return newBooking;
    }

    public String getBooking_room_id(int id) {

        String date = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hrsystem";
            String user = "root";
            String password = "root";
            Connection con = null;

            con = DriverManager.getConnection(url, user, password);
            out.println("xxxx");
            // get values from DataBase
            String query = "SELECT  id, check_in, check_out, nights, tax, total FROM booking WHERE room_room_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            rs.next();

            int bookingId = rs.getInt("id");
            Date checkInDate = rs.getDate("check_in");
            Date checkOutDate = rs.getDate("check_out");

            int nights = rs.getInt("nights");

            //double ppn = rs.getDouble("ppn");
            double tax = rs.getDouble("tax");
            double total = rs.getDouble("total");

            String book_id = String.valueOf(bookingId);
            String str_checkInDate = String.valueOf(checkInDate);
            String str_checkOutDate = String.valueOf(checkOutDate);
            String str_nights = String.valueOf(nights);
            String str_tax = String.valueOf(tax);
            String str_total = String.valueOf(total);

            date = book_id + "." + str_checkInDate + "." + str_checkOutDate + "." + str_nights + "." + str_tax + "." + str_total + ".";
            //out.println(date);
            pst.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return date;
    }

//    public boolean checkRoomAvailability(int desiredRoom, Date desiredCheckIn, Date desiredCheckOut) {
//        // Method to avoid creating a booking on a room that is already booked
//        // Based on date
//        boolean roomAvailable = true;
//        int isValid;
//        out.print(desiredRoom);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/hrsystem";
//            String user = "root";
//            String password = "root";
//            Connection con = null;
//
//            con = DriverManager.getConnection(url, user, password);
//
//            String query = "SELECT b.is_valid FROM booking AS b WHERE"
//                    /*
//					 * Date equal or in between
//                     */
//                    + " (b.room_room_number = ? "
//                    + "AND b.check_in <= ? "
//                    + "AND b.check_out >= ?) "
//                    /*
//					 * Date starting before checkIn and concluding on anytime after checkIn
//                     */
//                    + "OR "
//                    + "(b.room_room_number = ? "
//                    + "AND b.check_in >= ? "
//                    + "AND b.check_in < ?) "
//                    // Date starting after checkIn but before checkOut
//                    + "OR "
//                    + "(b.room_room_number = ? "
//                    + "AND b.check_in < ? "
//                    + "AND b.check_out > ?)";
//
//            PreparedStatement pst = con.prepareStatement(query);
//            pst.setInt(1, desiredRoom);
//            pst.setDate(2, desiredCheckIn);
//            pst.setDate(3, desiredCheckOut);
//            pst.setInt(4, desiredRoom);
//            pst.setDate(5, desiredCheckIn);
//            pst.setDate(6, desiredCheckOut);
//            pst.setInt(7, desiredRoom);
//            pst.setDate(8, desiredCheckIn);
//            pst.setDate(9, desiredCheckIn);
//            pst.execute();
//            ResultSet rs = pst.getResultSet();
//            while (rs.next()) {
//                isValid = rs.getInt("is_valid");
//
//                /*
//				 * if isValid = 0 then the room has been booked AND the booking has been
//				 * cancelled. Therefore, the room is available
//                 */
//                if (isValid == 1) {
//                    roomAvailable = false;
//                }
//                if (isValid == 0) {
//                    continue;
//                }
//            }
//            con.close();
//            pst.close();
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return roomAvailable;
//    }

    public ArrayList<Room> checkAvailabilityByGuestAndDate(Date desiredCheckIn, Date desiredCheckOut, int numberOfGuest) {

        ArrayList<Room> rooms = new ArrayList<Room>();
        boolean hotel_availability = false;
        boolean hotel_vailable = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hrsystem";
            String user = "root";
            String password = "root";
            Connection con = null;
            con = DriverManager.getConnection(url, user, password);

            // limit the results to numberOfGuest + 1
            //while (numberOfGuest < (controller + 2)) {
            String query = "SELECT r.is_available, r.room_id "
                    + "FROM room AS r "
                    + " WHERE r.max_allowance= ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, numberOfGuest);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            int roomNumber = 0;
            int hotel_id = 0;
            int values[] = new int[2];
            while (rs.next()) {
                roomNumber = rs.getInt("room_id");

                hotel_availability = rs.getBoolean("is_available");
                //name = rs.getString("hotel_name");

                if (hotel_availability == true) {
                    values = checkusingDate(roomNumber, desiredCheckIn, desiredCheckOut);
                    hotel_vailable = (values[1] == 100); // convert from int to boolean
                    hotel_vailable = true;
                } else {
                    hotel_vailable = false;
                }
//                out.println("id :" + values[0]);
//                out.println("<br>");
//                out.println("int valid : " +values[1]);
//                out.println("<br>");
//                out.println("bool valid :" + hotel_vailable);

                if ( (hotel_vailable == true) && ((values[0] != 0))) {
                    RoomDAO rD = new RoomDAO();
                    rooms.add(rD.getRoom(values[0]));
                }

                // First check if room with assigned roomNumber is FREE
                //out.println("aaaaa");
                //hotel_id = rs.getInt("hotel_hotelid");

            }
            con.close();
            pst.close();
            //   numberOfGuest++;
            //};

            // if there is no results return null
//            if (numberOfGuest > (controller + 1) && rooms.size() == 0) {
//                rooms = null;
//            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return rooms;
    }

    public int[] checkusingDate(int desiredRoom, Date desiredCheckIn, Date desiredCheckOut) {
        // Method to avoid creating a booking on a room that is already booked
        // Based on date
        boolean HotelAvailable = true;
        int isValid = 0;
        int id = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hrsystem";
            String user = "root";
            String password = "root";
            Connection con = null;

            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT b.room_room_id , b.is_valid FROM booking AS b WHERE"
                    /*
			Date equal or in between
                     */
                    + " (b.room_room_id = ? "
                    + "AND b.check_in <= ? "
                    + "AND b.check_out >= ?) "
                    /*
                        Date starting before checkIn and concluding on anytime after checkIn
                     */
                    + "OR "
                    + "(b.room_room_id = ? "
                    + "AND b.check_in >= ? "
                    + "AND b.check_in < ?) "
                    // Date starting after checkIn but before checkOut
                    + "OR "
                    + "(b.room_room_id = ? "
                    + "AND b.check_in < ? "
                    + "AND b.check_out > ?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, desiredRoom);
            pst.setDate(2, desiredCheckIn);
            pst.setDate(3, desiredCheckOut);
            pst.setInt(4, desiredRoom);
            pst.setDate(5, desiredCheckIn);
            pst.setDate(6, desiredCheckOut);
            pst.setInt(7, desiredRoom);

            pst.setDate(8, desiredCheckIn);
            pst.setDate(9, desiredCheckIn);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            while (rs.next()) {
                isValid = rs.getInt("is_valid");
                id = rs.getInt("room_room_id");
                //out.println(rs.getInt(rs.getInt("is_valid")));
//                out.println(name);
//                out.println(isValid);
//                out.println("<br>");
                if (isValid == 1) {
                    HotelAvailable = false;
                }
                if (isValid == 0) {
                    continue;
                }
            }
            con.close();
            pst.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return new int[]{id, isValid};
    }
}
