<%@page import="java.sql.Date"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    int rid = 0;
    String rname = "";
    String fName = "";
    String lName = "";
    int rroomnum = 0;
    String remail = "";
    Date rcheckin;
    Date rcheckout;
    int rnights = 0;
    double rcost = 0.0;

    int phone = 0;
    String connectionURL = "jdbc:mysql://localhost:3306/hrsystem";
    Connection connection = null;
    ResultSet rs;
    response.setContentType("text/html");

    rid = Integer.parseInt(request.getParameter("rid"));
    rname = request.getParameter("rname");
    String[] arr_name = rname.split("\\s+"); ;
    
    remail = request.getParameter("remail");
    rroomnum = Integer.parseInt(request.getParameter("rrnum"));
    rcheckin = Date.valueOf(request.getParameter("rcheckin"));
    rcheckout = Date.valueOf(request.getParameter("rcheckout"));
    rnights = Integer.parseInt(request.getParameter("rnights"));
    rcost = Double.parseDouble(request.getParameter("rcost"));
    phone = Integer.parseInt(request.getParameter("rphone"));
    

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
            <form action="Editreservation" method="GET">
                
                <input type="hidden" name="rid" value="<%= rid%>">

                <label for="fname">Your First Name</label>
                <input type="text" name="fName" value="<%= arr_name[0]%>">

                <label for="lname">Your Last Name</label>
                <input type="text" name="lName" value="<%= arr_name[1]%>" >

                <label for="rcheckin">Check In</label>
                <input type="text" name="Rescheckin" value="<%= rcheckin%>" >

                <label for="rcheckout">Check Out</label>
                <input type="text" name="Rescheckout" value="<%= rcheckout%>" >

                <label for="phone">Your Phone</label>
                <input type="text" name="telenumber" value="<%= phone%>" >

                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
    
</html>