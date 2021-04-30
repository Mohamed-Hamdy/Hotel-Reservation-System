package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <title>Index</title>\n");
      out.write("\n");
      out.write("        ");

            //delete cache to prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!--\t<div class=\"parallax-window\" data-parallax=\"scroll\" data-speed=\"0.2\"\n");
      out.write("                        data-natural-width=\"1200\" data-image-src=\"img/forest.jpg\"\n");
      out.write("                        iosFix=\"true\" androidFix=\"true\" zIndex=\"-10\">\n");
      out.write("                        <section class=\"sectionParallax\">\n");
      out.write("                                <ul class=\"heroText\">\n");
      out.write("                                        <li class=\"scroll \" data-rateY=\"1\" data-rateX=\"-1\"\n");
      out.write("                                                data-direction=\"horizontal\">hotel</li>\n");
      out.write("                                        <li class=\"scroll \" data-rate=\"1\" data-direction=\"vertical\">Patagonia</li>\n");
      out.write("                                        <li class=\"scroll \" data-rateY=\"1\" data-rateX=\"1\"\n");
      out.write("                                                data-direction=\"horizontal\">boutique</li>\n");
      out.write("        \n");
      out.write("                                </ul>\n");
      out.write("                        </section>\n");
      out.write("                </div>-->\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, true);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"bg-dark \">\n");
      out.write("            <div class=\"tm-container\">\n");
      out.write("                <form name=\"searchRoom\" method=\"post\">\n");
      out.write("                    <div class=\"form-row\">\n");
      out.write("                        <div class=\"col-sm-3 py-3\">\n");
      out.write("                            <input type=\"text\" id=\"checkInSide\" class=\"form-control checkIn\"\n");
      out.write("                                   placeholder=\"Check-in\" readonly>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-3 py-3\">\n");
      out.write("                            <input type=\"text\" id=\"checkOutSide\" class=\"form-control checkOut\"\n");
      out.write("                                   placeholder=\"Check-out\" readonly>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-1 py-3\">\n");
      out.write("                            <select name=\"numberOfGuestSide\" id=\"numberOfGuestSide\" type=\"number\" class=\"form-control\">\n");
      out.write("                                <option value =\"\" disabled selected>Adults</option>\n");
      out.write("                                <option value=\"1\">1</option>\n");
      out.write("                                <option value=\"2\">2</option>\n");
      out.write("                                <option value=\"3\">3</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-sm-1 py-3\">\n");
      out.write("                            <select name=\"numberOfCh\" id=\"numberOfCh\" type=\"number\" class=\"form-control\">\n");
      out.write("                                <option value =\"\" disabled selected>Children</option>\n");
      out.write("                                <option value=\"1\">1</option>\n");
      out.write("                                <option value=\"2\">2</option>\n");
      out.write("                                <option value=\"3\">3</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-1 py-3\">\n");
      out.write("                            <select name=\"filter\" id=\"filter\" type=\"text\" class=\"form-control\">\n");
      out.write("                                <option value=\"hotelid\">Random</option>\n");
      out.write("                                <option value=\"expected_price\">Price</option>\n");
      out.write("                                <option value=\"expected_price\">Stars</option>\n");
      out.write("                                <option value=\"hotel_rating\">Rate</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-2 py-3\">\n");
      out.write("\n");
      out.write("                            <select name=\"Location\"  class=\"form-control\" id=\"Location\">\n");
      out.write("                                <option value=\"cairo\">cairo</option>\n");
      out.write("                                <option value=\"alexandra\">alexandra</option>\n");
      out.write("                                <option value=\"paris\">paris</option>\n");
      out.write("                                <option value=\"london\">london</option>\n");
      out.write("                            </select>\n");
      out.write("                            <!--                            <input type=\"text\" class=\"form-control\" placeholder=\"Location\"\n");
      out.write("                                                               name=\"Location\" id=\"Location\" \n");
      out.write("                                                               value=\"cairo\"onkeyup=\"this.value = this.value.toLowerCase();\" required>-->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-2 py-3 \">\n");
      out.write("                            <button type=\"button\"\n");
      out.write("                                    class=\"btn btn-outline-warning mr-0 float-right btn-block\"\n");
      out.write("                                    onclick=\"AvailabilityChecker()\">Search</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"main_content\" class=\"tm-container clearfix px-0\">\n");
      out.write("            <div class=\"container fadeIn bg-white pl-0 float-left clearfix\">\n");
      out.write("                <div class=\"row my-4 \">\n");
      out.write("                    <div class=\"col-lg-8 \">\n");
      out.write("                        <img class=\"rounded \" src=\"img/hotel_view2.jpg\" alt=\"hotel lounge\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <h2 class=\"brand mt-2\">Hotel Rooms Reservation</h2>\n");
      out.write("                        <h4>\n");
      out.write("                            <q>In a glorious True North setting amid supreme natural\n");
      out.write("                                wonders</q>\n");
      out.write("                        </h4>\n");
      out.write("                        <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container fadeIn bg-white float-right pr-0 clearfix\">\n");
      out.write("                <div class=\"row my-4\">\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <h4>\n");
      out.write("                            <q>The guestrooms at Patagonia Hotel capture the essence of a\n");
      out.write("                                friend's mountain retreat</q>\n");
      out.write("                        </h4>\n");
      out.write("                        <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-8 \">\n");
      out.write("                        <img class=\"rounded \" src=\"img/mountain_retreat.jpg\"\n");
      out.write("                             alt=\"Mountain retreat\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"jumbotron marginx-10  \">\n");
      out.write("            <h1 class=\"display-4\">Join the family!</h1>\n");
      out.write("            <p class=\"lead\">In just under one minute join the family, get\n");
      out.write("                weekly rewards and invitations for special events.</p>\n");
      out.write("            <hr class=\"my-4\">\n");
      out.write("            <p>\n");
      out.write("                <em>Did you know that our Hotel donates 10% of annual revenue to\n");
      out.write("                    fire fighters and forest conservationists?</em>\n");
      out.write("            </p>\n");
      out.write("            <a class=\"btn btn-primary btn-lg\" href=\"Join.jsp\" role=\"button\">Learn\n");
      out.write("                more</a>\n");
      out.write("        </div>\n");
      out.write("        <!--                <div class=\"tm-container \">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                        <div class=\"col-lg-8  fadeIn\" id=\"target_bottom\">\n");
      out.write("                                                <div class=\"imgFood mx-0 card\" style=\"max-width: 100%;\">\n");
      out.write("                                                        <div class=\"row \">\n");
      out.write("                \n");
      out.write("                                                                <div class=\"col-lg-4 \">\n");
      out.write("                                                                        <div class=\"card-header opacity-70 text-light \">\n");
      out.write("                                                                                <h5 class=\"card-title\">Savour Winnipeg's Freshest Flavours</h5>\n");
      out.write("                                                                                <p class=\"card-text\">The Patagonia Hotel, serves\n");
      out.write("                                                                                        sophisticated European cuisine with an International twist.\n");
      out.write("                                                                                        Menus change regularly to showcase the seasons' freshest\n");
      out.write("                                                                                        flavors, including sweet corn, late summer berries, apples and\n");
      out.write("                                                                                        plums.</p>\n");
      out.write("                \n");
      out.write("                                                                                <small>*If you have any special request, please let us\n");
      out.write("                                                                                        know in advance and we will take care of you</small>\n");
      out.write("                \n");
      out.write("                                                                                <h5 class=\"mt-2\">Hours:</h5>\n");
      out.write("                                                                                <p>Monday - Friday: 6am - 7am</p>\n");
      out.write("                                                                                <p>Pastry and Coffee only 7am - 10am Full hot breakfast</p>\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"col-lg-8 \">\n");
      out.write("                                                                         <img src=\"img/food1.jpg\" class=\"card-img \" alt=\"food fest\"> \n");
      out.write("                                                                </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                </div>\n");
      out.write("                                        </div>\n");
      out.write("                \n");
      out.write("                                        <div class=\"col-lg-4 card mt-2 mt-lg-0\">\n");
      out.write("                                                <form name=\"searchRoomB\" method=\"post\" class=\"d-flex flex-column\"\n");
      out.write("                                                        style=\"height: 100%;\">\n");
      out.write("                \n");
      out.write("                                                        <div class=\"py-2 ml-4\">\n");
      out.write("                                                                <h4>Check Availability and Reserve</h4>\n");
      out.write("                                                                <small>Find the best accommodation for your upcoming stay.<a\n");
      out.write("                                                                        href=\"#\"> Why book with us?</a></small>\n");
      out.write("                                                        </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                                                        <div class=\"form-group my-2 my-md-auto card opacity-70\">\n");
      out.write("                                                                <label for=\"formGroupExampleInput\" class=\"ml-4 text-white\">Check-in\n");
      out.write("                                                                        Date</label> <input type=\"text\" id=\"cIBottom\"\n");
      out.write("                                                                        class=\"form-control checkIn pl-4 \" placeholder=\"Select a date\"\n");
      out.write("                                                                        readonly>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group my-2 my-md-auto card opacity-70\">\n");
      out.write("                                                                <label for=\"formGroupExampleInput2\" class=\"ml-4 text-white\">Check-out\n");
      out.write("                                                                        Date</label> <input type=\"text\" id=\"cOBottom\"\n");
      out.write("                                                                        class=\"form-control checkOut pl-4\" placeholder=\"Select a date\"\n");
      out.write("                                                                        readonly>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"form-group my-2 my-md-auto card opacity-70\">\n");
      out.write("                                                                <label for=\"formGroupExampleInput2\" class=\"ml-4 text-white\">Number\n");
      out.write("                                                                        of Guests</label> <input type=\"text\" id=\"gBottom\"\n");
      out.write("                                                                        class=\"form-control pl-4\" value=\"2\"\n");
      out.write("                                                                        placeholder=\"How many adults?\">\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\" my-2 my-md-auto\">\n");
      out.write("                                                                <button type=\"button\"\n");
      out.write("                                                                        class=\"btn btn-outline-warning btn-md btn-block mt-2\"\n");
      out.write("                                                                        onclick=\"AvailabilityCheckerBottom()\">Search</button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                </form>\n");
      out.write("                                        </div>\n");
      out.write("                                </div>\n");
      out.write("                        </div>-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, true);
      out.write("\n");
      out.write("        <script src=\"JS/parallax.js\"></script>\n");
      out.write("        <script src=\"JS/index.js\">\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
