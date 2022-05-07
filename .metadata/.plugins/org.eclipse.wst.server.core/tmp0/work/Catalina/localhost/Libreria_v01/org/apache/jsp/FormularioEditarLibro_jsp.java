/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2022-05-07 18:00:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import beans.Libro;

public final class FormularioEditarLibro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("beans.Libro");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("	");
 int idLibro = Integer.parseInt(request.getParameter("id"));  //AQUI SE DEBERIA RECIBIR EL PARAMETRO
      out.write('\r');
      out.write('\n');
      out.write('	');
System.out.println("EL ID RECIBIDO ES:  "+idLibro);
      out.write('\r');
      out.write('\n');
      out.write('	');
Libro l = new Libro().buscarLibro(idLibro);
      out.write("\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"></meta>\r\n");
      out.write("		<title>Formulario para editar un libro</title>\r\n");
      out.write("		<link rel=\"stylesheet\" href=\"css/formularios.css\">\r\n");
      out.write("	</head>\r\n");
      out.write("	<body background=\"img/formulario.jpg\">\r\n");
      out.write("		<div class=\"formulario\">\r\n");
      out.write("			<h1>Formulario Editar Libro</h1>\r\n");
      out.write("			<form action=\"EditarLibro.do\" method=\"GET\">\r\n");
      out.write("			\r\n");
      out.write("				<p><label class=\"txt\" for=\"ID\">ID:</label><br>\r\n");
      out.write("				<input class=\"inputs\" id=\"ID\" type=\"text\" name=\"id_lib\" value=\"");
      out.print(l.getnum_lib() );
      out.write("\"/></p>	\r\n");
      out.write("					\r\n");
      out.write("				<p><label class=\"txt\" for=\"ISBN\">ISBN:</label><br>\r\n");
      out.write("				<input class=\"inputs\" id=\"ISBN\" type=\"text\" name=\"ISBNLibro\" value=\"");
      out.print(l.getisbn_lib() );
      out.write("\"/></p>	\r\n");
      out.write("						\r\n");
      out.write("				<p><label class=\"txt\" for=\"Titulo\">Titulo: </label><br>\r\n");
      out.write("				<input class=\"inputs\" id=\"Titulo\" type=\"text\" name=\"nomLibro\" value=\"");
      out.print(l.gettit_lib() );
      out.write("\"/></p>\r\n");
      out.write("				\r\n");
      out.write("				<p><label class=\"txt\" for=\"Categoria\">Categoria: </label><br>\r\n");
      out.write("				<input class=\"inputs\" id=\"Categoria\" type=\"text\" name=\"catLibro\" value=\"");
      out.print(l.getcat_lib() );
      out.write("\"/></p>\r\n");
      out.write("				\r\n");
      out.write("				<p><label class=\"txt\" for=\"Precio\">Precio: </label><br>\r\n");
      out.write("				<input class=\"inputs\" id=\"Precio\" type=\"text\" name=\"preLibro\" value=\"");
      out.print(l.getpre_lib() );
      out.write("\"/></p>\r\n");
      out.write("				\r\n");
      out.write("				<input class=\"boton\" type=\"submit\" value=\"ENVIAR\" name=\"insertar\"><br>\r\n");
      out.write("				\r\n");
      out.write("				<p class=\"navegar\"><a href=\"MostrarLibros.do\">Cancelar</a></p>		\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
