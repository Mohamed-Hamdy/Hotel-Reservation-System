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
        <%Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();
            int id = 0 ;
            int ava = 0;
            ResultSet rs = st.executeQuery("select * from room");
            if (rs.last()) {
                id = rs.getInt("room_id");
                ava = rs.getInt("is_available");
            }
        %>
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
                        <li><a href="account.jsp">Accounts</a></li>
                        <li class=""><a href="Adminaccount.jsp">Admin Accounts</a></li>
                        <li><a href="reservation.jsp">Reservation</a></li>
                        <li class="active"><a href="room.jsp">Room</a></li>
                        <li><a href="view_rate.jsp">Rate</a></li>
                        <li><a href="logout.jsp"><span class="label label-danger"><%=(String) session.getAttribute("uname")%></span>&nbsp;Logout</a></li>
                    </ul>
                </div>
                <br />
                <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="alert alert-info">ADD Room Details</div>
                            <br />
                            <div class="col-md-4">
                                <form method="Get" action="Add_room_booking">

                                    <div class="form-group">
                                        <label>Check in</label> <input type="text"
                                                                       placeholder="Format Linke 2021-01-16" class="form-control" name="check_in" />
                                    </div>
                                    <div class="form-group">
                                        <label>Check out</label> <input type="text"
                                                                        placeholder="Format Linke 2021-01-16" class="form-control" name="check_out" />
                                    </div>
                                    <div class="form-group">
                                        <label>Nights</label> <input type="number"
                                                                     placeholder="int nights number" class="form-control" name="nights" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room ppn</label> <input type="text"
                                                                       placeholder="double ppn number"class="form-control" name="ppn" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room tax</label> <input type="text"
                                                                      placeholder="double tax number" class="form-control" name="tax" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room total</label> <input type="text"
                                                                        placeholder="double total number" class="form-control" name="total" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room Availability</label> <input type="number"
                                                                                placeholder="boolean Availability number" class="form-control" value="<%= ava%>" name="is_valid" />
                                    </div>
                                    <div class="form-group">
                                        <label>room id</label> <input type="number"
                                                                     value ="<%= id%>" class="form-control" name="room_room_id" />
                                    </div>
                                    <br />
                                    <div class="form-group">
                                        <button name="add_account" class="btn btn-info form-control">
                                            <i class="glyphicon glyphicon-save"></i> Submit 
                                        </button>
                                    </div>
                                </form>
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