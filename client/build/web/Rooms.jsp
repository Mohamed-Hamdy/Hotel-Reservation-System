<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Rooms Hotel Patagonia</title>


        <%
            //delete cache to prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        %>

    </head>
    <body class="themeColor">

        <jsp:include page="Header.jsp" flush="true" />


        <div class="bg-dark">
            <div class="tm-container">
                
                <form name="searchRoom" method="post">
                    <div class="form-row">
                        <div class="col-sm-3 py-3">
                            <input type="text" id="checkInSide" class="form-control checkIn"
                                   placeholder="Check-in" readonly>
                        </div>
                        <div class="col-sm-3 py-3">
                            <input type="text" id="checkOutSide" class="form-control checkOut"
                                   placeholder="Check-out" readonly>
                        </div>
                        <div class="col-sm-2 py-3">
                            <input type="number" class="form-control" placeholder="Guests"
                                   name="numberOfGuestSide" id="numberOfGuestSide" min="1" max="3"
                                   value="2" required>
                        </div>

                        <div class="col-sm-2 py-3">
                            <button type="button"
                                    class="btn btn-outline-warning mr-0 float-right btn-block"
                                    onclick="RoomAvailabilityChecker()">Book</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id="main_content" class="tm-container clearfix px-0">
            <div class="container fadeIn bg-white pl-0 float-left clearfix">
                <div class="row my-4">
                    <div class="col-lg-8">
                        <img class="rounded" src="img\room\s1.jpg" alt="hotel lounge" />
                    </div>
                    <div class="col-lg-4">
                        <h2 class="brand mt-2">Rooms Patagonia</h2>
                        <h4>
                            <q>In a glorious True North setting amid supreme natural
                                wonders</q>
                        </h4>
                        <p>Inside the hotel, one now finds warm, welcoming rooms that
                            feature the finest quality traditional materials accented by
                            modern touches, bringing to mind a friend's home in the mountains.
                            Here, too, one discovers fine restaurants, fun eateries, a
                            stunning wellness and spa area, conference facilities, a lounge
                            "living room" with unparalleled views and an accompanying
                            fireplace and library of 500 books.</p>
                    </div>
                </div>
                <hr>
            </div>
            <div class="container fadeIn bg-white float-right pr-0 clearfix">
                <div class="row my-4">
                    <div class="col-lg-4">
                        <h4>
                            <q>The guestrooms at Patagonia Hotel capture the essence of a
                                friend's mountain retreat</q>
                        </h4>
                        <p>Double Rooms are either 28 square meters and face north or
                            20 square meters and face south (some south-facing Double rooms
                            have slightly restricted views). Single rooms are south-facing and
                            18 square meters. All rooms include bath and shower, flat-screen
                            televisions, and a "Suitepad" with over 100 complimentary daily
                            newspapers and magazines in German, English, and French.</p>
                        <br>
                    </div>
                    <div class="col-lg-8">
                        <img class="rounded" src="img\room\d2.jpg"
                             alt="Mountain retreat" />
                    </div>
                </div>
            </div>
            
        </div>


        <jsp:include page="Footer.jsp" flush="true" />
        <script src="JS/parallax.js"></script>
        <script src="JS/index.js">
        </script>
        <!--<script src="JS/rooms.js"></script>-->

    </body>
</html>