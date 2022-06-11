<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@page import="javaEEJDBC.DataBaseException"%>
<%@page import ="java.util.List"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="beans.Categoria"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<link rel="stylesheet" href="css/tablas.css">
	<title>Lista de Categorias</title>
</head>
<body background="img/formulario.jpg">
	
	<div class=contenedor>
	<p class="navegar"><a href="MostrarLibros.do">Volver al Listado de Libros</a></p>
	<p class="navegar"><a href="FormularioInsertarCategoria.jsp">Insertar Nueva Categoria</a></p>
	<h2>Lista de Categorias</h2>

	<table class="tabla">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Borrar</th>
					<th>Editar</th>
					 
				</tr>
			</thead>
			<tbody>
					<c:forEach var="cat" items="${ListaDeCategorias}">
					<tr>
						<td>${cat.getid_cat()}</td>
						<td>${cat.getnom_cat()}</td>  
						<td><a href="BorrarCategoria.do?id=${cat.getid_cat()}">Borar</a></td>
						<td><a href="FormularioEditarCategoria.jsp?id=${cat.getid_cat()}">Editar</a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	
	
	</div>
</body >
</html>