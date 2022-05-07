<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
<%@ page import="beans.Proveedor"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	boolean error=false;
	Proveedor prov=new Proveedor();
	
		prov.BorrarProveedor();
		response.sendRedirect("MostrarProveedores.jsp");
	
	
%>