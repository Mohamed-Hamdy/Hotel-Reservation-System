package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Rooms_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Rooms Hotel Patagonia</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            //delete cache to prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"themeColor\">\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, true);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"bg-dark\">\n");
      out.write("            <div class=\"tm-container\">\n");
      out.write("                \n");
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
      out.write("                        <div class=\"col-sm-2 py-3\">\n");
      out.write("                            <input type=\"number\" class=\"form-control\" placeholder=\"Guests\"\n");
      out.write("                                   name=\"numberOfGuestSide\" id=\"numberOfGuestSide\" min=\"1\" max=\"3\"\n");
      out.write("                                   value=\"2\" required>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-2 py-3\">\n");
      out.write("                            <button type=\"button\"\n");
      out.write("                                    class=\"btn btn-outline-warning mr-0 float-right btn-block\"\n");
      out.write("                                    onclick=\"RoomAvailabilityChecker()\">Book</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"main_content\" class=\"tm-container clearfix px-0\">\n");
      out.write("            <div class=\"container fadeIn bg-white pl-0 float-left clearfix\">\n");
      out.write("                <div class=\"row my-4\">\n");
      out.write("                    <div class=\"col-lg-8\">\n");
      out.write("                        <img class=\"rounded\" src=\"img\\room\\s1.jpg\" alt=\"hotel lounge\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <h2 class=\"brand mt-2\">Rooms Patagonia</h2>\n");
      out.write("                        <h4>\n");
      out.write("                            <q>In a glorious True North setting amid supreme natural\n");
      out.write("                                wonders</q>\n");
      out.write("                        </h4>\n");
      out.write("                        <p>Inside the hotel, one now finds warm, welcoming rooms that\n");
      out.write("                            feature the finest quality traditional materials accented by\n");
      out.write("                            modern touches, bringing to mind a friend's home in the mountains.\n");
      out.write("                            Here, too, one discovers fine restaurants, fun eateries, a\n");
      out.write("                            stunning wellness and spa area, conference facilities, a lounge\n");
      out.write("                            \"living room\" with unparalleled views and an accompanying\n");
      out.write("                            fireplace and library of 500 books.</p>\n");
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
      out.write("                        <p>Double Rooms are either 28 square meters and face north or\n");
      out.write("                            20 square meters and face south (some south-facing Double rooms\n");
      out.write("                            have slightly restricted views). Single rooms are south-facing and\n");
      out.write("                            18 square meters. All rooms include bath and shower, flat-screen\n");
      out.write("                            televisions, and a \"Suitepad\" with over 100 complimentary daily\n");
      out.write("                            newspapers and magazines in German, English, and French.</p>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-8\">\n");
      out.write("                        <img class=\"rounded\" src=\"img\\room\\d2.jpg\"\n");
      out.write("                             alt=\"Mountain retreat\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, true);
      out.write("\n");
      out.write("        <script src=\"JS/parallax.js\"></script>\n");
      out.write("        <script src=\"JS/index.js\">\n");
      out.write("        </script>\n");
      out.write("        <!--<script src=\"JS/rooms.js\"></script>-->\n");
      out.write("\n");
      out.write("    </body>\n");
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
