<%@page import="Program.Hotel"%>
<%@page import="DataBase.HotelDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Program.Room"%>
<%@page import="DataBase.RoomDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Find Reservation</title>
        <%
            String log_UN = "";
            if (session.getAttribute("username") != null) {

                log_UN = String.valueOf(session.getAttribute("username"));
            }

            //delete cache to prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        %>
    </head>
    <body class="themeColor">
        <jsp:include page="Header.jsp" flush="true" />
        <div class="bg-dark  p-4"></div>
        <div id="main_content" class="tm-container clearfix px-0 ">


            <h4 class="mt-4">Let's Find your reservation!</h4>
            <hr>
            <div class="form-row d-flex">


                <table class="table table-dark">
                    <thead class="thead-dark">
                        <tr style="text-align: center;">
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Room Number</th>
                            <th scope="col">Check In</th>
                            <th scope="col">Check Out</th>
                            <th scope="col">Nights</th>
                            <th scope="col">Total Cost</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Hotel Name</th>
                            <th scope="col">Change</th>
                            <th scope="col">Cancel</th>

                        </tr>
                    </thead>
                    <tbody>

                        <%
                            Class.forName("com.mysql.jdbc.Driver");
                            // Get a Connection to the database
                            Connection connection = null;
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem", "root", "root");
                            //Add Login user data to the database (Customer Table)
                            HttpSession s = request.getSession(false);
                            String username = (String) s.getAttribute("username");
                            ResultSet rs;
                            String sql = "select * from reservation where user_email = '" + username + "';";
                            Statement stmt = connection.createStatement();
                            stmt.executeQuery(sql);
                            rs = stmt.getResultSet();

                            int rId = 0;
                            int room_number = 0;
                            int hotel_id = 0;
                            int phone_number = 0;
                            int nights = 0;
                            String fname = "";
                            String lname = "";
                            String email = "";
                            Date checkin = null;
                            Date checkout = null;
                            double Total_cost = 0.0;
                            int counter = 0;
                            while (rs.next()) {
                                rId = rs.getInt("idreservation");

                                fname = rs.getString("user_first_name");
                                lname = rs.getString("user_last_name");
                                email = rs.getString("user_email");
                                checkin = rs.getDate("res_checkIn");
                                checkout = rs.getDate("res_checkout");

                                nights = rs.getInt("res_nights");

                                Total_cost = rs.getDouble("res_total");
                                phone_number = rs.getInt("user_phone");
                                hotel_id = rs.getInt("hotel_hotelid");
                                room_number = rs.getInt("room_room_id");
                                counter++;
                                HotelDAO h = new HotelDAO();
                                ArrayList<Hotel> hotel = new ArrayList<Hotel>();
                                hotel.add(h.getHotel(hotel_id));
                                String hotel_name = hotel.get(0).getHotelName();
                                String name = fname + " " + lname;

                        %>
                        <tr style="text-align: center;">
                            <td><%= rId%></td>
                            <td><%= name%></td>
                            <td><%= email%></td>
                            <td><%= room_number%></td>
                            <td><%= checkin%></td>
                            <td><%= checkout%></td>
                            <td><%= nights%></td>
                            <td><%= Total_cost%></td>
                            <td><%= phone_number%></td> 
                            <td><%= hotel_name%></td>
                            <td>

                                <form action="Edit_reservation.jsp" method="POST">
                                    <input name = "rid" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= rId%>" />
                                    <input name = "rname" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= name%>" />
                                    <input name = "remail" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= email%>" />
                                    <input name = "rrnum" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= room_number%>" />
                                    <input name = "rcheckin" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= checkin%>" />
                                    <input name = "rcheckout" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= checkout%>" />
                                    <input name = "rnights" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= nights%>" />
                                    <input name = "rcost" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= Total_cost%>" />
                                    <input name = "rphone" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= phone_number%>" />
                                    <input class="btn btn-outline-warning mr-0 btn-block" type="submit" value="Change" />
                                </form>

                            </td>

                            <td>
                                <form action="Deletereservation" method="POST">
                                    <input name = "rid" class="btn btn-outline-warning mr-0 btn-block" type="hidden" value="<%= rId%>" />
                                    <input class="btn btn-outline-warning mr-0 btn-block" type="submit" value="Cancel" />
                                </form>
                            </td>
                        </tr>

                        <%}%>
                    </tbody>
                </table>

            </div>
            <div id="target"></div>
        </div>

        <jsp:include page="Footer.jsp" flush="true" />
        <script src="JS/find.js"></script>


    </body>
</html>