<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="beans.Libro"%>
<%@page import="dao.LibroDAO"%>
<%
	System.out.println("ENTRO EL EDITAR LIBRO JSP");
	int ID = Integer.parseInt(request.getParameter("ID"));
	
	String StrISBN = request.getParameter("ISBN");
	String StrTitulo = request.getParameter("Titulo");
	int Cat = Integer.parseInt(request.getParameter("Categoria"));
	float Pre = Float.parseFloat(request.getParameter("Precio"));
	//int filas = new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).editarLibro(Integer.parseInt(ID));
	Libro L = new Libro(StrISBN, StrTitulo, Cat, Pre);
	System.out.println("2 - ID EN EDITAR LIBRO JSP: "+ID);
	LibroDAO dao = new LibroDAO();
	dao.guardarCambios(L);
	
	//System.out.println("FILAS MODIFICADAS: "+filas);	
	response.sendRedirect("MostrarLibros.do");
%>