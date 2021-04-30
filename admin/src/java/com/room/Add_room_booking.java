package com.room;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AA
 */
@WebServlet(urlPatterns = {"/Add_room_booking"})
public class Add_room_booking extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add_room_booking</title>");
            out.println("</head>");
            out.println("<body>");
            String check_in = request.getParameter("check_in");
            String check_out = request.getParameter("check_out");

            Date DB_checkin = Date.valueOf(check_in);
            Date DB_checkout = Date.valueOf(check_out);

            String nights = request.getParameter("nights");
            int DB_nights = Integer.parseInt(nights);

            String ppn = request.getParameter("ppn");
            double DB_ppn = Double.valueOf(ppn);

            String tax = request.getParameter("tax");
            double DB_tax = Double.valueOf(tax);

            String total = request.getParameter("total");
            double DB_total = Double.valueOf(total);

            String is_valid = request.getParameter("is_valid");
            int DB_Valid = Integer.parseInt(is_valid);

            String room_room_id = request.getParameter("room_room_id");
            int DB_room_room_id = Integer.parseInt(room_room_id);
            int DB_DB_room_number = Integer.parseInt(room_room_id);

            Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();

            String line = "INSERT INTO booking(check_in, check_out, nights, ppn, tax, total, is_valid, room_room_id , room_number) VALUES("
                    + "'" + DB_checkin + "',"
                    + "'" + DB_checkout + "',"
                    + "'" + DB_nights + "',"
                    + "'" + DB_ppn + "',"
                    + "'" + DB_tax + "',"
                    + "'" + DB_total + "',"
                    + "'" + DB_Valid + "',"
                    + "'" + DB_room_room_id + "',"
                    + "'" + DB_DB_room_number + "')";
            int Rows = st.executeUpdate(line);
            response.sendRedirect("room.jsp");

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
        } catch (SQLException ex) {
            Logger.getLogger(Add_room_booking.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Add_room_booking.class.getName()).log(Level.SEVERE, null, ex);
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
