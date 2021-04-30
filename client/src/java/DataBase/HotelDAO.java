package DataBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Program.Hotel;
import Program.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
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
@WebServlet(urlPatterns = {"/HotelDAO"})
public class HotelDAO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //out.println(roomNumber);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HotelDAO</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("sssssssss");
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

    public Hotel getHotel(int hotelNumber) {
        Hotel hotel = new Hotel();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hrsystem";
            String user = "root";
            String password = "root";
            Connection con = null;

            con = DriverManager.getConnection(url, user, password);
            // get values from room
            String query = "SELECT * FROM hotel WHERE hotelid = ? ";

            //int Rows = Stmt.executeUpdate(line);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, hotelNumber);
            pst.execute();
            ResultSet rs = pst.getResultSet();

            while (rs.next()) {
                //out.println(rs.getString("category_name"));
                hotel.setHotelNumber(hotelNumber);
                //hotel.setHotelNumber(rs.getInt("hotelid"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setHotelRate(rs.getDouble("hotel_rating"));
                hotel.setTinyIntToIsAvailable(rs.getInt("hotel_availability"));

                hotel.setexpected_price(rs.getDouble("expected_price"));
                hotel.setImgURL(rs.getString("image"));
                hotel.setgallaryImgsURL(rs.getString("hotel_gallary"));

                hotel.sethotel_Location(rs.getString("hotel_Location"));
                hotel.sethotel_details(rs.getString("hotel_details"));

                //hotel.set(rs.getString("hotel_details"));
                //hotel.set(rs.getInt("hotel_availability"));
                hotel.sethotellocationurl(rs.getString("hotel_location_url"));
                hotel.setmax_allow(rs.getInt("max_allowance"));
                hotel.setcheckin(rs.getDate("check_in"));
                hotel.setcheckout(rs.getDate("check_out"));
            }

            con.close();
            pst.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return hotel;
    }

    public ArrayList<Hotel> checkFunction(PrintWriter out, Date desiredCheckIn, Date desiredCheckOut, String location, int numberOfGuest, String filter) {

//        out.println("From HotelDAO_function");
//        out.println(desiredCheckIn);
//        out.println(desiredCheckOut);
//        out.println(location);
//        out.println(numberOfGuest);
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        int controller = numberOfGuest;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hrsystem";
            String user = "root";
            String password = "root";
            Connection con = null;
            int hotelNumber = 0;
            boolean hotel_availability;
            boolean hotelvailable;
            String name = "";
            int values[] = new int[2];
            boolean hotel_vailable = false;
            con = DriverManager.getConnection(url, user, password);
            Statement Stmt = con.createStatement();
            ResultSet filter_rs = Stmt.executeQuery("SELECT * FROM hotel ORDER BY "+ filter +" DESC");
            
            while (filter_rs.next()){
                String DBLocation = filter_rs.getString("hotel_Location");
                int capacity = filter_rs.getInt("max_allowance");

                if ((location.equals(DBLocation)) && (numberOfGuest == capacity )) {
                    // First check if room with assigned roomNumber is FREE
                    hotelNumber = filter_rs.getInt("hotelid");
                    hotel_availability = filter_rs.getBoolean("hotel_availability");
                    //name = rs.getString("hotel_name");

                    if (hotel_availability == true) {
                        values = checkusingDate(out, hotelNumber, desiredCheckIn, desiredCheckOut, location);
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

                    if (hotel_vailable == true && (values[0] != 0)) {
                        HotelDAO rD = new HotelDAO();
                        hotels.add(rD.getHotel(values[0]));
                    }
                }
            }

            //hotelid = hotels.get(i).getHotelNumber();
//            HttpSession sessionid = request.getSession();
//            sessionid.setAttribute("hotelid", hotelid);
            //System.out.println(hotelNumber);
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return hotels;
    }

    public int[] checkusingDate(PrintWriter out, int desiredRoom, Date desiredCheckIn, Date desiredCheckOut, String Location) {
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

            String query = "SELECT b.hotelid , b.hotel_availability FROM hotel AS b WHERE"
                    /*
			Date equal or in between
                     */
                    + " (b.hotelid = ? "
                    + "AND b.check_in <= ? "
                    + "AND b.check_out >= ?) "
                    /*
                        Date starting before checkIn and concluding on anytime after checkIn
                     */
                    + "OR "
                    + "(b.hotelid = ? "
                    + "AND b.check_in >= ? "
                    + "AND b.check_in < ?) "
                    // Date starting after checkIn but before checkOut
                    + "OR "
                    + "(b.hotelid = ? "
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
                isValid = rs.getInt("hotel_availability");
                id = rs.getInt("hotelid");
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
