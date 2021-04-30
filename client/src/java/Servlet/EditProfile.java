package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/EditProfile"})
public class EditProfile extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet codeupdate</title>");
            out.println("</head>");
            out.println("<body>");
            Class.forName("com.mysql.jdbc.Driver");
            com.mysql.jdbc.Connection Con = null;
            com.mysql.jdbc.Statement Stmt = null;

            String id_session = request.getSession().getAttribute("Userid").toString();
            int id = Integer.parseInt(id_session);
            //out.println("<h1>Ddddddddd</h1>");
            Con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem", "root", "root");
            Stmt = (com.mysql.jdbc.Statement) Con.createStatement();

            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            //String email = request.getParameter("email");
            String address = request.getParameter("address");

            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String postalCode = request.getParameter("postalCode");
            String country = request.getParameter("country");
            String password = request.getParameter("password");
            PreparedStatement ps = Con.prepareStatement(
                    "UPDATE user SET first_name = ?, last_name = ?, address = ? , city = ?, postal_code = ?, country = ? , phone = ?, password = ? WHERE id = ? ");

            // set the preparedstatement parameters
            ps.setString(1, fName);
            ps.setString(2, lName);
            //ps.setString(3, email);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, postalCode);
            ps.setString(6, country);
            ps.setString(7, phone);
            ps.setString(8, password);
            ps.setInt(9, id);
            ps.executeUpdate();

            response.sendRedirect("Index.jsp");

            ps.close();
            Con.close();
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
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
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
