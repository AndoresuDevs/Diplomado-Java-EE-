<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="dao.ProveedorDAO"%>
<%@ page import="beans.Proveedor"%>
<%
	int ID = Integer.parseInt(request.getParameter("ID"));
	String Nombre = request.getParameter("Nombre");
	String Telefono = request.getParameter("Telefono");
	String Direccion = request.getParameter("Direccion");
	//int filas = new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).editarLibro(Integer.parseInt(ID));
	Proveedor p = new Proveedor(Nombre, Telefono, Direccion);
	//p.editarProveedor(ID);
	ProveedorDAO dao = new ProveedorDAO();
	dao.guardarCambios(p);
	
	
	//System.out.println("FILAS MODIFICADAS: "+filas);	
	response.sendRedirect("MostrarProveedores.do");
%>