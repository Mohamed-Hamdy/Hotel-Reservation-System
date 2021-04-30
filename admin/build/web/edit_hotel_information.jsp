<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Hotel Management System Dashboard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
    <nav style="background-color:rgba(0, 0, 0, 0.1);"
         class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">Hotel Online Reservation</a>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="container-fluid">
                    <ul class="nav nav-pills">
                        <li><a href="index.html">Home</a></li>
                        <li class="active"><a href="account.jsp">Accounts</a></li>
                        <li class=""><a href="Adminaccount.jsp">Admin Accounts</a></li>
                        <li><a href="reservation.jsp">Reservation</a></li>
                        <li><a href="hotels.jsp">Hotels</a></li>
                        <li><a href="room.jsp">Room</a></li>
                        <li><a href="view_rate.jsp">Rate</a></li>
                        <li><a href="logout.jsp"><span class="label label-danger"><%=(String) session.getAttribute("uname")%></span>&nbsp;Logout</a></li>
                    </ul>
                </div>
                <br />
                <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="alert alert-info">Hotel Update</div>
                            <br />
                            <%
                                Connection con = DatabaseConnection.getConnection();
                                Statement statement = con.createStatement();
                                ResultSet resultset = statement
                                        .executeQuery("select*from hotel where hotelid='" + request.getParameter("hotelid") + "'");
                               

                                while (resultset.next()) {
                                     HttpSession session1;
                                session1 = request.getSession(true);
                                session1.setAttribute("hotelid_session", resultset.getInt(1));
                            %>
                            <div class="col-md-4">
                                <form method="Get" action="edit_information_process.jsp">

                                    <div class="form-group">
                                        <label>Hotel Name</label> <input type="text"
                                                                         class="form-control" name="hotel_name"
                                                                         value="<%=resultset.getString(2)%>" />
                                    </div>

                                    <div class="form-group">
                                        <label>Hotel Rating </label> <input type="number"
                                                                            class="form-control" name="hotel_rating"
                                                                            value="<%=resultset.getDouble(3)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Hotel Available</label> <input type="number"
                                                                              class="form-control" name="hotel_availability"
                                                                              value="<%=resultset.getInt(4)%>" />
                                    </div>
                                   
                                    <div class="form-group">
                                        <label>Expected Price</label> <input type="number"
                                                                             class="form-control" name="expected_price"
                                                                             value="<%=resultset.getInt(5)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Hotel Image</label> <input type="text"
                                                                             class="form-control" name="image_hotel"
                                                                             value="<%=resultset.getString(6)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Hotel Gallary</label> <input type="text"
                                                                             class="form-control" name="image_gallary"
                                                                             value="<%=resultset.getString(7)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Hotel Location</label> <input type="text"
                                                                             class="form-control" name="hotel_Location"
                                                                             value="<%=resultset.getString(8)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Hotel Details</label> <input type="text"
                                                                            class="form-control" name="hotel_details"
                                                                            value="<%=resultset.getString(9)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>check_in</label> <input type="date"
                                                                       class="form-control" name="check_in"
                                                                       value="<%=resultset.getDate(10)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>check_out</label> <input type="date"
                                                                        class="form-control" name="check_out"
                                                                        value="<%=resultset.getDate(11)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>max_Allowance</label> <input type="number"
                                                                            class="form-control" name="max_allowance"
                                                                            value="<%=resultset.getInt(12)%>" />
                                    </div>
                                    <br />
                                    <div class="form-group">
                                        <button name=""
                                                class="btn btn-info form-control">
                                            <i class="glyphicon glyphicon-save"></i> Update
                                        </button>
                                    </div>
                                </form>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br />
    <br />
   
</body>
</html>