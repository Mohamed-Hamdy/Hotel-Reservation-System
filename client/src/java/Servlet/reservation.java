package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import com.email.durgesh.Email;

/**
 *
 * @author AA
 */
@WebServlet(urlPatterns = {"/reservation"})
public class reservation extends HttpServlet {

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
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reservation</title>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            //String n = (String) session.getAttribute("username");
//            out.println(n + "  " + email);
            //String ValidatorEmailMSG = request.getSession().getAttribute("ValidatorEmailMSG").toString();
            
            if (session.getAttribute("username") == null) {

                String error = "e";
                    HttpSession mailsession = request.getSession();
                    mailsession.setAttribute("error", error);
                    response.sendRedirect("reservation.jsp");
            } else {
                //out.println("in");
                int hotelid;
                int roomNumber;
                Date checkIn;
                Date checkOut;
                int nights;
                double ppn;
                double tax;
                double total;
                int user_id;
                String firstName = request.getParameter("fName");
                String lastName = request.getParameter("lName");
                //String email = request.getParameter("email");
                String email = request.getParameter("email");

                String address = request.getParameter("address");
                String phone = request.getParameter("phone");

                String city = request.getParameter("city");
                String country = request.getParameter("country");
                String postalCode = request.getParameter("postalCode");
                
                user_id = Integer.parseInt((String) request.getParameter(("user_id")));
                
                hotelid = Integer.parseInt((String) request.getParameter(("hotelid")));
                roomNumber = Integer.parseInt((String) request.getParameter(("roomNumberSelected")));

                checkIn = Date.valueOf(request.getParameter("checkInForRoom"));
                checkOut = Date.valueOf(request.getParameter("checkOutForRoom"));

                nights = Integer.parseInt(String.valueOf(request.getParameter("nights")));
                ppn = Double.parseDouble(String.valueOf(request.getParameter("ppn")));
                tax = Double.parseDouble(String.valueOf(request.getParameter("tax")));
                total = Double.parseDouble(String.valueOf(request.getParameter("total")));

                String cvv = request.getParameter("cvv");
                String ccNumber = request.getParameter("ccNumber");
                
                //out.println(email + " " + firstName + " " +lastName );
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/hrsystem";
                    String user = "root";
                    String password = "root";
                    Connection Con = null;
                    Statement Stmt = null;

                    Con = DriverManager.getConnection(url, user, password);
                    Stmt = Con.createStatement();

                    Email mail = new Email("internetproject57@gmail.com", "qwe123@thelover");
                    mail.setFrom("mohamedhamdy@stud.fci-cu.edu.eg", "Hotel Team Work");
                    mail.setSubject("reservation confirm");
                    mail.setContent("Confirm Your reservation\n<a href=https://www.google.com >Click To Confirm Reservation Please</a>", "text/html");
                    //out.println("1");
                    mail.addRecipient(email);
                    mail.send();
                    int cancel_res = 1;
                    String line = "INSERT INTO reservation(user_first_name, user_last_name, user_email, user_address, user_phone, user_city, user_country, postel_code, hotel_hotelid, room_room_id, res_checkIn, res_checkout, res_nights, res_ppn, res_tax, res_total , cancel_res,user_id) VALUES("
                            + "'" + firstName + "',"
                            + "'" + lastName + "',"
                            + "'" + email + "',"
                            + "'" + address + "',"
                            + "'" + phone + "',"
                            + "'" + country + "',"
                            + "'" + city + "',"
                            + "'" + postalCode + "',"
                            + "'" + hotelid + "',"
                            + "'" + roomNumber + "',"
                            + "'" + checkIn + "',"
                            + "'" + checkOut + "',"
                            + "'" + nights + "',"
                            + "'" + ppn + "',"
                            + "'" + tax + "',"
                            + "'" + total + "',"
                            + "'" + cancel_res + "',"
                            + "'" + user_id + "')";
                    int Rows = Stmt.executeUpdate(line);
                   // out.println("2");
                    out.println("<script>");
                    out.println("alert('Thank You Please Confirm Your email');");
                    out.println("location='Index.jsp';");
                    out.println("</script>");
                    // response.sendRedirect("index.html");

                    Stmt.close();
                    Con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
