package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Program.User;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class VerifyLogIn
 */
@WebServlet("/VerifyLogIn")
public class VerifyLogIn extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Connection connection = null;
        ResultSet rs;
        String DBId = "";
        String DBmail = "";
        String DBpass = "";
        String form_email = "";
        String form_password = "";
        String originPage = "";
        String DBFname = "";
        String DBLname = "";
        String DBAddress = "";
        String DBCity = "";
        String DBPostal_code = "";
        String DBCountry = "";
        String DBPhone = "";
        response.setContentType("text/html");

        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem", "root", "root");
            form_email = request.getParameter("email");
            form_password = request.getParameter("password");
            originPage = request.getParameter("originURL");

            //Add Login user data to the database (Customer Table)
            String sql = "select * from user where email = '" + form_email + "' and password ='" + form_password + "';";
            Statement s = connection.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {
                DBId = rs.getString("id");
                DBFname = rs.getString("first_name");
                DBLname = rs.getString("last_name");
                DBmail = rs.getString("email");
                DBAddress = rs.getString("address");
                DBCity = rs.getString("city");

                DBPostal_code = rs.getString("postal_code");

                DBCountry = rs.getString("country");
                DBPhone = rs.getString("phone");

                DBpass = rs.getString("password");

            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

        if (form_password.equals(DBpass)) {
            //user = gD.getUser(gD.getUserId(uName));

            HttpSession session = request.getSession();
            session.removeAttribute("fail");
            session.setAttribute("username", DBmail);
            session.removeAttribute("error");

            session.setAttribute("Userid", DBId);

            session.setAttribute("fName", DBFname);
            session.setAttribute("lName", DBLname);
            session.setAttribute("phone", DBPhone);
            session.setAttribute("email", DBmail);
            session.setAttribute("address", DBAddress);
            session.setAttribute("city", DBCity);
            session.setAttribute("postalCode", DBPostal_code);
            session.setAttribute("country", DBCountry);
            session.setAttribute("password", DBpass);
            response.sendRedirect(originPage);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("fail", 1);
            response.sendRedirect(originPage);
        }
    }

}
