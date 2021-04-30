package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/Addreview"})
public class Addreview extends HttpServlet {

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
            out.println("<title>Servlet Addreview</title>");
            out.println("</head>");
            out.println("<body>");

            String hname = request.getParameter("review_hotelname");
            String uname = request.getParameter("review_username");
            String rate = request.getParameter("review_rate");
            int Urate = Integer.parseInt(rate);
            String rarea = request.getParameter("review_texrarea");
            HttpSession session = request.getSession();

            Connection Con = null;
            Statement Stmt = null;
            Connection Con1 = null;
            Statement Stmt1 = null;
            ResultSet rs = null;
            if (session.getAttribute("username") != null) {

                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hrsystem";
                String user = "root";
                String password = "root";
                Con1 = DriverManager.getConnection(url, user, password);
                String sql = "select id from user where email = '" + uname + "';";
                Stmt1 = Con1.createStatement();
                Stmt1.executeQuery(sql);
                rs = Stmt1.getResultSet();
                int user_id = 0;
                while (rs.next()) {
                    user_id = rs.getInt("id");
                }
                
                
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                //out.println("1");

                PreparedStatement st = Con.prepareStatement("INSERT INTO rate (username, rate, user_review, hotel_name,user_id ) VALUES (?,?,?,?,?)");

                st.setString(1, uname);
                st.setInt(2, Urate);
                st.setString(3, rarea);
                st.setString(4, hname);
                st.setInt(5, user_id);

                int row = st.executeUpdate();
                out.println("<script>");
                out.println("alert('Thanks For Your Review.');");
                out.println("location='Hotels.jsp';");
                out.println("</script>");

            } else {
                out.println("<script>");
                out.println("alert('Please Check Your Username Or Hotel name or Join our family');");
                out.println("location='Join.jsp';");
                out.println("</script>");
            }

            Stmt.close();
            Con.close();
            rs.close();
            Stmt1.close();
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println(e);
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
            Logger.getLogger(Addreview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(Addreview.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Addreview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(Addreview.class
                    .getName()).log(Level.SEVERE, null, ex);
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
