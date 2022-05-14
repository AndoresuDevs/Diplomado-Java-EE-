<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Proveedor"%>
<%@ page import="dao.ProveedorDAO"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String Nombre = request.getParameter("Nombre");
	String Telefono = request.getParameter("Telefono");
	String Direccion = request.getParameter("Direccion");
	
	
	
	
	ProveedorDAO dao = new ProveedorDAO();
	dao.insertar(new Proveedor(Nombre,Telefono,Direccion));
	
	response.sendRedirect("MostrarProveedores.jsp");
	
		
	
	
	
	
	%>
	
%>