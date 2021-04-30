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
                        <li ><a href="account.jsp">Accounts</a></li>
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
                            <div class="alert alert-info">ADD NEW Room</div>
                            <br />
                            <div class="col-md-4">
                                <form method="Get" action="Add_room">
                                  
                                    <div class="form-group">
                                        <label>Room Category</label> <input type="text"
                                                                        class="form-control" name="room_category" />
                                    </div>
                                    <div class="form-group">
                                        <label>Availability</label> <input type="number"
                                                                        class="form-control" name="is_available" />
                                    </div>
                                    <div class="form-group">
                                        <label>Max Allowance</label> <input type="number"
                                                                        class="form-control" name="max_allwoance" />
                                    </div>
                                    <div class="form-group">
                                        <label>Price Night</label> <input type="number"
                                                                        class="form-control" name="price_per_night" />
                                    </div>
                                    <div class="form-group">
                                        <label>Image</label> <input type="text"
                                                                        class="form-control" name="image" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room Description</label> <input type="text"
                                                                        class="form-control" name="room_description" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room Details</label> <input type="text"
                                                                        class="form-control" name="room_details" />
                                    </div>
                                    <div class="form-group">
                                        <label>Hotel ID</label> <input type="number"
                                                                        class="form-control" name="hotel_hotelid" />
                                    </div>
                                    <br />
                                    <div class="form-group">
                                        <button name="add_account" class="btn btn-info form-control">
                                            <i class="glyphicon glyphicon-save"></i> Next
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