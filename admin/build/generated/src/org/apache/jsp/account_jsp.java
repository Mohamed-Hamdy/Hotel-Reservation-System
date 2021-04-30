package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.connection.DatabaseConnection;

public final class account_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Hotel Management System Dashboard</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script\n");
      out.write("        src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n");
      out.write("        <script\n");
      out.write("        src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script\n");
      out.write("        src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script\n");
      out.write("        src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n");
      out.write("        <script\n");
      out.write("        src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <nav style=\"background-color:rgba(0, 0, 0, 0.1);\"\n");
      out.write("         class=\"navbar navbar-default\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <a class=\"navbar-brand\">Hotel Online Reservation</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <ul class=\"nav nav-pills\">\n");
      out.write("                        <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"account.jsp\">Accounts</a></li>\n");
      out.write("                        <li class=\"\"><a href=\"searchinformation.jsp\">Search Information</a></li>\n");
      out.write("                        <li class=\"\"><a href=\"Adminaccount.jsp\">Admin Accounts</a></li>\n");
      out.write("                        <li><a href=\"reservation.jsp\">Reservation</a></li>\n");
      out.write("                        <li><a href=\"room.jsp\">Room</a></li>\n");
      out.write("                        <li><a href=\"view_rate.jsp\">Rate</a></li>\n");
      out.write("                        <li><a href=\"logout.jsp\"><span class=\"label label-danger\">");
      out.print((String) session.getAttribute("uname"));
      out.write("</span>&nbsp;Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <br />\n");
      out.write("\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"alert alert-info\">Accounts</div>\n");
      out.write("                            <div class=\"col-md-3\">\n");
      out.write("                                <button style=\"background-color:transparent; border: none;\"><a class=\"btn btn-success\" href=\"checkin.jsp\"><i\n");
      out.write("                                    class=\"glyphicon glyphicon-edit\"></i>Check In</a> <br /></button>\n");
      out.write("                           \n");
      out.write("                                    <button style=\"background-color:transparent; border: none;\"><a class=\"btn btn-success\" href=\"checkout.jsp\"><i\n");
      out.write("                                    class=\"glyphicon glyphicon-edit\"></i>Check Out</a> <br /></button>\n");
      out.write("                            </div>\n");
      out.write("                            <br /><br />\n");
      out.write("                            ");

                                Connection con = DatabaseConnection.getConnection();
                                ResultSet res = null;
                                Statement statement = con.createStatement();

                            
      out.write("\n");
      out.write("                            <br>\n");
      out.write("                            <table id=\"table\" class=\"table table-bordered\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th class=\"text-center\">ID</th>\n");
      out.write("                                        <th class=\"text-center\">First Name</th>\n");
      out.write("                                        <th class=\"text-center\">Last Name</th>\n");
      out.write("                                        <th class=\"text-center\">email</th>\n");
      out.write("                                        <th class=\"text-center\">address</th>\n");
      out.write("                                        <th class=\"text-center\">City</th>\n");
      out.write("                                        <th class=\"text-center\">Postal Code</th>\n");
      out.write("                                        <th class=\"text-center\">Country</th>\n");
      out.write("                                        <th class=\"text-center\">Phone</th>\n");
      out.write("                                        <th class=\"text-center\">Password</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");
  ResultSet resultset = statement.executeQuery("select * from user");
                                        while (resultset.next()) {
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getInt(1));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(2));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(3));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(4));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(5));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(6));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(7));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(8));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(9));
      out.write("</td>\n");
      out.write("                                        <td class=\"text-center\">");
      out.print(resultset.getString(10));
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <br />\n");
      out.write("    <br />\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("<script src=\"../js/jquery.js\"></script>\n");
      out.write("<script src=\"../js/bootstrap.js\"></script>\n");
      out.write("<script src=\"../js/jquery.dataTables.js\"></script>\n");
      out.write("<script src=\"../js/dataTables.bootstrap.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function confirmationDelete(anchor) {\n");
      out.write("        var conf = confirm(\"Are you sure you want to delete this record?\");\n");
      out.write("        if (conf) {\n");
      out.write("            window.location = anchor.attr(\"href\");\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $(\"#table\").DataTable();\n");
      out.write("    });\n");
      out.write("</script>\n");
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
