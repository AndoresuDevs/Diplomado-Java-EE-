/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-01 20:27:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import javaEEJDBC.Libro;
import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;

public final class MostrarLibros_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("javaEEJDBC.DataBaseException");
    _jspx_imports_classes.add("javaEEJDBC.Libro");
    _jspx_imports_classes.add("javaEEJDBC.Categoria");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("	<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"></meta>\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"css/tablas.css\">\r\n");
      out.write("	<script type=\"text/javascript\" src=\"js/validacionMostrarLibro.js\"></script>\r\n");
      out.write("	<title>Lista de Libros</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"img/formulario.jpg\">\r\n");
      out.write("\r\n");
      out.write("	<div class=contenedor>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"FormularioInsertarLibro.jsp\">Insertar Nuevo Libro</a>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"MostrarLibros.jsp\" method=\"GET\">\r\n");
      out.write("	\r\n");
      out.write("	<p class=\"navegar\">\r\n");
      out.write("		<br><label>Categorias disonibles: </label>\r\n");
      out.write("		<select name=\"categoria\">\r\n");
      out.write("		<option>Seleccionar</option>\r\n");
      out.write("		");

		try{
			//ArrayList<Integer>Categorias = new ArrayList<Integer>();
			//Categorias = new Libro().buscarLasCategorias();
			 
			List<Categoria>Categorias = new ArrayList<Categoria>();
			Categorias = new Categoria().buscarCategorias();
			for(Categoria c: Categorias){
				
      out.write("\r\n");
      out.write("				<option value=\"");
      out.print(c.getid_cat());
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(c.getnom_cat());
      out.write(" </option> \r\n");
      out.write("				");

			}	
		}catch(Exception e){
			e.printStackTrace();
		}	 
		
      out.write("\r\n");
      out.write("		</select>\r\n");
      out.write("		<input type=\"submit\" value=\"Filtrar\" /> \r\n");
      out.write("	</p>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<br><br>\r\n");
      out.write("		\r\n");
      out.write("	<h2>Lista de libros</h2>\r\n");
      out.write("	\r\n");
      out.write("		<table class=\"tabla\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>Numero</th>\r\n");
      out.write("					<th>ISBN</th>\r\n");
      out.write("					<th>Titulo</th>\r\n");
      out.write("					<th>Categoria</th>\r\n");
      out.write("					<th>Precio</th>\r\n");
      out.write("					<th>Borrar</th>\r\n");
      out.write("					<th>Modificar</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<tr>\r\n");
      out.write("					");

					List<Categoria>Categorias = new ArrayList<Categoria>();
					Categorias = new Categoria().buscarCategorias();
					List<Libro> Lista=null;
					if(request.getParameter("categoria")==null || request.getParameter("categoria").equals("Seleccionar")){
						
						try{
							 Lista = new Libro().buscarTodos();
						}catch(DataBaseException e)
						{
							System.out.println("Entro la excepcion :D");
							out.println(e.getMessage());  
						}
					}else{
						int  Cat = Integer.parseInt(request.getParameter("categoria"));
						Lista=new Libro().buscarPorCategoria(Cat);
					}
					
					try{
						
					
					for(Libro l: Lista){ 
      out.write("\r\n");
      out.write("					<td>");
      out.print(l.getnum_lib());
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print(l.getisbn_lib());
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print(l.gettit_lib());
      out.write("</td>\r\n");
      out.write("					\r\n");
      out.write("				 	 \r\n");
      out.write("				 	");
for(Categoria c: Categorias){
				 		if(c.getid_cat()==l.getcat_lib()){
      out.write("\r\n");
      out.write("				 			<td>");
      out.print(c.getnom_cat());
      out.write("</td> \r\n");
      out.write("				 	");
	}
				 	} 
      out.write("\r\n");
      out.write("					\r\n");
      out.write("						\r\n");
      out.write("					<td>");
      out.print(l.getpre_lib());
      out.write("</td>\r\n");
      out.write("					<td><a href=\"BorrarLibro.jsp?id=");
      out.print(l.getnum_lib());
      out.write("\">Borar</a></td>\r\n");
      out.write("					<td><a href=\"FormularioEditarLibro.jsp?id=");
      out.print(l.getnum_lib());
      out.write("\">Editar</a></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");
}
					}catch(NullPointerException e){
      out.write("\r\n");
      out.write("						");
//response.sendRedirect("Errores.jsp?motivo="+e.getMessage());
      out.write("\r\n");
      out.write("						");
out.println("ERROR, LA LISTA DE LIBROS ESTA VACIA"); 
      out.write("\r\n");
      out.write("					");
 }
      out.write("\r\n");
      out.write("				\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("	\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("	<br><br>\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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