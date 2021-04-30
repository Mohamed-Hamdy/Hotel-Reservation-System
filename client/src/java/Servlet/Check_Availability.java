package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DataBase.BookingDao;
import DataBase.HotelDAO;
import Program.Hotel;
import Program.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Check_Availability"})
public class Check_Availability extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;

    public Check_Availability() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckAvailability</title>");
            out.println("</head>");
            out.println("<body>");
            Date checkIn = null;
            Date checkOut = null;
            int numberOfGuest = 0;
            String Location = "";
            String filter = "";
            try {
                checkIn = Date.valueOf(request.getParameter("checkIn"));
                checkOut = Date.valueOf(request.getParameter("checkOut"));
                Location = String.valueOf(request.getParameter("Location"));
                numberOfGuest = Integer.parseInt(request.getParameter("numberOfGuest"));
                filter = request.getParameter("filter");
                
//                out.println("From CheckAvailability");
//                out.println(checkIn);
//                out.println(checkOut);
//                out.println(Location);
//                out.println(numberOfGuest);
                HotelDAO h1 = new HotelDAO();
                //BookingDao b1 = new BookingDao();
                //ArrayList<Room> rooms = b1.checkAvailabilityByGuestAndDate(checkIn, checkOut, numberOfGuest);
                ArrayList<Hotel> hotels = h1.checkFunction(out, checkIn, checkOut, Location, numberOfGuest , filter);
                //out.println(hotels.get(1).getHotelName());
                if (hotels.size() == 0) {
                        out.println("<center><div class=\"col-md-4 room_container clearfix\">");
                        out.println("<h2>  To Hotels List To See Our Hotels List </h2>");
                        out.println("<a href=\"Hotels.jsp\"><button type=\"submit\" class=\"btn btn-outline-warning btn-md btn-block \">Go To Our Hotels List</button></a>");
                        out.println("</div></center><br>");

                    out.close();
                } else {

                    out.println("<!DOCTYPE html>");
                    out.println("<body>");
                    
                    for (int i = 0; i < hotels.size(); i++) {
                        hotelViewer(checkIn, checkOut, i, hotels, out, Location, numberOfGuest);
                    }
                    
                    
                    out.println("</body>");
                    out.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

//out.println("</body>");
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

    public void hotelViewer(Date checkIn, Date checkOut, int arrayLocation, ArrayList<Hotel> Hotels, PrintWriter out, String location, int numberOfGuest) {
        //String[] options = new String[]{"Standard", "Standard +", "Premium"};
        String HDetails = Hotels.get(arrayLocation).gethotel_details();
        String hotelname = Hotels.get(arrayLocation).getHotelName();
        String[] detailsArray = HDetails.split("\\.");
        //out.println(imagesgallary);

        double price = Hotels.get(arrayLocation).getexpected_price();
        double Rate = Hotels.get(arrayLocation).getHotelRate();
        String img = Hotels.get(arrayLocation).getImgURL();
        String Location = Hotels.get(arrayLocation).gethotel_Location();

        String imagesgallary = Hotels.get(arrayLocation).getgallaryImgsURL();
        String[] gallaryArray = imagesgallary.split("\\=");
        int hotelid = 0;
        hotelid = Hotels.get(arrayLocation).getHotelNumber();
        //String shotelid = String.valueOf(hotel_id);
        //String hotelname = Hotels.get(arrayLocation).getHotelName();
        String map = Hotels.get(arrayLocation).gethotellocationurl();
//        out.println(gallaryArray[0]);
//        out.println("<br>");
//        out.println(gallaryArray[1]);
//        out.println("<br>");
//        out.println(gallaryArray[2]);
//        out.println("<br>");
//        out.println(gallaryArray[3]);
//        out.println("<br>");
//
//        out.println("List Length : " + list.size());
        out.println("<div class=\"card mb-3\" style=\"max-width: 100%;\">");
        out.println("<div class=\"row no-gutters\">");
        out.println("<div class=\"col-md-4\">");
        out.println("<br><br>");

        out.println("<img style=\"height:350px;\" src=" + img + " class=card-img alt=Hotel_Image %>");

        out.println("</div>");
        out.println("<div class=\"col-md-8 \" style=\"max-width: 100%;\">");
        out.println("<div class=\"card-body d-flex flex-column\" style=\"min-height: 100%;\" >");
        out.println("<h4 class=\"card-title\">" + hotelid + "</h4>");

        out.println("<h4 class=\"card-title\">" + hotelname + "</h4>");
        out.println("<h3 class=\"card-text\">" + Location + "</h3>");
        out.println("<div class=\"ml-4 \" ><ul><li>" + detailsArray[0] + "</li>");
        out.println("<li>" + detailsArray[1] + "</li></ul></div>");
        out.println("<h6>" + detailsArray[2] + "</h6>");
        out.println("<h6>" + detailsArray[3] + "</h6>");
        out.println("<br>");
        out.println("<h5>Price per Night $ " + price + "</h5>");
        out.println("<h5>Hotel Rate $ " + Rate + " / 10</h5>");
        out.println("<form name=\"select\" class=\"mt-auto\" action=\"room-details.jsp\" method=\"POST\">");
        out.println("<input name=\"hid\" type=\"hidden\" value=\"" + hotelid + "\"/>");

        out.println("<input name=\"hotelname\" type=\"hidden\" value=\"" + hotelname + "\"/>");

        out.println("<input name=\"hotelimage\" type=\"hidden\" value=\"" + img + "\"/>");
        out.println("<input name=\"gallary_1\" type=\"hidden\" value=\"" + gallaryArray[0] + "\"/>");
        out.println("<input name=\"gallary_2\" type=\"hidden\" value=\"" + gallaryArray[1] + "\"/>");
        out.println("<input name=\"gallary_3\" type=\"hidden\" value=\"" + gallaryArray[2] + "\"/>");
        out.println("<input name=\"gallary_4\" type=\"hidden\" value=\"" + gallaryArray[3] + "\"/>");
        out.println("<input name=\"hotelmap\" type=\"hidden\" value=\"" + map + "\"/>");
        out.println("<button type=\"submit\" class=\"btn btn-outline-warning btn-md btn-block \">More Details</button>");
        out.println("</form>");

        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.print("</div>");

    }

}
