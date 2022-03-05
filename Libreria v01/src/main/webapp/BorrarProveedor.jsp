<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
<%@ page import="javaEEJDBC.Proveedor"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	boolean error=false;
	Proveedor prov=new Proveedor();
	try{
		prov.BorrarProveedor(id);
		response.sendRedirect("MostrarProveedores.jsp");
	}catch(DataBaseException e){
		%>
			<%response.sendRedirect("Errores.jsp?motivo="+e.getMessage());%>
			<%System.out.println("EXCEPCION: "+e.getMessage());  %>
			<%error=true; %>
			<%out.println("Ha ocurrido un error ): "+e.getMessage());  %>
		<%
	}
	if(!error){
		//response.sendRedirect("MostrarLibros.jsp");
		//en teoria esto valida que si hay error se quede mostrandolo y si sirve siga el flujo pero lo puse arriba xD
		//Asi que puedo borrar todo este if y el bolean error
	}
	
%>