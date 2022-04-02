<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="javaEEJDBC.Libro"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String libID= request.getParameter("id");
	int id = Integer.parseInt(libID);
	boolean error=false;
	Libro lib=new Libro();
	lib.BorrarLibro();
	response.sendRedirect("MostrarLibros.jsp");
	
%>