<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Libro"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String StrISBN = request.getParameter("ISBN");
	String StrTitulo = request.getParameter("Titulo");
	String Cat = request.getParameter("Categoria");
	String Pre = request.getParameter("Precio");
	
	new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).insertar();
	
	%>
	
%>
