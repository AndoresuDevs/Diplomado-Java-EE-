<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Proveedor"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String Nombre = request.getParameter("Nombre");
	String Telefono = request.getParameter("Telefono");
	String Direccion = request.getParameter("Direccion");
	
	
	new Proveedor(Nombre,Telefono,Direccion).insertar();
	response.sendRedirect("MostrarProveedores.jsp");
	
		
	
	
	
	
	%>
	
%>