<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="DataBase.HotelDAO"%>
<%@page import="DataBase.RoomDAO"%>
<%@page import="Program.Hotel"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rooms Hotel Patagonia</title>


        <%
            //delete cache to prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        %>

    </head>
    <body class="themeColor">
        <jsp:include page="Header.jsp" flush="true" />
        <div class="bg-dark  p-4 mb-3"></div>
        <div class="tm-container">
            <div class="w-100">
                <h4>Our Hotels</h4>
            </div>  
            
            <%
                Connection connection = null;

                Connection connection_1 = null;
                ResultSet rs;
                ResultSet result;
                int number_of_rows = 0;
                int first_id = 0;

                ArrayList<Hotel> hotelArray = new ArrayList<Hotel>();
                HotelDAO rd = new HotelDAO();
                Hotel h = new Hotel();

                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    // Get a Connection to the database
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem", "root", "root");
                    //connection_1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsystem", "root", "root");

                    String sql = "SELECT hotelid FROM hotel WHERE hotelid = ( SELECT MIN(hotelid) FROM hotel );";
                    String sql_1 = "select count(*) from hotel";
                    Statement s = connection.createStatement();
                    Statement s_1 = connection.createStatement();
                    s.executeQuery(sql);
                    s_1.executeQuery(sql_1);
                    rs = s.getResultSet();
                    result = s_1.getResultSet();

                    while (rs.next()) {
                        first_id = rs.getInt("hotelid");
                    }
                    while (result.next()) {
                        number_of_rows = result.getInt(1);
                    }

//                    out.println("And now the total number of rows (record) =<b> " + number_of_rows + "</b>");
//                    out.println("First record id =<b> " + first_id + "</b>");
                    int c = 0;
                    for (int i = first_id; i < (number_of_rows + first_id); i++) {
                        h = rd.getHotel(i);
                        hotelArray.add(c, h);
                        c++;
                    }
                    c = 0;
//                    out.println("array size : " + hotelArray.size());
//                    for (int i = 0; i < hotelArray.size(); i++) {
//                        out.println("<br>");
//                        out.println(hotelArray.get(i).getHotelName());
//                        out.println(hotelArray.get(i).getHotelNumber());
//                        out.println("<br>");
//                    }

                    for (int i = 0; i < hotelArray.size(); i++) {

                        //h = hotelArray.get(i);
                        String hDetails = hotelArray.get(i).gethotel_details();
                        String[] detArray = hDetails.split("\\.");
                        out.println("<div class=\"card mb-3 mw-100 \">");
                        out.println("<div class=\"row no-gutters\">");
                        String imagesgallary = hotelArray.get(i).getgallaryImgsURL();
                        String[] gallaryArray = imagesgallary.split("\\=");

                        out.println("<div class=\"col-md-4\">");
                        out.println("<br><br>");
                        out.println("<img style=\"height:350px;\" src=\"" + hotelArray.get(i).getImgURL() + "\" class=\"card-img hotelImg\" alt=\"Room Image\"/>");
                        out.println("</div>");

                        out.println("<div class=\"col-md-8 mw-100\" >");
                        out.println("<div class=\"card-body d-flex flex-column\" style=\"min-height: 100%;\" >");
                        out.println("<h2 class=\"card-title\">" + hotelArray.get(i).getHotelName() + "</h2>");

                        out.println("<h2 class=\"card-title\">" + hotelArray.get(i).getHotelNumber() + "</h2>");

                        out.println("<b><h4 class=\"card-title text-capitalize\">Hotel Location " + hotelArray.get(i).gethotel_Location() + "</h4></b>");
                        out.println("<h5 class=\"card-title text-capitalize\">Hotel Rate " + hotelArray.get(i).getHotelRate() + " / 10</h5>");
                        out.println("<div class=\"ml-4 \" ><ul><li>" + detArray[0] + "</li>");
                        out.println("<li>" + detArray[1] + "</li></ul></div>");
                        out.println("<div>" + detArray[2] + "</div><br>");
                        out.println("<div>" + detArray[3] + "</div>");
                        out.println("<br><h5>Price per Night $ " + hotelArray.get(i).getexpected_price() + "</h5>");
                        int hotel_id = 0;
                        hotel_id = hotelArray.get(i).getHotelNumber();
                        String map = hotelArray.get(i).gethotellocationurl();
                        //out.println(gallaryArray.length);
                        out.println("<form name=\"select\" class=\"mt-auto\" action=\"room-details.jsp\" method=\"Post\">");
                        out.println("<input name=\"hotelimage\" type=\"hidden\" value=\"" + hotelArray.get(i).getImgURL() + "\"/>");
                        out.println("<input name=\"gallary_1\" type=\"hidden\" value=\"" + gallaryArray[0] + "\"/>");
                        out.println("<input name=\"gallary_2\" type=\"hidden\" value=\"" + gallaryArray[1] + "\"/>");
                        out.println("<input name=\"gallary_3\" type=\"hidden\" value=\"" + gallaryArray[2] + "\"/>");
                        out.println("<input name=\"gallary_4\" type=\"hidden\" value=\"" + gallaryArray[3] + "\"/>");
                        out.println("<input name=\"hid\" type=\"hidden\" value=\"" + hotel_id + "\"/>");
                        out.println("<input name=\"hotelname\" type=\"hidden\" value=\"" + hotelArray.get(i).getHotelName() + "\"/>");
                        out.println("<input name=\"hotelmap\" type=\"hidden\" value=\"" + map + "\"/>");
                        out.println("<button type=\"submit\" class=\"btn btn-outline-warning btn-md btn-block \">More Details</button>");
                        out.println("</form>");

                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.print("</div>");
                    }

                } catch (NullPointerException e) {
                    h = null;
                    hotelArray.add(h);
                    System.out.println(e);
                }

            %>
        </div>

        <jsp:include page="Footer.jsp" flush="true" />
        <script src="JS/rooms.js"></script>
        

    </body>
</html>