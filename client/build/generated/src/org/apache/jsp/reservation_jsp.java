package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Date;

public final class reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Book</title>\n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            //user info 
            String log_fName;
            String log_lName;
            String log_phone;
            String log_email;
            String log_address;
            String log_city;
            String log_postalCode;
            String log_country;

            if (session.getAttribute("username") == null) {

                log_fName = "";
                log_lName = "";
                log_phone = "";
                log_email = "";
                log_address = "";
                log_city = "";
                log_postalCode = "";
                log_country = "";

            } else {
                log_fName = String.valueOf(session.getAttribute("fName"));
                log_lName = String.valueOf(session.getAttribute("lName"));
                log_phone = String.valueOf(session.getAttribute("phone"));
                log_email = String.valueOf(session.getAttribute("email"));
                log_address = String.valueOf(session.getAttribute("address"));
                log_city = String.valueOf(session.getAttribute("city"));
                log_postalCode = String.valueOf(session.getAttribute("postalCode"));
                log_country = String.valueOf(session.getAttribute("country"));
            }

            //All the details of the desired booking
            String roomNumberSelected = null;
            Date checkInForRoom = null;
            Date checkOutForRoom = null;
            int totalDays = 0;
            int numberOfGuest = 0;
            double price = 0;
            String rDetails = null;
            String rDescription = null;
            String img = null;
            String categ = null;
            double tax = 0;
            double total = 0;
            String hotelid = null;
            try {
                hotelid = String.valueOf(session.getAttribute("hNum"));
                roomNumberSelected = String.valueOf(session.getAttribute("rNum"));
                checkInForRoom = Date.valueOf(String.valueOf(session.getAttribute("cIn")));
                checkOutForRoom = Date.valueOf(String.valueOf(session.getAttribute("cOut")));
                Object obj = session.getAttribute("totalDays");
                totalDays = Integer.valueOf(String.valueOf(obj));
                numberOfGuest = Integer.parseUnsignedInt(String.valueOf(session.getAttribute("numGuest")));
                price = Double.parseDouble(String.valueOf(session.getAttribute("price")));
                rDetails = String.valueOf(session.getAttribute("rDetails"));
                rDescription = String.valueOf(session.getAttribute("rDescription"));
                img = String.valueOf(session.getAttribute("img"));
                categ = String.valueOf(session.getAttribute("categ"));
                tax = Double.parseDouble(String.valueOf(session.getAttribute("tax")));
                total = Double.parseDouble(String.valueOf(session.getAttribute("total")));
            } catch (Exception e) {
                response.sendRedirect("Index.jsp");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

            //delete cache to prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, true);
      out.write("\n");
      out.write("        <div class=\"bg-dark  p-4\"></div>\n");
      out.write("        <div class=\"tm-container my-3\">\n");
      out.write("            <div class=\"row  \">\n");
      out.write("                <div class=\"col-lg-8  card bg-light order-lg-first order-last\">\n");
      out.write("                    <form name=\"gInfo\" class=\"d-flex flex-column needs-validation\"\n");
      out.write("                          style=\"height: 100%;\" action=\"reservation\" method=\"POST\"\n");
      out.write("                          novalidate>\n");
      out.write("                        <h4 class=\"mt-4\">Guest Information</h4>\n");
      out.write("                        <hr>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputFName4\">First Name</label> <input type=\"text\"\n");
      out.write("                                                                                   class=\"form-control\" id=\"inputFName4\" name=\"fName\"\n");
      out.write("                                                                                   placeholder=\"If you have two it's cool\" value=\"");
      out.print(log_fName);
      out.write("\"\n");
      out.write("                                                                                   required>\n");
      out.write("                                <div class=\"valid-feedback\">Looks good!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">What is your name?</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputLName4\">Last Name</label> <input type=\"text\"\n");
      out.write("                                                                                  class=\"form-control\" id=\"inputLName4\" name=\"lName\"\n");
      out.write("                                                                                  placeholder=\"Surname or family name\" value=\"");
      out.print(log_lName);
      out.write("\"\n");
      out.write("                                                                                  required>\n");
      out.write("                                <div class=\"valid-feedback\">Good job!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Don't forget your Last Name.\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputEmail4\">E-mail</label> <input type=\"email\"\n");
      out.write("                                                                               class=\"form-control\" id=\"inputEmail4\" name=\"email\"\n");
      out.write("                                                                               placeholder=\"We care about your privacy \"\n");
      out.write("                                                                               value=\"");
      out.print(log_email);
      out.write("\" required>\n");
      out.write("                                <div class=\"valid-feedback\">Great!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Please provide a valid\n");
      out.write("                                    e-mail.</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputPhone4\">Phone</label> <input type=\"number\"\n");
      out.write("                                                                              class=\"form-control\" id=\"inputPhone4\" name=\"phone\"\n");
      out.write("                                                                              placeholder=\"Mobile or home\" value=\"");
      out.print(log_phone);
      out.write("\" min=\"0\" required>\n");
      out.write("                                <div class=\"valid-feedback\">Super!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Please provide a valid phone.\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"inputAddress\">Address</label> <input type=\"text\"\n");
      out.write("                                                                             class=\"form-control\" id=\"inputAddress\" name=\"address\"\n");
      out.write("                                                                             placeholder=\"1234 Main St Apt. 3B\" value=\"");
      out.print(log_address);
      out.write("\"\n");
      out.write("                                                                             required>\n");
      out.write("                            <div class=\"valid-feedback\">So good!</div>\n");
      out.write("                            <div class=\"invalid-feedback\">Please provide a valid\n");
      out.write("                                Address.</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputCity\">City</label> <input type=\"text\"\n");
      out.write("                                                                           class=\"form-control\" id=\"inputCity\" name=\"city\"\n");
      out.write("                                                                           value=\"");
      out.print(log_city);
      out.write("\" placeholder=\"The city where you live\"\n");
      out.write("                                                                           required>\n");
      out.write("                                <div class=\"valid-feedback\">Right on!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Aren't you proud of your\n");
      out.write("                                    city?</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-4\">\n");
      out.write("                                <label for=\"inputCountry\">Country</label> <input type=\"text\"\n");
      out.write("                                                                                 class=\"form-control\" id=\"inputCountry\" name=\"country\"\n");
      out.write("                                                                                 value=\"");
      out.print(log_country);
      out.write("\" placeholder=\"Country\" required>\n");
      out.write("                                <div class=\"valid-feedback\">We love your country!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Are forgetting something?</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-2\">\n");
      out.write("                                <label for=\"inputZip\">Postal Code</label> <input type=\"text\"\n");
      out.write("                                                                                 class=\"form-control\" id=\"inputZip\" name=\"postalCode\"\n");
      out.write("                                                                                 placeholder=\"Postal Code\" value=\"");
      out.print(log_postalCode);
      out.write("\" required>\n");
      out.write("                                <div class=\"valid-feedback\">yeah!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Last but not least.</div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <hr>\n");
      out.write("                            <h4 class=\"mt-2\">Payment Information</h4>\n");
      out.write("                            <hr>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row \">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputCCNumber\">Credit Card</label> <input\n");
      out.write("                                    type=\"password\" class=\"form-control\" id=\"inputCCNumber\"\n");
      out.write("                                    name=\"ccNumber\" placeholder=\"Secured Checkout\" min=\"0\" required>\n");
      out.write("                                <div class=\"valid-feedback\">Looks good!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Please provide a valid Credit\n");
      out.write("                                    card Number.</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-3\">\n");
      out.write("                                <label for=\"inputExp\">Expiration</label> <input type=\"number\"\n");
      out.write("                                                                                class=\"form-control\" id=\"inputExp\" name=\"expir\"\n");
      out.write("                                                                                min=\"0\" placeholder=\"MM/YY\" required>\n");
      out.write("                                <div class=\"valid-feedback\">Looks good!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Please provide a valid\n");
      out.write("                                    expiration date.</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group col-md-3\">\n");
      out.write("                                <label for=\"CVV\">CVV</label> <input type=\"number\"\n");
      out.write("                                                                    class=\"form-control\" id=\"CVV\" name=\"cvv\" placeholder=\"3 digits\"\n");
      out.write("                                                                    min=\"0\" required>\n");
      out.write("                                <div class=\"valid-feedback\">Looks good!</div>\n");
      out.write("                                <div class=\"invalid-feedback\">Please provide a valid CVV.</div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"batches\">\n");
      out.write("                            <img src=\"img/SVG/americanexpress.svg\" alt=\"amex\"> <img\n");
      out.write("                                src=\"img/SVG/paypal.svg\" alt=\"paypal\"> <img\n");
      out.write("                                src=\"img/SVG/visa.svg\" alt=\"visa\"> <img\n");
      out.write("                                src=\"img/SVG/ripple.svg\" alt=\"ripple\"> <img\n");
      out.write("                                src=\"img/SVG/apple.svg\" style=\"color: royalblue\" alt=\"applepay\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"my-auto w-100 \">\n");
      out.write("                            <input name=\"hotelid\" type=\"hidden\"\n");
      out.write("                                   value=\"");
      out.print(hotelid);
      out.write("\"> \n");
      out.write("                            <input name=\"roomNumberSelected\" type=\"hidden\"\n");
      out.write("                                   value=\"");
      out.print(roomNumberSelected);
      out.write("\"> \n");
      out.write("\n");
      out.write("                            <input\n");
      out.write("                                name=\"checkInForRoom\" type=\"hidden\" value=\"");
      out.print(checkInForRoom);
      out.write("\">\n");
      out.write("                            <input name=\"checkOutForRoom\" type=\"hidden\"\n");
      out.write("                                   value=\"");
      out.print(checkOutForRoom);
      out.write("\"> \n");
      out.write("\n");
      out.write("                            <input name=\"nights\"\n");
      out.write("                                   type=\"hidden\" value=\"");
      out.print(totalDays);
      out.write("\"> \n");
      out.write("                            <input name=\"ppn\"\n");
      out.write("                                   type=\"hidden\" value=\"");
      out.print(price);
      out.write("\">\n");
      out.write("                            <input name=\"tax\"\n");
      out.write("                                   type=\"hidden\" value=\"");
      out.print(tax);
      out.write("\"> \n");
      out.write("                            <input name=\"total\"\n");
      out.write("                                   type=\"hidden\" value=\"");
      out.print(total);
      out.write("\">\n");
      out.write("                            <button type=\"hidden\" class=\"btn btn-primary btn-block mb-2\">Complete\n");
      out.write("                                Reservation</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div\n");
      out.write("                    class=\"col-lg-3 ml-lg-4 card mb-4 mb-lg-0 order-lg-last order-first\">\n");
      out.write("                    <div class=\"px-1 px-md-2 px-lg-3 \" style=\"width: 100%;\">\n");
      out.write("                        <img src=\"");
      out.print(img);
      out.write("\" alt=\"Room\" class=\"card-img-top\">\n");
      out.write("                        <div class=\"card-body pl-0\">\n");
      out.write("                            <h5 class=\"card-title\">Booking Summary</h5>\n");
      out.write("                            <p class=\"card-text\">\n");
      out.write("                                Room Category\n");
      out.write("                                ");
      out.print(categ);
      out.write("</p>\n");
      out.write("                            <small class=\"text-muted\">");
      out.print(rDescription);
      out.write("</small>\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Guests</strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">");
      out.print(numberOfGuest);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Nights</strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">");
      out.print(totalDays);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Check-In</strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">");
      out.print(checkInForRoom);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Check-Out</strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">");
      out.print(checkOutForRoom);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><small class=\"text-muted\">The\n");
      out.write("                                    reservation will be confirmed in the hotel's currency. Please be\n");
      out.write("                                    advised that converted rates are estimated based on the daily\n");
      out.write("                                    exchange rate and may therefore vary. </small></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Nightly Rate </strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">$ ");
      out.print(price);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Taxes &amp;\n");
      out.write("                                    Fees</strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">$ ");
      out.print(tax);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <hr>\n");
      out.write("                        <ul class=\"list-inline \">\n");
      out.write("                            <li class=\"list-inline-item\"><strong>Total</strong></li>\n");
      out.write("                            <li class=\"list-inline-item float-right pr-4\">$ ");
      out.print(total);
      out.write("</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, true);
      out.write("\n");
      out.write("        <script src=\"JS/booking.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
