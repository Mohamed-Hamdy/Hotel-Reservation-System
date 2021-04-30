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
                        <li class=""><a href="searchinformation.jsp">Search Information</a></li>
                        <li class=""><a href="Adminaccount.jsp">Admin Accounts</a></li>
                        <li><a href="reservation.jsp">Reservation</a></li>
                        <li><a href="room.jsp">Room</a></li>
                        <li><a href="view_rate.jsp">Rate</a></li>
                        <li><a href="logout.jsp"><span class="label label-danger"><%=(String) session.getAttribute("uname")%></span>&nbsp;Logout</a></li>
                    </ul>
                </div>
                <br />

                <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="alert alert-info">Accounts</div>
                            <div class="col-md-3">
                                <button style="background-color:transparent; border: none;"><a class="btn btn-success" href="checkin.jsp"><i
                                    class="glyphicon glyphicon-edit"></i>Check In</a> <br /></button>
                           
                                    <button style="background-color:transparent; border: none;"><a class="btn btn-success" href="checkout.jsp"><i
                                    class="glyphicon glyphicon-edit"></i>Check Out</a> <br /></button>
                            </div>
                            <br /><br />
                            <%
                                Connection con = DatabaseConnection.getConnection();
                                ResultSet res = null;
                                Statement statement = con.createStatement();

                            %>
                            <br>
                            <table id="table" class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th class="text-center">ID</th>
                                        <th class="text-center">First Name</th>
                                        <th class="text-center">Last Name</th>
                                        <th class="text-center">email</th>
                                        <th class="text-center">address</th>
                                        <th class="text-center">City</th>
                                        <th class="text-center">Postal Code</th>
                                        <th class="text-center">Country</th>
                                        <th class="text-center">Phone</th>
                                        <th class="text-center">Password</th>


                                    </tr>
                                </thead>
                                <tbody>
                                    <%  ResultSet resultset = statement.executeQuery("select * from user");
                                        while (resultset.next()) {
                                    %>
                                    <tr>
                                        <td class="text-center"><%=resultset.getInt(1)%></td>
                                        <td class="text-center"><%=resultset.getString(2)%></td>
                                        <td class="text-center"><%=resultset.getString(3)%></td>
                                        <td class="text-center"><%=resultset.getString(4)%></td>
                                        <td class="text-center"><%=resultset.getString(5)%></td>
                                        <td class="text-center"><%=resultset.getString(6)%></td>
                                        <td class="text-center"><%=resultset.getString(7)%></td>
                                        <td class="text-center"><%=resultset.getString(8)%></td>
                                        <td class="text-center"><%=resultset.getString(9)%></td>
                                        <td class="text-center"><%=resultset.getString(10)%></td>


                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br />
    <br />
    
</body>
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/jquery.dataTables.js"></script>
<script src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript">
    function confirmationDelete(anchor) {
        var conf = confirm("Are you sure you want to delete this record?");
        if (conf) {
            window.location = anchor.attr("href");
        }
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#table").DataTable();
    });
</script>
</html>