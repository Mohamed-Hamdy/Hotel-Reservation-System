/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.room;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Ahmad
 */
@WebServlet(name = "Add_room", urlPatterns = {"/Add_room"})
public class Add_room extends HttpServlet {

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
            try {

                String room_category = request.getParameter("room_category");
                int is_available = Integer.parseInt(request.getParameter("is_available"));
                int max_allwoance = Integer.parseInt(request.getParameter("max_allwoance"));
                String str_price_per_night = request.getParameter("price_per_night");
                double  price_per_night = Double.parseDouble(str_price_per_night);
                String image = request.getParameter("image");
                String room_description = request.getParameter("room_description");
                String room_details = request.getParameter("room_details");
                int hotel_hotelid = Integer.parseInt(request.getParameter("hotel_hotelid"));
                  
                Connection con = DatabaseConnection.getConnection();
                Statement st = con.createStatement();

                int addroom = st.executeUpdate("insert into room(room_category,is_available,max_allowance,price_per_night,image,room_description,room_details,hotel_hotelid) values('" + room_category + "','" + is_available +"','" + max_allwoance +"','" + price_per_night +"','" + image +"','" + room_description +"','" + room_details +"','" + hotel_hotelid + "')");
                if (addroom > 0) {
                    
                    response.sendRedirect("add_room_booking.jsp");
                } else {
                    response.sendRedirect("addroom.jsp");
                }
            } catch (Exception e) {
                out.print(e);
            }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
