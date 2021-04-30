package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
    Name : Mohamed Hamdy Mohamed
    ID : 20170227
    Group : IT_IS_1
 */
import DataBase.GuestDAO;
import Program.Guest;
import Program.User;
import com.email.durgesh.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AA
 */
@WebServlet(urlPatterns = {"/NewGuest"})
public class NewGuest extends HttpServlet {

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

            try {

                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hrsystem";
                String user = "root";
                String password = "root";
                Connection Con = null;
                Statement Stmt = null;
                Statement Select_Stmt = null;

                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                Select_Stmt = Con.createStatement();
                int userId = 0;
                String ValidatorEmailMSG = request.getSession().getAttribute("ValidatorEmailMSG").toString();
                String gRecaptchaResponse = request
                        .getParameter("g-recaptcha-response");
                //System.out.println(gRecaptchaResponse);
                if (gRecaptchaResponse.length() != 0 && "".equals(ValidatorEmailMSG)) {
                    String firstName = request.getParameter("fName");
                    String lastName = request.getParameter("lName");

                    String email = request.getParameter("email");
                    //String pass = request.getParameter("pass");

                    String phone = request.getParameter("phone");

                    String address = request.getParameter("address");
                    String city = request.getParameter("city");

                    String country = request.getParameter("country");
                    String postalCode = request.getParameter("postalCode");
                    final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                    SecureRandom random = new SecureRandom();
                    StringBuilder sb = new StringBuilder();
                    int len = 4;
                    for (int i = 0; i < len; i++) {
                        int randomIndex = random.nextInt(chars.length());
                        sb.append(chars.charAt(randomIndex));
                    }
                    
                    String pass = sb.toString();
//                    User newGuest;
//                    newGuest = new Guest(email, pass);
//                    newGuest.setFirstName(firstName);
//                    newGuest.setLastName(lastName);
//                    newGuest.setaddress(address);
//                    newGuest.setPhone(phone);
//                    newGuest.setCountry(country);
//                    newGuest.setCity(city);
//                    newGuest.setPostalCode(postalCode);
//                    newGuest.setEmail(email);
                    //GuestDAO newGD = new GuestDAO();
                    //userId = newGD.addUser(newGuest);

                    

                    String line = "INSERT INTO user(first_name, last_name, email, address, city, postal_code, country, phone, password) VALUES("
                            + "'" + firstName + "',"
                            + "'" + lastName + "',"
                            + "'" + email + "',"
                            + "'" + address + "',"
                            + "'" + city + "',"
                            + "'" + postalCode + "',"
                            + "'" + country + "',"
                            + "'" + phone + "',"
                            + "'" + pass + "')";
                    int Rows = Stmt.executeUpdate(line);
                    Email mail = new Email("internetproject57@gmail.com", "qwe123@thelover");
                    mail.setFrom("mohamedhamdy@stud.fci-cu.edu.eg", "Hotel Team Work");
                    mail.setSubject("Email Password");
                    mail.setContent("<h1>your password is : <h1>" + sb.toString(), "text/html");
                    //mail.setContent("<a href=https://www.google.com >Click </a>" , "text/html");
                    
                    mail.addRecipient(email);
                    mail.send();

                    String select_sql = "select * from user where email = '" + email + "';";
                    ResultSet Check_id_RS = Select_Stmt.executeQuery(select_sql);
                    while (Check_id_RS.next()) {
                        userId = Check_id_RS.getInt("id");
                    }

                    //out.println(userId);
                    if (userId != 0) {

                        // if succesfull create session for user
                        HttpSession session = request.getSession();
                        session.removeAttribute("error");
                        session.setAttribute("username", email);
                        session.setAttribute("Userid", userId);
                        session.setAttribute("fName", firstName);
                        session.setAttribute("lName", lastName);
                        session.setAttribute("phone", phone);
                        session.setAttribute("email", email);
                        session.setAttribute("address", address);
                        session.setAttribute("city", city);
                        session.setAttribute("postalCode", postalCode);
                        session.setAttribute("country", country);
                        session.setAttribute("password", pass);
                        response.sendRedirect("Index.jsp");

                    } else {
                        String error = "e";
                        HttpSession session = request.getSession();
                        session.setAttribute("error", error);
                        response.sendRedirect("Join.jsp");
                    }

                    Stmt.close();
                    Con.close();

                } else {
                    String error = "e";
                    HttpSession session = request.getSession();
                    session.setAttribute("error", error);
                    response.sendRedirect("Join.jsp");
                }

                //response.sendRedirect("index.html");
            } catch (Exception ex) {
                ex.printStackTrace();
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
