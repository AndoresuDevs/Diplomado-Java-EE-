<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@page import="beans.Libro"%>
<%@page import="beans.Categoria"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<link rel="stylesheet" href="css/tablas.css">
	<link rel="stylesheet" href="css/navegacion.css">
	<link rel="stylesheet" href="css/fontello.css">
	<title>Lista de Libros</title>
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
		<h2>Lista de libros</h2>  
		<br>
		<a class="agregar" href="FormularioInsertarLibro.do">Insertar Nuevo Libro</a>

		<form action="ControladorLibros	.do" method="GET">
			<br><h4>Categorias disonibles: </h4>
			<div class="content-select">
				<select name="categoria">
					<option value="Seleccionar">Todas</option>
					<c:forEach var="cat" items="${ListaDeCategorias}">
						<option value ="${cat.getid_cat()}">${cat.getnom_cat()}</option>
					</c:forEach>		
				</select>
				<input class="btn-filtrar" type="submit" value="Filtrar" /> 
			</div>
			<br>
		</form>
		<br><br> 
		<table class="tabla">
			<thead>
				<tr>
					<th>ID</th>
					<th>ISBN</th>
					<th>Titulo</th>
					<th>Categoria</th>
					<th>Precio</th>
					<th>Borrar</th>
					<th>Modificar</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="lib" items="${ListaDeLibros}">
					<tr>
						<td>${lib.getnum_lib()}</td>
						<td>${lib.getisbn_lib()}</td>
						<td>${lib.gettit_lib()}</td>
						<c:forEach var="c" items="${ListaDeCategorias}">
							<c:if test="${c.getid_cat()==lib.getcat_lib()}">
								<td>${c.getnom_cat()}</td>
							</c:if>
						</c:forEach>
						<td>${lib.getpre_lib()}</td>
						<td><a class="icon-trash-empty" href="BorrarLibro.do?id=${lib.getnum_lib()}"></a></td>
						<td><a class="icon-pencil" href="FormularioEditarLibro.jsp?id=${lib.getnum_lib()}"></a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	<br><br>
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
</body>
</html>