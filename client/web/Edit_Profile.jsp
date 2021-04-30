<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    String fName = "";
    String lName = "";
    String phone = "";
    String address = "";
    String city = "";
    String postalCode = "";
    String country = "";
    String password = "";
    String id_session = request.getSession().getAttribute("Userid").toString();
    String connectionURL = "jdbc:mysql://localhost:3306/hrsystem";
    Connection connection = null;
    ResultSet rs;
    String id = "";
    response.setContentType("text/html");

    try {
        // Load the database driver
        Class.forName("com.mysql.jdbc.Driver");
        // Get a Connection to the database
        connection = DriverManager.getConnection(connectionURL, "root", "root");

        //Add Login user data to the database (Customer Table)
        String sql = "select * from user where id ='" + id_session + "';";
        Statement s = connection.createStatement();
        s.executeQuery(sql);
        rs = s.getResultSet();
        while (rs.next()) {
            fName = rs.getString("first_name");
            lName = rs.getString("last_name");
            address = rs.getString("address");
            city = rs.getString("city");
            postalCode = rs.getString("postal_code");
            country = rs.getString("country");
            phone = rs.getString("phone");
            password = rs.getString("password");

        }
        rs.close();
        s.close();
    } catch (Exception e) {
        System.out.println("Exception is ;" + e);
    }
%>
<html>
    <head>
        <style>
            input[type=text], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type=submit] {
                width: 50%;

                background-color: #212529;
                color: #fd7e14;
                padding: 14px 20px;
                margin: 8px 25%;
                border-radius: 4px;
                cursor: pointer;
                border: 2px solid #fd7e14;

            }

            input[type=submit]:hover {
                background-color: #ffc107;
                color:#212529;
                border: 2px solid;
            }

            div {

                width: 30%;
                border-radius: 5px;
                background-color: #f2f2f2;
                margin-left:35%; 
                margin-top: 5%;
                padding: 30px;
            }
        </style>
    </head>
    <body>
        <div>
            <form action="EditProfile" method="get">
                <label for="fname">Your First Name</label>
                <input type="text" name="fName" value="<%=fName%>">

                <label for="lname">Your Last Name</label>
                <input type="text" name="lName" value="<%=lName%>" >
                <label for="lname">Your Address</label>
                <input type="text" name="address" value="<%=address%>" >

                <label for="lname">Your City</label>
                <input type="text" name="city" value="<%=city%>" >

                <label for="lname">Your Phone</label>
                <input type="text" name="phone" value="<%=phone%>" >

                <label for="lname">Your Postal Code</label>
                <input type="text" name="postalCode" value="<%=postalCode%>" >
                <label for="lname">Your Country</label>
                <input type="text" name="country" value="<%=country%>" >
                <label for="lname">Your Password</label>
                <input type="text" name="password" value="<%=password%>" >


                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>