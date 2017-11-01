package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "encabezado.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("<!-- start: content -->\n");
      out.write("<div id=\"content\">\n");
      out.write("    <div class=\"panel box-shadow-none content-header\">\n");
      out.write("        <div class=\"panel-body\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <h3 class=\"animated fadeInLeft\">Registrar Empleado</h3>\n");
      out.write("                <p class=\"animated fadeInDown\">\n");
      out.write("                    Form <span class=\"fa-angle-right fa\"></span> Form Element\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"col-md-10\">\n");
      out.write("        <div class=\"col-md-12 panel\">\n");
      out.write("            <div class=\"col-md-12 panel-heading\">\n");
      out.write("                <h4>Ingrese los datos</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-12 panel-body\" style=\"padding-bottom:30px;\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <form class=\"cmxform\" id=\"signupForm\" method=\"post\" action=\"EmpleadoControllers?action=create\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"form-group form-animate-text\" style=\"margin-top:40px !important;\">\n");
      out.write("                                <input type=\"text\" class=\"form-text\" id=\"nombre\" name=\"nombre\" required>\n");
      out.write("                                <span class=\"bar\"></span>\n");
      out.write("                                <label>Nombre</label>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group form-animate-text\" style=\"margin-top:40px !important;\">\n");
      out.write("                                <input type=\"text\" class=\"form-text\" id=\"apellido\" name=\"apellido\" required>\n");
      out.write("                                <span class=\"bar\"></span>\n");
      out.write("                                <label>Apellido</label>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group form-animate-text\" style=\"margin-top:40px !important;\">\n");
      out.write("                                <input type=\"number\" class=\"form-text\" id=\"documento\" name=\"documento\" required>\n");
      out.write("                                <span class=\"bar\"></span>\n");
      out.write("                                <label>Documento</label>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"form-group form-animate-text\" style=\"margin-top:40px !important;\">\n");
      out.write("                                <input type=\"text\" class=\"form-text\" id=\"email\" name=\"email\" required>\n");
      out.write("                                <span class=\"bar\"></span>\n");
      out.write("                                <label>Email</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group form-animate-text\" style=\"margin-top:40px !important;\">\n");
      out.write("                                <input type=\"password\" class=\"form-text\" id=\"password\" name=\"password\" required>\n");
      out.write("                                <span class=\"bar\"></span>\n");
      out.write("                                <label>Password</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group form-animate-text\" style=\"margin-top:40px !important;\">\n");
      out.write("                                <input type=\"password\" class=\"form-text\" id=\"validate_confirm_password\" name=\"validate_confirm_password\" required>\n");
      out.write("                                <span class=\"bar\"></span>\n");
      out.write("                                <label>Confirm Password</label>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-6\">                 \n");
      out.write("\n");
      out.write("                                <div class=\"col-sm-18 padding-0\">\n");
      out.write("                                    <span class=\"bar\"></span>\n");
      out.write("                                    <label>Perfil  </label>\n");
      out.write("                                    <select class=\"form-control\" name=\"perfil\">\n");
      out.write("                                        <option value=\"Gerente\">Gerente</option>\n");
      out.write("                                        <option value=\"DirVentas\">Director de Ventas</option>\n");
      out.write("                                        <option value=\"Vendedor\">Vendedor</option>                                        \n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>  \n");
      out.write("\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <input class=\"submit btn btn-success\" type=\"submit\" value=\"Registrar\">                            \n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- end: content -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<button id=\"mimin-mobile-menu-opener\" class=\"animated rubberBand btn btn-circle btn-danger\">\n");
      out.write("    <span class=\"fa fa-bars\"></span>\n");
      out.write("</button>\n");
      out.write("<!-- end: Mobile -->\n");
      out.write("\n");
      out.write("<!-- start: Javascript -->\n");
      out.write("<script src=\"asset/js/jquery.min.js\"></script>\n");
      out.write("<script src=\"asset/js/jquery.ui.min.js\"></script>\n");
      out.write("<script src=\"asset/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- plugins -->\n");
      out.write("<script src=\"asset/js/plugins/moment.min.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/jquery.knob.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/ion.rangeSlider.min.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/bootstrap-material-datetimepicker.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/jquery.nicescroll.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/jquery.mask.min.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/select2.full.min.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/nouislider.min.js\"></script>\n");
      out.write("<script src=\"asset/js/plugins/jquery.validate.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- custom -->\n");
      out.write("<script src=\"asset/js/main.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("\n");
      out.write("        $(\"#signupForm\").validate({\n");
      out.write("            errorElement: \"em\",\n");
      out.write("            errorPlacement: function (error, element) {\n");
      out.write("                $(element.parent(\"div\").addClass(\"form-animate-error\"));\n");
      out.write("                error.appendTo(element.parent(\"div\"));\n");
      out.write("            },\n");
      out.write("            success: function (label) {\n");
      out.write("                $(label.parent(\"div\").removeClass(\"form-animate-error\"));\n");
      out.write("            },\n");
      out.write("            rules: {\n");
      out.write("                nombre: \"required\",\n");
      out.write("                apellido: \"required\",\n");
      out.write("                documento: {\n");
      out.write("                    required: true,\n");
      out.write("                    min: 1,\n");
      out.write("                    minlength: 7\n");
      out.write("                },\n");
      out.write("                validate_username: {\n");
      out.write("                    required: true,\n");
      out.write("                    minlength: 2\n");
      out.write("                },\n");
      out.write("                password: {\n");
      out.write("                    required: true,\n");
      out.write("                    minlength: 5\n");
      out.write("                },\n");
      out.write("                validate_confirm_password: {\n");
      out.write("                    required: true,\n");
      out.write("                    minlength: 5,\n");
      out.write("                    equalTo: \"#password\"\n");
      out.write("                },\n");
      out.write("                email: {\n");
      out.write("                    required: true,\n");
      out.write("                    email: true\n");
      out.write("                },\n");
      out.write("                validate_agree: \"required\"\n");
      out.write("            },\n");
      out.write("            messages: {\n");
      out.write("                nombre: \"Por favor ingrese el nombre\",\n");
      out.write("                apellido: \"Por favor ingrese el apellido\",\n");
      out.write("                password: {\n");
      out.write("                    required: \"Por favor ingrese la contraseña\",\n");
      out.write("                    minlength: \"Minimo 5 caracteres\"\n");
      out.write("                },\n");
      out.write("                validate_confirm_password: {\n");
      out.write("                    required: \"Por favor verifique la contraseña\",\n");
      out.write("                    minlength: \"Minimo 5 caracteres\",\n");
      out.write("                    equalTo: \"Las contraseñas no coinciden\"\n");
      out.write("                },\n");
      out.write("                documento: {\n");
      out.write("                    required: \"Por favor ingrese documento\",\n");
      out.write("                    min: \"Documento no valido\",\n");
      out.write("                    minlength: \"Documento no valido\",\n");
      out.write("                    equalTo: \"Please enter the same password as above\"\n");
      out.write("                },\n");
      out.write("                email: \"Por favor ingrese email\",\n");
      out.write("                validate_agree: \"Please accept our policy\"\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("<!-- end: Javascript -->\n");
      out.write("</body>\n");
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
