<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@page import="javaEEJDBC.DataBaseException"%>
<%@page import ="java.util.List"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="beans.Proveedor"%>
<%@page import="beans.Categoria"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<link rel="stylesheet" href="css/tablas.css">
	<title>Lista de Proveedores</title>
</head>
<body background="img/formulario.jpg">
	
	<div class=contenedor>
	<p class="navegar"><a href="MostrarLibros.do">Volver al Listado de Libros</a></p>
	<p class="navegar"><a href="FormularioInsertarProveedor.jsp">Insertar Nuevo Proveedor</a></p>
	<h2>Lista de libros</h2>

	<table class="tabla">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Telefono</th>
					<th>Dirección</th>
					<th>Borrar</th>
					<th>Modificar</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="prov" items="${ListaDeProveedores}">
					<tr>
						<td>${prov.getid_prov()}</td>
						<td>${prov.getnom_prov()}</td>
						<td>${prov.gettel_prov()}</td>
						<td>${prov.getdir_prov()}</td>
						<td><a href="BorrarProveedor.do?id=${prov.getid_prov()}">Borar</a></td>
						<td><a href="FormularioEditarProveedor.jsp?id=${prov.getid_prov()}">Editar</a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	
	
	</div>
</body >
</html>