<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@page import="beans.Categoria"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<link rel="stylesheet" href="css/tablas.css">
	<link rel="stylesheet" href="css/navegacion.css">
	<link rel="stylesheet" href="css/fontello.css">
	<title>Lista de Categorias</title>
</head>
<body background="img/formulario.jpg">

<header class="header">
		<div class="container">
			<div class="btn-menu">
				<label for="btn-menu" class="icon-menu"></label>
			</div>
			<nav class="menu">
				<a href="#">Inicio</a>
				<a href="#">POR</a>
				<a href="#">SI SE</a>
				<a href="#">OCUPAN XD</a>
			</nav>
		</div>
	</header>

	<div class=contenedor>
	
	<h2>Lista de Categorias</h2>  
	<br>
	<a class="agregar" href="FormularioInsertarCategoria.jsp">Insertar Nueva Categoria</a>
	
	<label class="icon-icon-list-add" for="btn-menu"></label>
	
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
			<td><a class="icon-trash-empty" href="BorrarCategoria.do?id=${cat.getid_cat()}"></a></td>
			<td><a class="icon-pencil" href="FormularioEditarCategoria.do?id=${cat.getid_cat()}"></a></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
	
	<input type="checkbox" id="btn-menu">
	<div class="container-menu">
		<div class="cont-menu">
			<nav>
				<a href="MostrarLibros.do">Libros</a>
				<a href="MostrarProveedores.do">Proveedores</a>
				<a href="MostrarCategorias.do">Categorias</a>
				<a href="#">Proximamente</a>
				
			</nav>
			<label class="icon-cancel-circled" for="btn-menu"></label>
		</div>
	</div>
	
</body >
</html>