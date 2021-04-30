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
import java.sql.Statement;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AA
 */
@WebServlet(urlPatterns = {"/Edit_room_booking"})
public class Edit_room_booking extends HttpServlet {

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
            out.println("<title>Servlet Edit_room_booking</title>");
            out.println("</head>");
            out.println("<body>");
            
            String roomid_session = request.getSession().getAttribute("roomid_session").toString();
            int id = Integer.parseInt(roomid_session);
            Date check_in = Date.valueOf(request.getParameter("check_in"));
            Date check_out = Date.valueOf(request.getParameter("check_out"));
            
            int nights = Integer.parseInt(request.getParameter("nights"));
            String str_ppn = request.getParameter("ppn");
            double ppn = Double.parseDouble(str_ppn);
            String str_tax = request.getParameter("tax");
            double tax = Double.parseDouble(str_tax);
            String str_total = request.getParameter("total");
            double total = Double.parseDouble(str_total);
            int is_vaild = Integer.parseInt(request.getParameter("is_vaild"));
            
            
            
            try {
                Connection con = DatabaseConnection.getConnection();
                Statement statement = con.createStatement();
                int edit_room = statement.executeUpdate("Update booking set check_in='" + check_in + "'," + "check_out='" + check_out + "',"
                        + "nights='" + nights + "'," + "ppn='" + ppn + "'," + "tax='" + tax + "',"
                        + "total='" + total + "'," + "is_valid='" + is_vaild + "'"
                        + " where room_room_id ='" + id + "'");

                if (edit_room > 0) {
                    response.sendRedirect("room.jsp");
                } else {
                    response.sendRedirect("edit_room.jsp");
                }
            } catch (Exception e) {
                out.print(e);
                e.printStackTrace();
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

}
