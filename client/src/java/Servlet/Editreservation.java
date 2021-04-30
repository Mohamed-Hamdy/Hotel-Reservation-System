package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.email.durgesh.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.concurrent.TimeUnit.DAYS;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AA
 */
@WebServlet(urlPatterns = {"/Editreservation"})
public class Editreservation extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editreservation</title>");
            out.println("</head>");
            out.println("<body>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con = null;
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem", "root", "root");
            //out.println("aaaaaaaaaaaaaa");

            String Str_id = request.getParameter("rid");
            int id = Integer.parseInt(Str_id);
            //out.println(id);
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            //out.println(fName + " " + lName);
            String Str_phone = request.getParameter("telenumber");
            int phone = Integer.parseInt(Str_phone);
            //out.println(" " + phone);
            String Str_rcheckin = request.getParameter("Rescheckin");
            Date rcheckin = Date.valueOf(Str_rcheckin);
            String Str_rcheckout = request.getParameter("Rescheckout");
            Date rcheckout = Date.valueOf(Str_rcheckout);
            //out.println(rcheckin +" " +  rcheckout);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();

            String PC_Date = String.valueOf(dateFormat.format(cal.getTime()));
            LocalDate dateBefore = LocalDate.parse(String.valueOf(rcheckin));
            LocalDate dateAfter = LocalDate.parse(String.valueOf(rcheckout));
            String Database_Date = String.valueOf(rcheckin);

            long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
            int DBnights = Math.abs((int)noOfDaysBetween);
            double tax_nights = Math.abs(DBnights);
            double tax = tax_nights * 12.5;
            double total = tax * tax_nights;
            //out.println("<br>");
            //out.println(DBnights);
            PreparedStatement ps = Con.prepareStatement(
                    "UPDATE reservation SET user_first_name = ?, user_last_name = ?, user_phone = ?, res_checkIn = ? , res_checkout = ?, res_nights = ? , res_tax = ?, res_total = ? WHERE idreservation = ? ");

            // set the preparedstatement parameters
            ps.setString(1, fName);
            ps.setString(2, lName);
            //ps.setString(3, email);
            ps.setInt(3, phone);
            ps.setDate(4, rcheckout);

            ps.setDate(5, rcheckin);
            ps.setInt(6, DBnights);
            ps.setDouble(7, tax);
            ps.setDouble(8, total);
            ps.setInt(9, id);
            ps.executeUpdate();
            HttpSession session = request.getSession();

            Email mail = new Email("cs111math111@gmail.com", "01206398496MohameD");
            mail.setFrom("mohamedhamdy@stud.fci-cu.edu.eg", "Hotel Team Work");
            mail.setSubject("Please check Database User Edit Reservation");
            mail.setContent("Modified Reservation by user that have id = " + id , "text/html");
            mail.addRecipient("internetproject57@gmail.com");
            mail.send();
            response.sendRedirect("FindReservation.jsp");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Editreservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Editreservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Editreservation.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Editreservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Editreservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Editreservation.class.getName()).log(Level.SEVERE, null, ex);
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
