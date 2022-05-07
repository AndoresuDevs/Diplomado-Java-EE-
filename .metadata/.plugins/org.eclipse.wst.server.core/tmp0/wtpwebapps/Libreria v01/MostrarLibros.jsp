<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="javaEEJDBC.DataBaseException"%>
<%@page import ="java.util.List"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="beans.Libro"%>
<%@page import="beans.Categoria"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<link rel="stylesheet" href="css/tablas.css">
	<title>Lista de Libros</title>
</head>
<body background="img/formulario.jpg">
	<div class=contenedor>
	<table>
	<thead>
		<tr>
			<th><a href="FormularioInsertarLibro.jsp">Insertar Nuevo Libro</a></th>
			<th><a href="MostrarProveedores.do">Proveedores</a></th>
		</tr>
	</thead>
	</table>
	
	
	
	
	<form action="ControladorLibros.do" method="GET">
	<p class="navegar">
		<br><label>Categorias disonibles: </label>
		<select name="categoria">
		<option value="Seleccionar">Seleccionar</option>
			<c:forEach var="cat" items="${ListaDeCategorias}">
				<option value ="${cat.getid_cat()}">${cat.getnom_cat()}</option>
			</c:forEach>		
		</select>
		<input type="submit" value="Filtrar" /> 
	</p>
	</form>
	<br><br> 
	<h2>Lista de libros</h2>
		<table class="tabla">
			<thead>
				<tr>
					<th>Numero</th>
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
						<td><a href="BorrarLibro.do?id=${lib.getnum_lib()}">Borar</a></td>
						<td><a href="FormularioEditarLibro.jsp?id=${lib.getnum_lib()}">Editar</a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	<br><br>
</body>
</html>