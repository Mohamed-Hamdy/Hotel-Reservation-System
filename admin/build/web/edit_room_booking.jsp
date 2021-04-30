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
                        <li><a href="hotels.jsp">Hotels</a></li>
                        <li class="active"><a href="room.jsp">Room</a></li>
                        <li><a href="view_rate.jsp">Rate</a></li>
                        <li><a href="logout.jsp"><span class="label label-danger"><%=(String) session.getAttribute("uname")%></span>&nbsp;Logout</a></li>
                    </ul>
                </div>
                <br />
                <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="alert alert-info">Room Update</div>
                            <br />
                            <%
                                String roomid_session = request.getSession().getAttribute("roomid_session").toString();
                                int id = Integer.parseInt(roomid_session);
    
                                Connection con = DatabaseConnection.getConnection();
                                Statement statement = con.createStatement();
                                ResultSet resultset = statement
                                        .executeQuery("select * from booking where room_room_id='" +id + "'");

                                while (resultset.next()) {
                                    HttpSession session1;
                                    session1 = request.getSession(true);
                                    session1.setAttribute("roomid_session", resultset.getInt(1));
                            %>
                            <div class="col-md-4">
                                <form method="Get" action="Edit_room_booking">

                                    <div class="form-group">
                                        <label>Check In</label> <input type="text"
                                                                       class="form-control" name="check_in"
                                                                       value="<%=resultset.getString(2)%>" />
                                    </div>

                                    <div class="form-group">
                                        <label>Check Out </label> <input type="text"
                                                                         class="form-control" name="check_out"
                                                                         value="<%=resultset.getString(3)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>nights</label> <input type="number"
                                                                     class="form-control" name="nights"
                                                                     value="<%=resultset.getInt(4)%>" />
                                    </div>

                                    <div class="form-group">
                                        <label>Price Per Nights</label> <input type="text"
                                                                               class="form-control" name="ppn"
                                                                               value="<%=resultset.getString(5)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Tax</label> <input type="text"
                                                                  class="form-control" name="tax"
                                                                  value="<%=resultset.getString(6)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Total</label> <input type="text"
                                                                    class="form-control" name="total"
                                                                    value="<%=resultset.getString(7)%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Room Availability</label> <input type="number"
                                                                                class="form-control" name="is_vaild"
                                                                                value="<%=resultset.getString(8)%>" />
                                    </div>


                                    <br />
                                    <div class="form-group">
                                        <button name=""
                                                class="btn btn-info form-control">
                                            <i class="glyphicon glyphicon-save"></i> Submit
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